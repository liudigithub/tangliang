package School;

import java.util.Scanner;

public class TestDept {
	public static void main(String[] args) throws Exception {

		System.out.println("-------------------------------------------");
		System.out.println("1.��Ų�ѯ\n2.�����ѯ\n3.ע���²���");
		System.out.println("������Ҫ�������:");
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
			System.out.println("�޴˲���!");
		}

	}
}
