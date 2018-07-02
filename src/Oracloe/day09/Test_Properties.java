package Oracloe.day09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class Test_Properties {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String url = null;
		String user = null;
		String password = null;

		try {
			Properties pro = new Properties();
			FileInputStream fis = new FileInputStream("file/db.properties");
			pro.load(fis);
			url = pro.getProperty("xdl.url");
			user = pro.getProperty("xdl.user");
			password = pro.getProperty("xdl.password");
			System.out.println("���ݿ����ӵ�ַ:" + url);
			System.out.println("���ݿ��¼��:" + user);
			System.out.println("���ݿ��¼����:" + password);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("���ݿ����ӳɹ�!");

		} catch (SQLException sqle) {
			System.out.println("���ݷ����쳣>>>");
			sqle.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("�ļ������쳣>>>");
			ioe.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("�ر��쳣>>>");
				e.printStackTrace();
			}
		}
	}
}
