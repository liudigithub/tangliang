package School;

import java.util.Date;
import java.util.Scanner;

public class Test {
	public void TestfindAlls() {

		System.out.println("������Id:");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		System.out.println("�������û���:");
		String name = sc.next();
		System.out.println("����������:");
		int pw = sc.nextInt();
		System.out.println("��������:");
		int no = sc.nextInt();

		// String d = sc.next();

		Date d = new Date();
		// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM--dd");

		SchoolDept sd = new SchoolDept(id, name, pw, no, d);
		SchoolDaoimpl sd1 = new SchoolDaoimpl();
		Boolean flag = sd1.save(sd);
		if (flag) {
			System.out.println("����û��ɹ���");
		} else {
			System.out.println("����û�ʧ�ܣ�");
		}

	}
}
