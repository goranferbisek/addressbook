package si.goranferbisek.addressbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

import org.hibernate.Session;
import org.hibernate.Transaction;


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
    public Response getAllPersons() {
    	// test one person
    	Person person = null;
		Transaction transaction = null;
    	Jsonb jsonb = JsonbBuilder.create();
    	
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			person = session.get(Person.class, new Integer(16));
			System.out.println("Hello" + person.getName());
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
    	
        return Response.ok().entity(jsonb.toJson(person)).build();
    }
    
    @POST
    public Response savePerson(Person person) {
    	Jsonb jsonb = JsonbBuilder.create();
    	System.out.println(person.getName());
    	return Response.ok(jsonb.toJson(person)).build();
    }
    
}
