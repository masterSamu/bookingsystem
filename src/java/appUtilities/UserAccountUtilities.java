package appUtilities;

import java.util.List;

import dao.Dao;
import data.Users;
import encrypt.PasswordUtils;

public class UserAccountUtilities {
	static Dao dao = new Dao();

	public static boolean validateUser(String username, String password) {
		List<Users> userList = getSingleUserCredentialsFromDatabase(username);
		
		return PasswordUtils.verifyUserPassword(password, userList.get(0).getPassword(), 
				userList.get(0).getSalt());
	}
	
	public static boolean checkIfUserExist(String username) {
		boolean userExist = false;
		if(getSingleUserCredentialsFromDatabase(username).size() > 0) {
			userExist = true;
		}
		return userExist;
	}
	
	private static List<Users> getSingleUserCredentialsFromDatabase(String username) {
		return dao.readUserCredentials(username);
	}
}
