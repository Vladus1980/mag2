package Les04;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
	
	public static User map(ResultSet result) throws SQLException {
		
		String user_firstname = result.getString("user_firstname");
		String user_lastname = result.getString("user_lastname");
		String user_age = result.getString("user_age");
		String user_email = result.getString("user_email");
		String user_pass = result.getString("user_pass");
		String user_level = result.getString("user_level");
		
		return new User (user_firstname, user_lastname, user_age, user_email, user_pass, user_level);
		
	}

}
