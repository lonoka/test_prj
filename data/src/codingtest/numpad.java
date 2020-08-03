package codingtest;

public class numpad {
	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";
		System.out.println(solution(numbers, hand));
	}

	public static String solution(int[] numbers, String hand) {
		String answer = "";
		int rNum = 10;
		int lNum = 12;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				answer += "L";
				lNum = numbers[i];
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				answer += "R";
				rNum = numbers[i];
			} else {
				if(numbers[i]==0) {
					numbers[i] = 11;
				}
				int tmp1 = rNum - numbers[i];
				if (tmp1 < 0) {
					tmp1 *= (-1);
				}
				switch (tmp1) {
				case 1:
				case 3:
					tmp1 = 1;
					break;
				case 2:
				case 4:
				case 6:
					tmp1 = 2;
					break;
				case 5:
				case 7:
				case 9:
					tmp1 = 3;
					break;
				case 8:
				case 10:
					tmp1 = 4;
					break;
				}

				int tmp2 = lNum - numbers[i];
				if (tmp2 < 0) {
					tmp2 *= (-1);
				}
				switch (tmp2) {
				case 1:
				case 3:
					tmp2 = 1;
					break;
				case 2:
				case 4:
				case 6:
					tmp2 = 2;
					break;
				case 5:
				case 7:
				case 9:
					tmp2 = 3;
					break;
				case 8:
				case 10:
					tmp2 = 4;
					break;
				}

				if (tmp1 > tmp2) {
					answer += "L";
					lNum = numbers[i];
				} else if (tmp1 < tmp2) {
					answer += "R";
					rNum = numbers[i];
				} else {
					if (hand.equals("right")) {
						answer += "R";
						rNum = numbers[i];
					} else {
						answer += "L";
						lNum = numbers[i];
					}
				}

			}
		}
		return answer;
	}
}
