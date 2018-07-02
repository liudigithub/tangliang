package Oracloe.day09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Commit {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		String url = "jdbc:Oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String password = "tiger";
		System.out.println("������ת��������:");
		Scanner sc = new Scanner(System.in);
		String uersName = sc.next();
		System.out.println("����������������:");
		String sName = sc.next();

		try {
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);

			String sql = "update mep set sal = sal - 100 where eName = '" + uersName + "'";
			String sql2 = "update emp set sal = sal + 100 where eName = '" + sName + "'";
			stmt = conn.createStatement();

			int asq1 = stmt.executeUpdate(sql);
			int bsql = stmt.executeUpdate(sql2);

			if (asq1 > 0 && bsql > 0) {
				conn.commit();
				System.out.println("ת�˳ɹ�!");
			} else
				System.out.println("ת��ʧ��!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
