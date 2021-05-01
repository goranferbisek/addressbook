package si.goranferbisek.addressbook;

public class PersonDao {
	
	public Person get(int idPerson) {
		Person person = null;
		//Contact contact = null;
		
		//@PersistenceContext
		//EntityManager em;
			
			//person = session.get(Person.class, idPerson);
			
			// not shure this will work
			//contact = session.get(Contact.class, person.getId());

			//person.setContact(contact);
			return person;
	}
	
	public String save(Person person) {
		//Transaction transaction = null;
		String message = null;
		/*
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(person);
			transaction.commit();
			
			message = "Saved " + person.getName();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			message = "Failed saving" + person.getName() + "to database";
		}
		*/
		return message;
	}
	
	public Person delete(int idPerson) {
		/*
		Person person = null;
		Transaction transaction = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			person = session.get(Person.class, idPerson);
			session.delete(person);
			transaction.commit();
			
			return person;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}*/
		
		return null;
    }
}
