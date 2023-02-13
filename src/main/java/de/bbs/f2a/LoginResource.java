package de.bbs.f2a;

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

  private String checkPasswordAndGenerateToken( String user, String password )
  {

    System.out.println(dataService.getBenutzerData());
    System.out.println(dataService.getAuthData());

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
    return "8J+NlfCfjZXwn42VIFN1cGVyIGdlaGVpbWVyIFRleHQg8J+NlfCfjZXwn42V";
  }

}
