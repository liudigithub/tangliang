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
			System.out.println("数据库链接地址:" + url);
			System.out.println("数据库登录名:" + user);
			System.out.println("数据库登录密码:" + password);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("数据库链接成功!");

		} catch (SQLException sqle) {
			System.out.println("数据访问异常>>>");
			sqle.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("文件访问异常>>>");
			ioe.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("关闭异常>>>");
				e.printStackTrace();
			}
		}
	}
}
