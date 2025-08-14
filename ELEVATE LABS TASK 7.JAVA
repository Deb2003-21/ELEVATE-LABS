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

	// adding and deleting function
	public static void add_del(Connection c, String op) {
		try {
			Statement s = c.createStatement();
			int rowsAffected = s.executeUpdate(op);
			if (rowsAffected > 0) {
				System.out.println("executed");
			}
			s.close();
		} catch (Exception e) {
			System.out.print(e.toString());
		}
	}

	// updating function by id
	public static void update(Connection c, int id, String newName, String newSalary) {
		try {
			Statement s = c.createStatement();
			String sql = "UPDATE emp SET name = '" + newName + "', salary = '" + newSalary + "' WHERE id = " + id;
			int rowsAffected = s.executeUpdate(sql);
			if (rowsAffected > 0) {
				System.out.println("updated");
			} else {
				System.out.println("No record found with id: " + id);
			}
			s.close();
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
				System.out.println(r.getInt("id") + " " + r.getString("name") + " " + r.getString("salary"));
			}
			s.close();
			// Do not close connection here; close in main when done
		} catch (Exception e) {
			System.out.print(e.toString());
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// get connection
		Connection c = con();

		// add data
		System.out.print("enter id:");
		int id = sc.nextInt();
		System.out.print("enter name:");
		String name = sc.next();
		System.out.print("enter salary:");
		String sal = sc.next();

		add_del(c, "insert into emp values(" + id + ", '" + name + "' , '" + sal + "' )");
		// show data after adding
		show(c);

		// update data feature
		System.out.print("Do you want to update an employee by id? (yes/no): ");
		String updateChoice = sc.next();
		if (updateChoice.equalsIgnoreCase("yes")) {
			System.out.print("Enter id to update: ");
			int updateId = sc.nextInt();
			System.out.print("Enter new name: ");
			String newName = sc.next();
			System.out.print("Enter new salary: ");
			String newSalary = sc.next();
			update(c, updateId, newName, newSalary);
			// show data after updating
			show(c);
		}

		// deleting data
		System.out.print("enter id to delete:");
		int id2 = sc.nextInt();

		add_del(c, "delete from emp where id= " + id2);

		// show data after deleting
		show(c);

		try {
			c.close();
		} catch (Exception e) {
			System.out.print(e.toString());
		}

		sc.close();

	}
}