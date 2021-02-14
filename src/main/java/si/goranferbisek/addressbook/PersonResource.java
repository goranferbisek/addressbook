package si.goranferbisek.addressbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;


@Path("person")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {
    
	@GET
	@Path("test")
	public Response test() {
		String url= "jdbc:mysql://192.168.10.10:3306/addressbook?useSSL=false";
		String user= "homestead";
		String password = "secret";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			
			String query = "INSERT INTO person(name) VALUES ('Fabio Quartararo')";
			Statement statement = connection.createStatement();
			statement.execute(query);
			
			return Response.ok().entity("Connection OK").build();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return Response.ok().entity("Class not found").build();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return Response.ok().entity("SQLException").build();
		}
		
	}
	
	@GET
	@Path("test2")
	public Response test2() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Person p = new Person("Danilo Petrucci");
		session.persist(p);
		
		session.getTransaction().commit();
		session.close();
		
		return Response.ok().entity(JsonbBuilder.create().toJson(p)).build();
	}
	
    @GET
    public Response getAllPersons() {
    	List<Person> persons = null;
    	
    	Jsonb jsonb = JsonbBuilder.create();
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	
    	try {
			persons = session.createQuery("FROM person").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
    	
        return Response.ok().entity(jsonb.toJson(persons.indexOf(1))).build();
    }
    
    @GET
	@Path("/{id}") 
	public Response findPerson(@PathParam("id") Integer id) {
		PersonDao dao = new PersonDao();
		Person person = dao.get(id);
		
		if (person != null) {
			return Response.status(Response.Status.CREATED).entity(person).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"No person found\"}").build();
		}
	}
    
    @POST
    public Response savePerson(Person person) {
    	Jsonb jsonb = JsonbBuilder.create();
    	System.out.println(person.getName());
    	return Response.ok(jsonb.toJson(person)).build();
    }
    
}
