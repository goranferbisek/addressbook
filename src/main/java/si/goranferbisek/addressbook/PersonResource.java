package si.goranferbisek.addressbook;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Sample JAX-RS resources.
 *
 */
@Path("person")
@RequestScoped
public class PersonResource {
    
    @GET
    public String getMessage() {
        return "Hello, world";
    }
    
}
