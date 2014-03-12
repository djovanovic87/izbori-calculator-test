import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;


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
	
	public void insert() {
		try {
			psInsert = conn.prepareStatement("insert into main_table(id, broj_glasaca, broj_izaslo, broj_nevazecih) values(6, 200, 169, 19)");
			statements.add(psInsert);
			psInsert.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
	}

	public ResultSet select() {
		try {
			return s.executeQuery("SELECT id, broj_glasaca, broj_izaslo, broj_nevazecih FROM main_table");
//			while(rs.next()) {
//				JOptionPane.showMessageDialog(null, "id: " + rs.getInt("id") + "broj glasaca: " + rs.getInt("broj_glasaca") + "broj izaslo: " + rs.getInt("broj_izaslo") + "broj nevazecih: " + rs.getInt("broj_nevazecih"));
//				System.out.println("id: " + rs.getInt("id"));
//				System.out.println("broj glasaca: " + rs.getInt("broj_glasaca"));
//				System.out.println("broj izaslo: " + rs.getInt("broj_izaslo"));
//				System.out.println("broj nevazecih: " + rs.getInt("broj_nevazecih"));
//				System.out.println("\n");
//			}
//			conn.commit();
		} catch (SQLException e) {
			return null;
		}
	}
	
}
