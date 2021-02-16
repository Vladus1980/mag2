package Les04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

	private Connection connection;
	private PreparedStatement preparedStatemant;
	User user = null;

	public UserDao(Connection connection) {
		

		this.connection = connection;
	}




	private static String CREATE = "insert into User(user_firstname, user_lastname, user_age, user_email, user_pass) value(?,?,?,?,?)";
	private static String READ_BY_ID = "select * from User where id = ?";
	private static String UPDATE_BY_ID = "update User set user_firstname =?, user_lastname=?, user_age=?, user_email=?, user_pass=? where id= ?";
	private static String DELETE_BY_ID = "delete from User where id = ?";
	private static String READ_ALL = "select * from User";

	public User insert(String user_firstname, String user_lastname, String user_age, String user_email, String user_pass, String user_level) throws SQLException {
		preparedStatemant = connection.prepareStatement(CREATE, preparedStatemant.RETURN_GENERATED_KEYS);
		preparedStatemant.setString(1, user_firstname);
		preparedStatemant.setString(2, user_lastname);
		preparedStatemant.setString(3, user_age);
		preparedStatemant.setString(4, user_email);
		preparedStatemant.setString(5, user_pass);
		preparedStatemant.setString(6, user_level);
		preparedStatemant.executeUpdate();
		return user;
	}

//	public User read(int id) throws SQLException {
//		preparedStatemant = connection.prepareStatement(READ_BY_ID);
//		preparedStatemant.setInt(1, id);
//		ResultSet resultSet = preparedStatemant.executeQuery();
//		resultSet.next();
//
//		return UserMapper.map(resultSet);
//
//	}
//	
//
//	public List<User> readAll() throws SQLException{
//		
//		List<User> userList = new ArrayList<User>();
//		preparedStatemant = connection.prepareStatement(READ_ALL);
//		ResultSet resultSet = preparedStatemant.executeQuery();
//		while (resultSet.next()) {
//			userList.add(UserMapper.map(resultSet));
//			
//		}
//		return userList;
//		
//	}


}