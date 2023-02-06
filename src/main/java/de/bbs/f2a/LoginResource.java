package de.bbs.f2a;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/login")
public class LoginResource {

    @GET
    @Path("/form")
    @Produces(MediaType.TEXT_HTML)
    public String renderLoginForm() {
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
    @Path("/check")
    @Produces(MediaType.TEXT_HTML)
    public String renderLoginResult(String user, String password) {
        String token = checkPasswordANdGenerateToken(user, password);

        if(token!=null)
           return "<p>Hallo " + user + "!</p><a href='/?token=" + token + "'>Hier gehts zum Spiel!</a>";
        else
            throw new RuntimeException("Login failed");
    }

    private String checkPasswordANdGenerateToken(String user, String password) {
        return null;
    }
}