package data;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class UserSeralize {
	public static void save(Users users) {
		File file = new File("table.xml");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(users, file);
		    } catch (JAXBException e) {
			e.printStackTrace();
		    }
		}
	}
}
