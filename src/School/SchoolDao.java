package School;

import java.sql.SQLException;
import java.util.List;

public interface SchoolDao {

	/**
	 * ע���²���
	 * 
	 * @param obj
	 * @return �ɹ�true,ʧ��false
	 */
	public boolean save(SchoolDept obj);

	/**
	 * 
	 * @return ���ز�����Ϣ�ļ��� @throws
	 */
	public List<SchoolDept> findAlls();

	/**
	 * �����û�id��ѯ���û�������Ϣ
	 * 
	 * @param id
	 *            �û�id
	 * @return �û�������Ϣ
	 */
	public SchoolDept find(Integer id);

}
