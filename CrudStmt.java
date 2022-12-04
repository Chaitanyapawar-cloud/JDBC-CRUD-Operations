package CRUDops;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Execute
{
	String url="jdbc:mysql://localhost:3306/jdb";
	String uname="root";
	String pass="Polonk@18";
	Connection con =null;
	Statement st=null;
	Scanner s=new Scanner(System.in);
	
public void MakeConnection() throws SQLException
{
	con=DriverManager.getConnection(url,uname,pass);
}

public void Select() throws SQLException
{
	System.out.println("Enter Rollno of Student whose info you want");
	int no=s.nextInt();
	String SelQuery="Select * from Students where rollno= "+no;
	if(con!=null)
		st=con.createStatement();
	if(st!=null) {
	ResultSet rs=st.executeQuery(SelQuery);
	rs.next();
	System.out.println("RollNo\tName\tDiv\tAddress");
	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));}
}

public void Insert() throws SQLException
{
	System.out.println("Enter Students Name");
	String Sname=s.next();
	System.out.println("Enter Students Div");
	String Sdiv=s.next();
	System.out.println("Enter Students Address");
	String Address=s.next();
	String InQuery="Insert into Students(Sname,Sdiv,Address) values('"+Sname+"','"+Sdiv+"','"+Address+"')" ;
	if(con!=null)
		st=con.createStatement();
	if(st!=null) {
	int ra= st.executeUpdate(InQuery);
	if(ra>0)
		System.out.println();
	System.out.println("Data Added Successfully");	
	}
}

public void Update() throws SQLException
{
	System.out.println("Enter Students Rollno whose data Update");
	int no=s.nextInt();
	System.out.println("Enter Students Name");
	String Sname=s.next();
	System.out.println("Enter Students Div");
	String Sdiv=s.next();
	System.out.println("Enter Students Address");
	String Address=s.next();
	String UpQuery="Update Students set Sname= '"+Sname+"',Sdiv='"+Sdiv+"',Address='"+Address+"' where rollno="+no ;
	if(con!=null)
		st=con.createStatement();
	if(st!=null) {
	int ra=st.executeUpdate(UpQuery);
	if(ra>0)
		System.out.println();}
	System.out.println("Data Updated Successfully");	
}

public void Delete() throws SQLException
{
	System.out.println("Enter Students Rollno whose data Delete");
	int no=s.nextInt();
	String UpQuery="Delete from Students where Rollno="+no+"" ;
	if(con!=null)
		st=con.createStatement();
	if(con!=null) {
	int ra=st.executeUpdate(UpQuery);
	if(ra>0)
		System.out.println("Data Deleted Successfully");}
}

public void CloseCon() throws SQLException
{
	if(con!=null)
		con.close();
}
	
	
}

public class CrudStmt {

	public static void main(String[] args) throws SQLException {
		 System.out.println("\tWelecome to Student Management System");
		 System.out.println("  ****************************************************");
		 System.out.println("\tSelect Operation to perform\n");
		 System.out.println("1.\tGet Students Information on Rollno");
		 System.out.println("2.\tAdd new Students Data");
		 System.out.println("3.\tUpdate Existing Students Data");
		 System.out.println("4.\tDelete Students Data");
		 Execute e=new Execute();
		 try {
		 
		 Scanner sc=new Scanner(System.in);
		 int option = sc.nextInt();
		 e.MakeConnection();
		 switch(option)
		 {
		 case 1:e.Select();
		        break;
		 case 2: e.Insert();
			    break;
		 case 3: e.Update();
			    break;
		 case 4: e.Delete();
			    break;
		 default:break;
		 }
		 }
		 catch(Exception er)
		 {
			 er.getMessage();
		 }
		 finally {
			 e.CloseCon();
		 }
		

	}

}
