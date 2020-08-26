package codingtest;

// ���� �߸���
public class rectangle2 {
	public static void main(String[] args) {
		int[][] rectangles = { { 0, 1, 4, 4 }, { 3, 1, 5, 3 } };
		solution(rectangles);
	}

	/**
	 * 1. rectangles 2�߹迭�� ����ִ� �� ũ�⸸ŭ ���ο� 2�߹迭�� �����
	 * 2. 2�߹迭 ���ο� rectangles �� ���ԵǴ� �κи� ���� 1�� �ٲ۴�
	 * 3. ���Ѵ�
	 * 4. rectangles 2�߹迭 ���� ���� int���� int*int�� int������ ��� �� �����Ƿ�
	 * long ���ǹ迭�� ����
	 */
	public static long solution(int[][] rectangles) {
		long answer = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < rectangles.length; i++) {
			if (rectangles[i][2] > x) {
				x = rectangles[i][2];
			}
			if (rectangles[i][3] > y) {
				y = rectangles[i][2];
			}
		}
		long[][] rectangle = new long[x][y];

		for (int i = 0; i < rectangles.length; i++) {
			for (int j = rectangles[i][0]; j < rectangles[i][2]; j++) {
				for (int k = rectangles[i][1]; k < rectangles[i][3]; k++) {
					rectangle[j][k] = 1;
				}
			}
		}

		for (int i = 0; i < rectangle.length; i++) {
			for (int j = 0; j < rectangle[i].length; j++) {
				
				answer += rectangle[i][j];
			}
		}
		return answer;
	}
}
