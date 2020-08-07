package codingtest;

public class price {
	public static void main(String[] args) {
		int[] prices = { 1, 2, 4, 7, 3, 2, 1, 3, 4 };
		solution(prices);
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		for (int i = 0; i < prices.length - 1; i++) {
			int tmp = 0;
			for (int j = i + 1; j < prices.length; j++) {
				tmp += 1;
				if (prices[i] > prices[j]) {
					break;
				}
			}
			answer[i] = tmp;
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		return answer;
	}
}
