package SerializationDeserialization;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.Api.Generics.PojoLibrary;

/*Java Objct to Json value*/

public class Serialization {
	@Test
	public void serial() throws Throwable {
//		creating java object
		PojoLibrary plib = new PojoLibrary("Milu m","nvdia","just started", 4);
//		parser 
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./jsonValue.json"), plib);
	}
}

class Serialization2 {
	@Test
	public void serial() throws Throwable {
		/*This is not java object to Json*/
		
		File f=new File("./src/test/resources/jsonData.json");
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./jsonValue2.json"), f);
	}
}
class Serialization3 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void serial() throws Throwable {
		Random random=new Random();
		int randomInt = random.nextInt(1000);
		
		HashMap hobj=new HashMap();
		hobj.put("createdBy","MILU");
		hobj.put("projectName","api"+randomInt);
		hobj.put("status","completed");
		hobj.put("teamSize",randomInt);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./jsonValue2.json"), hobj);
	}
}
