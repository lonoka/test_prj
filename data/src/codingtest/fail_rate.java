package codingtest;

public class fail_rate {

	public static void main(String[] args) {
		int N = 5;
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };

		solution(N, stages);

	}
	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		double[] temp = new double[N];
		for (int i = 0; i < N; i++) {
			answer[i] = i + 1;
		}

		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			int tot = 0;
			for (int j = 0; j < stages.length; j++) {
				if (i == stages[j]) {
					cnt += 1;
				}
				if (i <= stages[j]) {
					tot += 1;
				}
			}
			temp[i - 1] =  ((double)cnt / tot);
		}
		double dtmp = 0;
		int itmp = 0;
		for(int i = 0; i<temp.length-1;i++) {
			for(int j = i+1; j<temp.length;j++) {
				if(temp[i]<temp[j]) {
					dtmp = temp[j];
					temp[j] = temp[i];
					temp[i] = dtmp;
					itmp = answer[j];
					answer[j] = answer[i];
					answer[i] = itmp;
				}else if(temp[i]==temp[j]) {
					if(answer[i]>answer[j]) {
						dtmp = temp[j];
						temp[j] = temp[i];
						temp[i] = dtmp;
						itmp = answer[j];
						answer[j] = answer[i];
						answer[i] = itmp;
					}
				}
			}
		}

		return answer;
	}

}
