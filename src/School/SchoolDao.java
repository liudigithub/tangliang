package School;

import java.sql.SQLException;
import java.util.List;

public interface SchoolDao {

	/**
	 * 注册新部门
	 * 
	 * @param obj
	 * @return 成功true,失败false
	 */
	public boolean save(SchoolDept obj);

	/**
	 * 
	 * @return 返回部门信息的集合 @throws
	 */
	public List<SchoolDept> findAlls();

	/**
	 * 输入用户id查询该用户所有信息
	 * 
	 * @param id
	 *            用户id
	 * @return 用户所有信息
	 */
	public SchoolDept find(Integer id);

}
