package Oracloe.day09;

import org.apache.commons.dbcp.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo_Dates {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			BasicDataSource bds = new BasicDataSource();// �������ӳض���
			bds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			bds.setUsername("scott");
			bds.setPassword("tiger");
			bds.setInitialSize(10);// ���Ӷ����ʼ������
			bds.setMaxActive(100);// �����������
			bds.setMaxIdle(50);// ����������
			bds.setMinIdle(20);// ��С��������
			bds.setMaxWait(1000);// ���ȴ�ʱ��

			conn = bds.getConnection();
			System.out.println("���ʳɹ���");
		} catch (SQLException e) {
			System.out.println("���������쳣>>>");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("���ݹر��쳣>>>");
				e.printStackTrace();
			}
		}
	}
}
