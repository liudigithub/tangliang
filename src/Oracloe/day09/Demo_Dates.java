package Oracloe.day09;

import org.apache.commons.dbcp.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo_Dates {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			BasicDataSource bds = new BasicDataSource();// 创建连接池对象
			bds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			bds.setUsername("scott");
			bds.setPassword("tiger");
			bds.setInitialSize(10);// 链接对象初始化个数
			bds.setMaxActive(100);// 最大活动链接数量
			bds.setMaxIdle(50);// 最大空闲数量
			bds.setMinIdle(20);// 最小空闲数量
			bds.setMaxWait(1000);// 最大等待时长

			conn = bds.getConnection();
			System.out.println("访问成功！");
		} catch (SQLException e) {
			System.out.println("访问数据异常>>>");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("数据关闭异常>>>");
				e.printStackTrace();
			}
		}
	}
}
