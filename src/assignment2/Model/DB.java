package assignment2.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DB {
	Connection conn = null;
	
	public DB() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?" +
				    	                                   "user=root&password=abcd1234");
			 conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public Connection getDB() {
		return conn;
	}
	
	public void insertStudent(Student stud) throws SQLException {
		
		String sql = "INSERT INTO db1.STUDENTMARK VALUES (?,?,?,?)";
		PreparedStatement ps = getDB().prepareStatement(sql);
		ps.setInt(1, stud.getID());
		ps.setString(2, stud.getName());
		ps.setInt(3, stud.getMathmark());
		ps.setInt(4, stud.getSciencemark());
		ps.execute();
		getDB().commit();
	}
	
	public ArrayList<Student> readStudents() throws SQLException {
		String sql = "SELECT * FROM db1.studentmark";
		PreparedStatement ps = getDB().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Student> studs = new ArrayList<Student>();
		
		while(rs.next()) {
			Student stud = new Student();
			stud.setID(rs.getInt(1));
			stud.setName(rs.getString(2));
			stud.setMathmark(rs.getInt(3));
			stud.setSciencemark(rs.getInt(4));
			studs.add(stud); 
		}
		
		return studs;
	}
}
