package codingtest;

public class lost {

	public static void main(String[] args) {
		int n = 7;
		int[] lost = {2,3,4};
		int[] reserve = {1,2,3,6};
		System.out.println(solution(n,lost,reserve));

	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = n;
		for(int i = 0; i<lost.length;i++) {
			for(int j = 0; j<reserve.length;j++) {
				if(lost[i]==reserve[j]) {
					lost[i] = 0;
					reserve[j] = 0;
				}
			}
		}
		
		for(int i = 0; i<lost.length;i++) {
			for(int j = 0; j<reserve.length;j++) {
				if(lost[i]!=0&&reserve[j]!=0) {
					if(lost[i]==reserve[j]+1) {
						lost[i] = 0;
						reserve[j] = 0;
					}
				}
			}
			for(int j = 0; j<reserve.length;j++) {
				if(lost[i]!=0&&reserve[j]!=0) {
					if(lost[i]==reserve[j]-1) {
						lost[i] = 0;
						reserve[j] = 0;
					}
				}
			}
		}
		for(int i=0;i<lost.length;i++) {
			if(lost[i]>0)
				answer --;
		}
		return answer;
	}
}
