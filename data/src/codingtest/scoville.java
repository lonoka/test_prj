package codingtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class scoville {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;
		solution(scoville, K);
	}

	/**
	 * PriorityQueue 를 사용
	 * PriorityQueue는 우선순위 Queue로 오름차순으로 자동 정렬 가장 낮은 수 부터 뺄 수 있음
	 * PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
	 * 로 선언시 내림차순으로 정렬되어 가장 높은 수부터 뺼 수 있음
	 * */ 
	public static int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> pQ = new PriorityQueue<Integer>();
		for (int i = 0; i < scoville.length; i++) {
			pQ.add(scoville[i]);
		}
		boolean loop = true;
		while (loop) {
			int tmp = 0;
			if (pQ.peek() < K) {
				if (pQ.size() == 1) {
					return -1;
				} else {
					tmp = 1;
				}
			}
			if (tmp == 0) {
				loop = false;
			} else {
				int iNum1 = pQ.peek();
				pQ.remove();
				int iNum2 = pQ.peek();
				pQ.remove();
				int cnt = iNum1 + (2 * iNum2);
				pQ.add(cnt);
				answer++;
			}
		}
		System.out.println(answer);
		return answer;

	}
	/**
	 * list를 사용
	 * Collections.sort를 사용하여 오름차순으로 항상 정렬
	 * */
	public static int solution2(int[] scoville, int K) {
		int answer = 0;
		List<Integer> iList = new ArrayList<Integer>();
		for (int i = 0; i < scoville.length; i++) {
			iList.add(scoville[i]);
		}
		boolean loop = true;
		while (loop) {
			Collections.sort(iList);
			int tmp = 0;
			for (int i = 0; i < iList.size(); i++) {
				if (iList.get(i) < K) {
					if (iList.size() == 1) {
						return -1;
					} else {
						tmp = 1;
					}
				}
			}
			if (tmp == 0) {
				loop = false;
			} else {
				int iNum1 = iList.get(0);
				iList.remove(0);
				int iNum2 = iList.get(0);
				iList.remove(0);
				int cnt = iNum1 + (2 * iNum2);
				iList.add(cnt);
				answer++;
			}
		}
		return answer;

	}
}
