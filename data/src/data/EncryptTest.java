package data;

public class EncryptTest {

	public static void main(String[] args) {
		String str = "md5 test";
		System.out.println("md5암호화 이전 문자열 : " + str);
		str = EncryptUtil.testMD5(str);
		System.out.println("md5암호화 이후 문자열 : " + str);
	}

}
