import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;


public class Database {
	
	String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	String framework = "embedded";
    String protocol = "jdbc:derby:";
    Connection conn = null;
    ArrayList statements = new ArrayList(); 
    PreparedStatement psInsert = null;
    PreparedStatement psUpdate = null;
    Statement s = null;
    ResultSet rs = null;
    Properties props = new Properties();
    String dbName = "db";
	
	public void init() {
		try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(protocol + dbName, props);
			conn.setAutoCommit(false);
			s = conn.createStatement();
			statements.add(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean insert(Map<String, String> map) {
		try {
			psInsert = conn.prepareStatement("insert into main_table values("
					+ Integer.valueOf(map.get("id")) + ","
					+ Integer.valueOf(map.get("broj_glasaca")) + ","
					+ Integer.valueOf(map.get("broj_izaslo")) + ","
					+ Integer.valueOf(map.get("broj_nevazecih")) + ","
					+ Integer.valueOf(map.get("br1")) + ","
					+ Integer.valueOf(map.get("br2")) + ","
					+ Integer.valueOf(map.get("br3")) + ","
					+ Integer.valueOf(map.get("br4")) + ","
					+ Integer.valueOf(map.get("br5")) + ","
					+ Integer.valueOf(map.get("br6")) + ","
					+ Integer.valueOf(map.get("br7")) + ","
					+ Integer.valueOf(map.get("br8")) + ","
					+ Integer.valueOf(map.get("br9")) + ","
					+ Integer.valueOf(map.get("br10")) + ","
					+ Integer.valueOf(map.get("br11")) + ","
					+ Integer.valueOf(map.get("br12")) + ","
					+ Integer.valueOf(map.get("br13")) + ","
					+ Integer.valueOf(map.get("br14")) + ","
					+ Integer.valueOf(map.get("br15")) + ","
					+ Integer.valueOf(map.get("br16")) + ","
					+ Integer.valueOf(map.get("br17")) + ","
					+ Integer.valueOf(map.get("br18")) + ","
					+ Integer.valueOf(map.get("br19"))
					+ ")");
			statements.add(psInsert);
			psInsert.executeUpdate();
			conn.commit();
		} catch(SQLIntegrityConstraintViolationException e) {
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(Map<String, String> map) {
		try {
			psUpdate = conn.prepareStatement("update main_table set "
					+ "broj_glasaca=" + Integer.valueOf(map.get("broj_glasaca")) + ","
					+ "broj_izaslo=" + Integer.valueOf(map.get("broj_izaslo")) + ","
					+ "broj_nevazecih=" + Integer.valueOf(map.get("broj_nevazecih")) + ","
					+ "br1=" + Integer.valueOf(map.get("br1")) + ","
					+ "br2=" + Integer.valueOf(map.get("br2")) + ","
					+ "br3=" + Integer.valueOf(map.get("br3")) + ","
					+ "br4=" + Integer.valueOf(map.get("br4")) + ","
					+ "br5=" + Integer.valueOf(map.get("br5")) + ","
					+ "br6=" + Integer.valueOf(map.get("br6")) + ","
					+ "br7=" + Integer.valueOf(map.get("br7")) + ","
					+ "br8=" + Integer.valueOf(map.get("br8")) + ","
					+ "br9=" + Integer.valueOf(map.get("br9")) + ","
					+ "br10=" + Integer.valueOf(map.get("br10")) + ","
					+ "br11=" + Integer.valueOf(map.get("br11")) + ","
					+ "br12=" + Integer.valueOf(map.get("br12")) + ","
					+ "br13=" + Integer.valueOf(map.get("br13")) + ","
					+ "br14=" + Integer.valueOf(map.get("br14")) + ","
					+ "br15=" + Integer.valueOf(map.get("br15")) + ","
					+ "br16=" + Integer.valueOf(map.get("br16")) + ","
					+ "br17=" + Integer.valueOf(map.get("br17")) + ","
					+ "br18=" + Integer.valueOf(map.get("br18")) + ","
					+ "br19=" + Integer.valueOf(map.get("br19"))
					+ " where id=" + map.get("id"));
			
			statements.add(psUpdate);
			psUpdate.executeUpdate();
			conn.commit();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ResultSet select(String brojIzbornogMesta) {
		try {
			return s.executeQuery("SELECT * FROM main_table where id=" + brojIzbornogMesta);
		} catch (SQLException e) {
			return null;
		}
	}
	
}
