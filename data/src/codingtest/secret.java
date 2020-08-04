package codingtest;

public class secret {
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 28 };
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			String tmp = "";
			String[] bin1 = tobinary(n, arr1[i]).split("");
			String[] bin2 = tobinary(n, arr2[i]).split("");
			for (int j = 0; j < n; j++) {
				if (bin1[j].equals("0") && bin2[j].equals("0")) {
					tmp += " ";
				} else {
					tmp += "#";
				}
			}
			answer[i] = tmp;
		}
		return answer;
	}

	public static String tobinary(int n, int parm) {
		String bin = "";
		for (int i = 0; i < n; i++) {
			bin = Integer.toString(parm % 2) + bin;
			parm = parm / 2;
		}
		return bin;
	}
}
