/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// End of user code

/**
 * Description of ConnectionDB.
 * 
 * @author kevine2710
 */
public class ConnectionDB {
	
		private static String url = "jdbc:postgresql://ec2-107-20-148-211.compute-1.amazonaws.com:5432/d5nv3aotjuj9pl?sslmode=require";
		private static String user = "oykxnuoftscyoh";
		private static String password = "2gUPawazMrxePbk-HTcSxwl43m";
		private static boolean instance = false;
		private static ConnectionDB db;
		private Connection conn;
				
		private ConnectionDB() {
			try {
				Class.forName("org.postgresql.Driver");
				this.conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		public static ConnectionDB creetConnectionDB() {
			if (!instance) {
				db = new ConnectionDB();
				instance = true;
			}
			return db;
		}

		public Connection getConn() {
			return conn;
		}

}
