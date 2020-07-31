package codingtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class k_num {

	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		
		int[] answer = solution(array, commands);

	}
	
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for(int i = 0; i<commands.length;i++) {
			List<Integer> iList = new ArrayList<Integer>();
			
			for(int j = commands[i][0]-1; j<commands[i][1];j++) {
				iList.add(array[j]);
			}
			Collections.sort(iList);
			answer[i] = iList.get(commands[i][2]-1);
		}
		for(int i = 0; i<answer.length;i++) {
			System.out.printf(answer[i]+" ");
		}
		return answer;
	}

}
