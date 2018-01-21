

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author auron
 */
public class DBConnector {
	private Connection connection = null;
	
	//Constants
	private static final String IP	     = "localhost";
	private static final int    PORT     = 3306;

    /**
     *
     */
    public static final String DATABASE  = "Glazier";
	private static final String USERNAME = "newuser"; 
	private static final String PASSWORD = "1234";	     	
	
    /**
     *
     * @throws Exception
     */
    public DBConnector() throws Exception {
   		Class.forName("com.mysql.jdbc.Driver").newInstance();
   		String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
   		this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
	}
	
    /**
     *
     * @return
     */
    public Connection getConnection() {
   		return this.connection;
	}

}