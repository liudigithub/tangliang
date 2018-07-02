package School;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SchoolDaoimpl implements SchoolDao {

	/**
	 * ������ݿ����Ӷ���
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConn() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String password = "tiger";
		return DriverManager.getConnection(url, user, password);
	}

	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e2) {
				System.out.println("��ѯ������ر��쳣...");
				e2.printStackTrace();
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e1) {
				System.out.println("���ִ�ж���ر��쳣...");
				e1.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("�������Ӷ���ر��쳣...");
				e.printStackTrace();
			}
	}

	@Override
	public boolean save(SchoolDept obj) {
		boolean isOk = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = this.getConn();
			String sql = "insert into SchoolDept values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, obj.getId());
			pstmt.setString(2, obj.getName());
			pstmt.setInt(3, obj.getPassword());
			pstmt.setInt(4, obj.getNo());
			pstmt.setDate(5, new Date(System.currentTimeMillis()));
			int row = pstmt.executeUpdate();
			isOk = row > 0 ? true : false;

		} catch (SQLException e) {
			System.out.println("���û�ע���쳣...");
			e.printStackTrace();
		} finally {
			this.close(null, pstmt, conn);
		}

		return isOk;
	}

	@SuppressWarnings("finally")
	@Override
	public List<SchoolDept> findAlls() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			pst = conn.prepareStatement("select * from schooldept");
			rs = pst.executeQuery();
			List<SchoolDept> list = new ArrayList<SchoolDept>();
			while (rs.next()) {
				SchoolDept tSchoolDept = new SchoolDept();
				// System.out.println(rs.getInt(1));
				// System.out.print(rs.getString(2));
				// System.out.print(rs.getInt(3));
				// System.out.print(rs.getInt(4));
				// System.out.print(rs.getDate(5));
				tSchoolDept.setId(rs.getInt(1));
				tSchoolDept.setName(rs.getString(2));
				tSchoolDept.setPassword(rs.getInt(3));
				tSchoolDept.setNo(rs.getInt(4));
				tSchoolDept.setTt(rs.getDate(5));
				list.add(tSchoolDept);
			}
			close(rs, pst, conn);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			close(rs, pst, conn);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public SchoolDept find(Integer id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			pst = conn.prepareStatement("select * from schooldept where id=?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			System.out.println(rs.next() == true);
			// System.out.println(rs.getInt(1));
			// System.out.println(rs.getInt(1));
			// System.out.print(rs.getString(2));
			// System.out.print(rs.getInt(3));
			// System.out.print(rs.getInt(4));
			// System.out.print(rs.getDate(5));
			SchoolDept tSchoolDept = new SchoolDept();
			tSchoolDept.setId(rs.getInt(1));
			tSchoolDept.setName(rs.getString(2));
			tSchoolDept.setPassword(rs.getInt(3));
			tSchoolDept.setNo(rs.getInt(4));
			tSchoolDept.setTt(rs.getDate(5));
			close(rs, pst, conn);
			return tSchoolDept;
		} catch (SQLException e) {
			System.out.println("��ѯ�û���Ϣʧ�ܣ�");
			// TODO Auto-generated catch block
			e.printStackTrace();
			close(rs, pst, conn);
			return null;
		}
	}

	public static void main(String[] args) throws Exception {

		// List<SchoolDept> list = new SchoolDaoimpl().findAlls();
		// for (SchoolDept schoolDept : list) {
		// System.out.println("ѧ���ǣ�"+schoolDept.getId()+",�û����ǣ�"+schoolDept.getName()+",�����ǣ�"+schoolDept.getPassword()+",�Ƿ��ǹ���Ա��"+schoolDept.getNo()+",����ʱ���ǣ�"+schoolDept.getTt());
		// }

		SchoolDept s = new SchoolDaoimpl().find(1001);
		if (s != null) {
			System.out
					.println(s.getId() + "," + s.getName() + "," + s.getPassword() + "," + s.getNo() + "," + s.getTt());
		} else {
			System.out.println("δ��ȡ���û���Ϣ��");
		}
	}
}
