package data;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UserDeserialize {
	public static List<User> load() {
		Users users = new Users();
		File file = new File("table.xml");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			users = (Users) jaxbUnmarshaller.unmarshal(file);
			return users.getUsers();
		  	} catch (JAXBException e) {
			e.printStackTrace();
		  	}
		return users.getUsers();
	}
}
