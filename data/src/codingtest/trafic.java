package codingtest;

public class trafic {
	public static void main(String[] args) {
		String[] lines = { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };
		solution(lines);
	}

	public static int solution(String[] lines) {
		int answer = 0;
		int tmp = 0;
		for (int i = 0; i < lines.length - 1; i++) {
			if (lines.length - answer < answer) {
				break;
			}
			int cnt = 0;
			Double sTime = Double.parseDouble(lines[i].substring(17, 23));
			tmp = Integer.parseInt(lines[i].substring(14, 16));
			Double eTime = sTime + Double.parseDouble(lines[i].substring(24, lines[i].length() - 1));
			for (int j = i + 1; j < lines.length; j++) {
				Double temp = 0.0;
				if (Integer.parseInt(lines[j].substring(14, 16)) == 0) {
					if (tmp == 59) {
						temp = Double.parseDouble(lines[j].substring(17, 23)) + 60;
					} else {
						temp = Double.parseDouble(lines[j].substring(17, 23));
					}
				} else {
					temp = Double.parseDouble(lines[j].substring(17, 23));
				}
				if (temp < eTime) {
					cnt++;
				} else {
					break;
				}

			}
			if (answer < cnt) {
				answer = cnt;
			}
		}
		System.out.println(answer);
		return answer;
	}
}
