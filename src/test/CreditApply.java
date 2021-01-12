package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/credit")
public class CreditApply {
	int id;
	private String firstName;
	private String lastName;
	private int ssn;
	private int annual_income;
	
	public CreditApply() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CreditApply(int id) {
		super();
		this.id = id;
	}

	
	public CreditApply(int id, String firstName, String lastName, int ssn, int annual_income) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.annual_income = annual_income;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSsn() {
		return ssn;
	}


	public void setSsn(int ssn) {
		this.ssn = ssn;
	}


	public int getAnnual_income() {
		return annual_income;
	}


	public void setAnnual_income(int annual_income) {
		this.annual_income = annual_income;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annual_income;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ssn;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditApply other = (CreditApply) obj;
		if (annual_income != other.annual_income)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (ssn != other.ssn)
			return false;
		return true;
	}


	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayServerResponse() {
		String resource = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
	"<hello> Hello Response from XML server side</hello>";
		return resource;
	}


	@GET
	@Produces(MediaType.TEXT_HTML)
	public String creditCardApplication(@QueryParam("name") String name, 
			@QueryParam("credit_score") int credit_score) {
		String application = null;
		if (credit_score<600)
		{
			application ="Credit application not approved";
		}
		else {
			application = "Credit application approved";
		}
		return "<html>"+"<title>"+"Credit Card Application for "+ name +"</title>"+"<body> <h1>"
		+application+"</h1></body></html>";
	}

}