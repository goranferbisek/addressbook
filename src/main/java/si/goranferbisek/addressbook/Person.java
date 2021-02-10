package si.goranferbisek.addressbook;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.ws.rs.Path;

@Path("/persons")
public class Person {
	@Id
	private Integer id;
	
	@Column(name = "name", nullable = false, length = 255)
	private String name;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
