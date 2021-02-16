package Les04;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {
	
	
	private List<User> listOfUsers = new ArrayList<>();
	private static UserService userService;
	
	
	private UserService() {
		
	}
	
	public static UserService getUserService() {
		if (userService == null) {
			userService = new UserService();
		}
		return userService;
	}
	
	public List<User> getListOfUsers(){
		return listOfUsers;
	}
	
	public void saveUser(User user) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		listOfUsers.add(user);
		UserDao userDao = new UserDao(ConnectionUtils.connection());
		userDao.insert(user.getUser_firstname(), user.getUser_lastname(), user.getUser_age(), user.getUser_email(), user.getUser_pass(), user.getUser_level());
		
	}
	
	public User getUser (String user_email) {
		return listOfUsers.stream().filter(user -> user.getUser_email().equals(user_email)).findAny().orElse(null);
	}

}
