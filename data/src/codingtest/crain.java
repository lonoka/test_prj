package codingtest;

import java.util.ArrayList;
import java.util.List;

public class crain {

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

		System.out.println(solution(board, moves));

	}

	public static int solution(int[][] board, int[] moves) {
		// stack 을 써도 되지만 List로 stack이 하는일을 하기위해 선언
		List<Integer> iList = new ArrayList<Integer>();

		// 지워지는 갯수가 저장되는 변수
		int answer = 0;

		// 이동횟수만큼 반복
		for (int i = 0; i < moves.length; i++) {
			// 이중배열 내부에서 숫자를 꺼내기 위해 이중배열 길이만큼 반복
			for (int j = 0; j < board.length; j++) {
				// 해당 위치의 값이 0이 아닐때 iList에 넣고 그 위치의 값을 0으로 변경
				if (board[j][moves[i] - 1] != 0) {
					iList.add(board[j][moves[i] - 1]);
					board[j][moves[i] - 1] = 0;
					// iList의 크기가 1보다 클때 가장 마지막값과 그 전 값이 같은 경우 2개를 지우고 answer값 증가
					if (iList.size() > 1) {
						if (iList.get(iList.size() - 2) == iList.get(iList.size() - 1)) {
							iList.remove(iList.size() - 1);
							iList.remove(iList.size() - 1);
							answer += 2;
						}
					}
					break;
				}
			}
		}
		return answer;
	}

}
