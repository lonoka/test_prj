package codingtest;

public class wordmake {

	public static void main(String[] args) {
		String name = "ZAZ";
		System.out.println(solution(name));
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
		int cnt = 0;
		int i = 0;
		boolean loop = true;
		while (loop) {
			if (iArr[i] != 0) {
				iArr[i] = 0;
			}
			int tmp = 0;
			for (int j = 0; j < iArr.length; j++) {
				if (iArr[j] != 0) {
					tmp++;
				}
			}
			if (tmp == 0) {
				loop = false;
			}else {
				cnt++;
			}
			tmp = 0;
			for (int j = i + 1; j == i-1; j++) {
				if (j == iArr.length) {
					j = 0;
				}
				if (iArr[j] == 0) {
					tmp++;
				} else {
					break;
				}
			}
			for (int j = i-1; j == i+1; j--) {
				if (j == -1) {
					j = iArr.length;
				}
				if (iArr[j] == 0) {
					tmp--;
				} else {
					break;
				}
			}
			if (tmp > 0) {
				if (i == iArr.length - 1) {
					i = 0;
				} else {
					i++;
				}
			} else {
				if (i == 0) {
					i = iArr.length - 1;
				} else {
					i--;
				}
			}
		}
		answer += cnt;

		return answer;

	}
}
