package webservices;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response; //JAX-RS

public class HellowWS {
        @Path("/hi") //URL for the neb service  */
        @GET //http methode 
        @Produces(MediaType.TEXT_PLAIN) //type of data

    public Response sayHi() {
 return Response.status(200)
 .entity("Hello, World!")
 .build();
    }
    
  


}
