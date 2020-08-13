package codingtest;

import java.util.ArrayList;
import java.util.List;

public class printer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priorities = { 2, 1, 3, 2, 4, 4, 4 };
		int location = 5;
		solution(priorities, location);
	}

	public static int solution(int[] priorities, int location) {
		int answer = 0;
		List<Integer> iList = new ArrayList<Integer>();
		for (int i = 0; i < priorities.length; i++) {
			iList.add(priorities[i]);
		}
		int temp = 0;
		boolean loop = true;
		while(loop) {
			System.out.println(location);
			int tmp = 0;
			for (int j = 1; j < iList.size(); j++) {
				if (iList.get(0) < iList.get(j)) {
					if (location == 0) {
						location = iList.size() - 1;
					} else {
						location -= 1;
					}
					temp = iList.get(0);
					iList.remove(0);
					iList.add(temp);
					tmp = 1;
					break;
				}
			}
			if (tmp == 0) {
				if(location==0) {
					answer++;
					loop = false;
				}else {
					location -= 1;
					iList.remove(0);
					answer++;
				}
			}
		}
		System.out.println(answer);
		return answer;
	}

}
