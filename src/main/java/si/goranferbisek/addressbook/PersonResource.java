package si.goranferbisek.addressbook;

import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("person")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {
    
    @GET
    public Response getMessage() {
    	JsonObject json = Json.createObjectBuilder()
    			.add("message", "The API is working")
    			.build();
    	
        return Response.ok().entity(json).build();
    }
    
    @POST
    public Response savePerson() {
    	return Response.ok().build();
    }
    
}
