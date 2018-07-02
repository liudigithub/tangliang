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
	 * 获得数据库链接对象
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
				System.out.println("查询结果集关闭异常...");
				e2.printStackTrace();
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e1) {
				System.out.println("语句执行对象关闭异常...");
				e1.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("数据链接对象关闭异常...");
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
			System.out.println("新用户注册异常...");
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
			System.out.println("查询用户信息失败！");
			// TODO Auto-generated catch block
			e.printStackTrace();
			close(rs, pst, conn);
			return null;
		}
	}

	public static void main(String[] args) throws Exception {

		// List<SchoolDept> list = new SchoolDaoimpl().findAlls();
		// for (SchoolDept schoolDept : list) {
		// System.out.println("学号是："+schoolDept.getId()+",用户名是："+schoolDept.getName()+",密码是："+schoolDept.getPassword()+",是否是管理员："+schoolDept.getNo()+",创建时间是："+schoolDept.getTt());
		// }

		SchoolDept s = new SchoolDaoimpl().find(1001);
		if (s != null) {
			System.out
					.println(s.getId() + "," + s.getName() + "," + s.getPassword() + "," + s.getNo() + "," + s.getTt());
		} else {
			System.out.println("未获取到用户信息！");
		}
	}
}
