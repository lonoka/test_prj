package data;

public class EncryptTest {

	public static void main(String[] args) {
		String str = "md5 test";
		System.out.println("md5��ȣȭ ���� ���ڿ� : " + str);
		str = EncryptUtil.testMD5(str);
		System.out.println("md5��ȣȭ ���� ���ڿ� : " + str);
	}

}
