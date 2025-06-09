package Testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class ConnectingToMySQL {
	@Test
	public void establishConnection() throws SQLException, ClassNotFoundException {
//		String userName="Shashank";
//		String pwd="Shashank@123";
		String userName = "shashank.k";
		String pwd = "Is2xe7eet>aeQuoh";
		String querry = "select * from zoodel.Customer where telephone like '%852366413'";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection driver = DriverManager.getConnection("jdbc:mysql://uat-mysql-cl1.htz:3306/zoodel", userName, pwd);
		Statement statement = driver.createStatement();
		ResultSet resulSet = statement.executeQuery(querry);
		System.out.println(resulSet);
		while (resulSet.next()) {
			String res = resulSet.getString("id");
			System.out.println(res);
//			URL res1 = resulSet.getURL(1);
//			System.out.println(res1);

		}
	}

}
