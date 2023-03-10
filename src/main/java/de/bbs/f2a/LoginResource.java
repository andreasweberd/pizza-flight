package de.bbs.f2a;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.List;

import de.bbs.f2a.model.Auth;
import de.bbs.f2a.model.Benutzer;

@Path( "/login" )
public class LoginResource
{
  @Inject DataService dataService;

  @GET
  @Path( "/form" )
  @Produces( MediaType.TEXT_HTML )
  public String renderLoginForm()
  {
    return """
         <p>Hallo Fremder!</p>
         <form action="/login/check" method="POST">
             <label for="user"><b>Benutzername</b></label>
             <input type="text" placeholder="Bitte Benutzernamen eingeben" name="user" id="user" required>
         
             <label for="password"><b>Passwort</b></label>
             <input type="password" placeholder="Bitte Passwort eingeben" name="password" id="password" required>
         
             <button type="submit">Login</button>
         </form>
        """;
  }

  @POST
  @Path( "/check" )
  @Produces( MediaType.TEXT_HTML )
  public String renderLoginResult(@FormParam("user") String user, @FormParam("password")String password )
  {
    String token = checkPasswordAndGenerateToken( user, password );

    if ( token != null )
      return "<p>Hallo " + user + "!</p><a href='/?token=" + token + "'>Hier gehts zum Spiel!</a>";
    else
      throw new RuntimeException( "Login failed" );
  }

  @GET
  @Path( "/tokenOK" )
  @Produces( MediaType.TEXT_PLAIN )
  public String tokenOK(@QueryParam("user") String username, @QueryParam("token")String tokenInput )
  {
    Benutzer b = dataService.getBenutzerData( username );
    String token = generateToken(null, b);
    if(token.equals(tokenInput))return "ok";
    return "";
  }

  private String checkPasswordAndGenerateToken( String user, String password )
  {

    Benutzer b = dataService.getBenutzerData( user );
    if ( b == null )
      return null;

    List<Auth> a = dataService.getAuthData( b );
    if ( a.isEmpty() )
      return null;

    for ( final Auth auth : a )
    {
      if ( dataService.getHash( password ).equals( auth.getPassword() ) )
        return generateToken( a, b );
    }

    return null;
  }

  private String generateToken( final List<Auth> a, final Benutzer b )
  {
    try {

      char[] idAsCharArray = String.valueOf(b.getId()).toCharArray();
      byte[] salt = String.valueOf(b.getId()).getBytes(StandardCharsets.UTF_8);
      KeySpec spec = new PBEKeySpec(idAsCharArray,
              salt,
              1, 128);

      SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
      byte[] hash = f.generateSecret(spec).getEncoded();
      Base64.Encoder enc = Base64.getEncoder();
      return enc.encodeToString(hash);



    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
