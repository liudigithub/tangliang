package School;

import java.util.Scanner;

public class TestDept {
	public static void main(String[] args) throws Exception {

		System.out.println("-------------------------------------------");
		System.out.println("1.编号查询\n2.整体查询\n3.注册新部门");
		System.out.println("请输入要操作编号:");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		// String j = sc.next();
		SchoolDaoimpl sd = new SchoolDaoimpl();
		Test t = new Test();
		switch (i) {
		case 3:
			t.TestfindAlls();
			break;
		case 2:
			sd.findAlls();
			break;

		default:
			System.out.println("无此操作!");
		}

	}
}
