package codingtest;

// 뭔가 잘못됨
public class rectangle2 {
	public static void main(String[] args) {
		int[][] rectangles = { { 0, 1, 4, 4 }, { 3, 1, 5, 3 } };
		solution(rectangles);
	}

	/**
	 * 1. rectangles 2중배열에 들어있는 값 크기만큼 새로운 2중배열을 만든다
	 * 2. 2중배열 내부에 rectangles 에 포함되는 부분만 숫자 1로 바꾼다
	 * 3. 더한다
	 * 4. rectangles 2중배열 내부 값은 int더라도 int*int가 int범위를 벗어날 수 있으므로
	 * long 형의배열을 선언
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
