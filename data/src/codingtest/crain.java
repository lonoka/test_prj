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
		List<Integer> iList = new ArrayList<Integer>();

		int answer = 0;
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][moves[i] - 1] != 0) {
					iList.add(board[j][moves[i] - 1]);
					board[j][moves[i] - 1] = 0;
					break;
				}
				if(j==board.length-1) {
					iList.add(board[j][moves[i] - 1]);
					board[j][moves[i] - 1] = 0;
					break;
				}
			}
		}

		for (int i = 0; i < iList.size(); i++) {
			System.out.printf(iList.get(i) + " ");
		}
		System.out.println("");
		boolean check = true;
		while(check) {
			int tmp = 0;
			for (int i = 0; i < iList.size()-1; i++) {
				if(iList.get(i)!=0) {
					for(int j=i+1; j<iList.size();j++) {
						if(iList.get(j)!=0) {
							if(iList.get(i)==iList.get(j)) {
								iList.set(i, 0);
								iList.set(j, 0);
								tmp = 1;
								answer += 2;
								break;
							}else {
								break;
							}
						}
					}
				}				
			}
			for (int i = 0; i < iList.size(); i++) {
				System.out.printf(iList.get(i) + " ");
			}
			System.out.println("");
			if(tmp == 0) {
				check = false;
			}
		}
		System.out.println("");
		
		return answer;
	}
	
	public static List<Integer> ListCheck(List<Integer> iList){
		
		
		return iList;
	}

}
