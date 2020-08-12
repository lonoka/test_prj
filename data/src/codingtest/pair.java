package codingtest;

import java.util.ArrayList;
import java.util.List;

public class pair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int solution(String s) {
		int answer = 0;
		String[] sArr = s.split("");
		List<String> sList = new ArrayList<String>();
		for (int i = 0; i < sArr.length; i++) {
			sList.add(sArr[i]);
			if (sList.size() > 1) {
				if (sList.get(sList.size() - 2).equals(sList.get(sList.size() - 1))) {
					sList.remove(sList.size() - 1);
					sList.remove(sList.size() - 1);
				}
			}
		}
		if(sList.size()==0) {
			answer++;
		}
		return answer;
	}

}
