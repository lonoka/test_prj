package codingtest;

public class rectangle {

	public static void main(String[] args) {
		int w = 4;
		int h = 2;
		System.out.println(solution(w, h));
	}

	public static long solution(int w, int h) {
		long answer = 1;
		long A = 0;
		long B = 0;
		if(w>h) {
			A = w;
			B = h;
		}else {
			A = h;
			B = w;
		}
		long tmp = 0;
		while (B>0) {
			tmp = A;
			A = B;
			B = tmp%B;
		}
		answer = (long)w * (long)h - (w + h - A);
		return answer;
	}
}
