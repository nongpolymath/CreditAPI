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
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayServerResponse() {
		String resource = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
	"<hello> Hello Response from XML server side</hello>";
		return resource;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJSON() {
		String resource = null;
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