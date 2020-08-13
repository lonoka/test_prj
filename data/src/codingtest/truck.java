package codingtest;

import java.util.ArrayList;
import java.util.List;

public class truck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };
		solution(bridge_length, weight, truck_weights);

	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		List<Integer> iList = new ArrayList<Integer>();
		List<Integer> tList = new ArrayList<Integer>();

		for (int i = 0; i < truck_weights.length;) {
			for (int j = 0; j < tList.size();) {
				tList.set(j, tList.get(j)-1);
				if(tList.get(j)==0) {
					tList.remove(j);
					iList.remove(j);
				}else {
					j++;
				}
			}
			if (iList.size() == 0) {
				iList.add(truck_weights[i]);
				tList.add(bridge_length);
				i++;
			} else {
				int tmp = 0;
				for (int j = 0; j < iList.size(); j++) {
					tmp += iList.get(j);
				}
				if (tmp + truck_weights[i] <= weight) {
					iList.add(truck_weights[i]);
					tList.add(bridge_length);
					i++;
				}
			}
			answer++;
		}
		if(tList.size()>0) {
			answer += tList.get(tList.size()-1);
		}
		return answer;
	}

}
