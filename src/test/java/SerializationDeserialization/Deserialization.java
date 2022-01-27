package SerializationDeserialization;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.Api.Generics.PojoLibrary;

/*Json to java Object*/
public class Deserialization {
	@Test
	public void serial() throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		PojoLibrary pojo = mapper.readValue(new File("./JsonValue"), PojoLibrary.class);//PojoLibrary.class => Value Type
		System.out.println(pojo.getCreatedBy());
		System.out.println(pojo.getCreatedBy());
		System.out.println(pojo.projectName);
		System.out.println(pojo.status);
		System.out.println(pojo.teamSize);
	
	}
}
