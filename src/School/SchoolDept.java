package School;

import java.util.Date;

public class SchoolDept {
	private int id;
	private String name;
	private int password;
	private int no;
	private Date tt;

	public SchoolDept() {
		super();
	}

	public SchoolDept(int id, String name, int password, int no, Date tt) {
		super();
		setId(id);
		setName(name);
		setPassword(password);
		setNo(no);
		setTt(tt);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		if (no == 0 || no == 1)
			this.no = no;
		else
			System.out.println("权限信息错误!");
	}

	public Date getTt() {
		return tt;
	}

	public void setTt(Date tt) {
		this.tt = tt;
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", password=" + password + ", no=" + no + ", tt=" + tt + "]";
	}

}
