package si.goranferbisek.addressbook;

import javax.enterprise.context.RequestScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
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
    	Person person = new Person("Jane Doe");
    	Jsonb jsonb = JsonbBuilder.create();
    	
        return Response.ok().entity(jsonb.toJson(person)).build();
    }
    
    @POST
    public Response savePerson(Person person) {
    	Jsonb jsonb = JsonbBuilder.create();
    	return Response.ok(jsonb.toJson(person)).build();
    }
    
}
