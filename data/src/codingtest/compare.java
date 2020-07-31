package codingtest;

public class compare {
	public static void main(String[] args) {
		String[] strings = { "abce", "abcd", "cdx" };
		int n = 2;
		System.out.println(solution(strings, n));
	}

	public static String[] solution(String[] strings, int n) {
		for (int i = 0; i < strings.length - 1; i++) {
			for (int j = i + 1; j < strings.length; j++) {
				String tmp = "";
				String[] str1 = strings[i].split("");
				String[] str2 = strings[j].split("");
				if (str1[n].compareTo(str2[n]) > 0) {
					tmp = strings[i];
					strings[i] = strings[j];
					strings[j] = tmp;
				} else if (str1[n].compareTo(str2[n]) == 0) {
					if (strings[i].compareTo(strings[j]) > 0) {
						tmp = strings[i];
						strings[i] = strings[j];
						strings[j] = tmp;
					}
				}
			}

		}
		String[] answer = strings;

		return answer;
	}
}
