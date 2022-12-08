import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SqlDateStore {

	public static void main(String[] args) throws ParseException, SQLException {
		Connection con=null;
		PreparedStatement pst=null;
		try {
			String url="jdbc:mysql:///csp";
			String uname="root";
			String pass="Polonk@18";
			con=DriverManager.getConnection(url,uname,pass);
			
			System.out.println("Enter name");
			Scanner sc=new Scanner(System.in);
			String Fname=sc.next();
			System.out.println("Enter Address");
			String Addr=sc.next();
			System.out.println("Enter Gender");
			String Gender=sc.next();
			System.out.println("Enter DOB dd-MM-yyyy");
			String DOB=sc.next();
			System.out.println("Enter DOJ MM-dd-yyyy");
			String DOJ=sc.next();
			System.out.println("Enter DOM yyyy-MM-dd");
			String DOM=sc.next();
			
			SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date ud1=sdf1.parse(DOB);
			java.sql.Date sd1=new java.sql.Date(ud1.getTime());
			
			SimpleDateFormat sdf2=new SimpleDateFormat("MM-dd-yyyy");
			java.util.Date ud2=sdf2.parse(DOJ);
			java.sql.Date sd2=new java.sql.Date(ud1.getTime());
			
			
			java.sql.Date sd3=java.sql.Date.valueOf(DOM);
			
			
			String Query="Insert into Dates values(?,?,?,?,?,?)";
			if (con!=null) {
			 pst=con.prepareStatement(Query);
			 pst.setString(1, Fname);
			 pst.setString(2,Addr);
			 pst.setString(3,Gender);
			 pst.setDate(4, sd1);
			 pst.setDate(5, sd2);
			 pst.setDate(6, sd3);
			}
			if(pst!=null)
			{
				pst.executeUpdate();
			}
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			if (con!=null)
			{
				con.close();
			}
		}

	}

}
