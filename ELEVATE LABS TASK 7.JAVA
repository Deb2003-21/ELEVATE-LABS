
package jdbc1;

import java.sql.*;
import java.util.Scanner;

public class JdbcConnect {

	// main connection method
	public static Connection con() {
		Connection conn = null;
		String url = "jdbc:mariadb://localhost:3306/db1";
		String user = "root";
		String pass = "hatua";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected!");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}

	// adding and delteing function
	public static void add_del(Connection c, String op) {
		try {
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(op);
			if (r.next()) {
				System.out.println("executed");
			}
		} catch (Exception e) {
			System.out.print(e.toString());
		}
	}

	// showing data
	public static void show(Connection c) {
		try {
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery("select * from emp");
			while (r.next()) {
				System.out.println(r.getString("name") + " " + r.getString("salary"));
			}
			s.close();
			c.close();
		} catch (Exception e) {
			System.out.print(e.toString());
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("enter id:");
		int id = sc.nextInt();
		System.out.print("enter name:");
		String name = sc.next();
		System.out.print("enter salary:");
		String sal = sc.next();

		// get connection
		Connection c = con();

		// add data
		add_del(c, "insert into emp values(" + id + ", '" + name + "' , '" + sal + "' )");
		// show data after adding
		show(c);

		// deleting data
		System.out.print("enter id:");
		int id2 = sc.nextInt();

		add_del(c, "delete from emp where id= " + id2);

		// show data after deleting
		show(c);

		sc.close();

	}
}
