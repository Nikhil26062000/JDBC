import java.sql.*;

public class DemoClass {

	public static void main(String[] args) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/nikdb";
		String uname = "root";
		String pass = "mysql@kiit@123";//mysql@kiit@123
		String query = "select sname from student where rollno=3";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		rs.next();
		String name = rs.getString("sname");
		System.out.println(name);
		
		st.close();
		con.close();
	}
}
