package codingtest;

public class bigNum {
	public static void main(String[] args) {
		String number = "1924";
		int k = 2;
		solution(number, k);
	}
	// ´À¸² ¾ÈµÊ
	public static String solution(String number, int k) {
		int cnt = 0;
		String[] sArr = number.split("");
		boolean loop = true;
		while (loop) {
			for (int i = 0; i < sArr.length - 1; i++) {
				if (!sArr[i].equals("-1"))
					for (int j = i + 1; j < sArr.length; j++) {
						if (!sArr[j].equals("-1")) {
							if(sArr[i].compareTo(sArr[j])<0) {
								sArr[i] = "-1";
								cnt++;
								break;
							}else {
								break;
							}
						}
					}
			}
			if (cnt == k) {
				break;
			}
		}

		String answer = "";
		for(int i = 0; i<sArr.length;i++) {
			if(!sArr[i].equals("-1"))
				answer += sArr[i];
		}
		System.out.println(answer);
		return answer;
	}
}
