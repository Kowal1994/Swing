package data;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Users" )
public class Users {
	private List<User> users;
	
	public Users() {
		this.users = new ArrayList<User>();
	}
	
	public Users(List<User> users) {
		this.users = users;
	}

	@XmlElement ( name = "User" )
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
