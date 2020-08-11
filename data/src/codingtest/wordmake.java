package codingtest;

public class wordmake {

	public static void main(String[] args) {
		String name = "ZAZ";
		solution(name);
	}

	public static int solution(String name) {
		int answer = 0;
		String[] sArr = name.split("");
		int[] iArr = new int[sArr.length];
		for (int i = 0; i < sArr.length; i++) {
			int tmp = (int) sArr[i].charAt(0) - 65;
			if (tmp > 13) {
				tmp = 26 - tmp;
			}
			iArr[i] = tmp;
			answer += tmp;
		}

		return answer;

	}
}
