package codingtest;

import java.util.ArrayList;
import java.util.List;

public class dev {
	public static void main(String[] args) {
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };
		solution(progresses, speeds);
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int tmp = 0;
		List<Integer> iList = new ArrayList<Integer>();
		boolean loop = true;
		while (loop) {
			for (int i = 0; i < progresses.length; i++) {
				if (progresses[i] < 100) {
					progresses[i] += speeds[i];
				}
			}
			int cnt = 0;
			for (int i = 0; i < progresses.length; i++) {
				if (progresses[i] >= 100) {
					cnt += 1;
				} else {
					break;
				}
			}
			if (cnt != 0) {
				if (tmp != cnt) {
					if (iList.size() > 0) {
						int total = 0;
						for(int i =0;i<iList.size();i++) {
							total += iList.get(i);
						}
						iList.add(cnt - total);
						tmp = cnt;
					} else {
						iList.add(cnt);
						tmp = cnt;
					}
				}

			}
			if (cnt == progresses.length)
				break;
			
		}

		int[] answer = new int[iList.size()];
		tmp = 0;
		for (int i : iList) {
			answer[tmp++] = i;
		}

		return answer;
	}
}
