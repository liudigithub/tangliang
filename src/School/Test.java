package School;

import java.util.Date;
import java.util.Scanner;

public class Test {
	public void TestfindAlls() {

		System.out.println("请输入Id:");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		System.out.println("请输入用户名:");
		String name = sc.next();
		System.out.println("请输入密码:");
		int pw = sc.nextInt();
		System.out.println("请输入编号:");
		int no = sc.nextInt();

		// String d = sc.next();

		Date d = new Date();
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM--dd");

		SchoolDept sd = new SchoolDept(id, name, pw, no, d);
		SchoolDaoimpl sd1 = new SchoolDaoimpl();
		Boolean flag = sd1.save(sd);
		if (flag) {
			System.out.println("添加用户成功！");
		} else {
			System.out.println("添加用户失败！");
		}

	}
}
