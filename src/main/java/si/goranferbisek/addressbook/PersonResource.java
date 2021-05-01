package si.goranferbisek.addressbook;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("person")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {
	
    @GET
    public Response getAllPersons() {
    	//List<Person> persons = null;
    	
    	/*Jsonb jsonb = JsonbBuilder.create();
    	/Session session = HibernateUtil.getSessionFactory().openSession();
    	
    	try {
			persons = session.createQuery("FROM person").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}*/
    	
        //return Response.ok().entity(jsonb.toJson(persons.indexOf(1))).build();
    	return null;
    }
    
    @GET
	@Path("/{id}") 
	public Response findPerson(@PathParam("id") Integer id) {
		PersonDao dao = new PersonDao();
		Person person = dao.get(id);
		
		if (person != null) {
			return Response.ok().entity(person).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"No person found\"}").build();
		}
	}
    
    @POST
	public Response savePerson(Person person) {
		System.out.println(person.getName());
		PersonDao dao = new PersonDao();
		String message = dao.save(person);
		
		//Jsonb jsonb = JsonbBuilder.create();
		
		return Response.ok("{\"message\": \""+ message +"\"}\"").build();		
	}
	
	@DELETE
    @Path("/{id}")
	public Response removePerson(@PathParam("id") int id) {
		PersonDao dao = new PersonDao();
		Person person = dao.delete(id);
	
		if (person != null) {
			String jsonMessage = "{ \"message\": \"Person "+ person.getName() + " was deleted\" }";
			return Response.ok().entity(jsonMessage).build();
		}
		return Response.status(Response.Status.NOT_FOUND).entity("{ \" message\": \"person not found\"").build();
	}
    
}
