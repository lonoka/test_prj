package codingtest;

import java.util.ArrayList;
import java.util.List;


public class skilltree {
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
		solution(skill, skill_trees);
	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		String regex = "[^" + skill + "]";

		for (int i = 0; i < skill_trees.length; i++) {
			skill_trees[i] = skill_trees[i].replaceAll(regex, "");
		}

		String[] sArr = skill.split("");
		List<Integer> sList = new ArrayList<Integer>();

		for (int i = 0; i < skill_trees.length; i++) {
			int tmp = 0;
			for (int j = sArr.length - 1; j > -1; j--) {
				if(skill_trees[i].contains(sArr[j])) {
					tmp = 1;
					skill_trees[i] = skill_trees[i].substring(0,skill_trees[i].lastIndexOf(sArr[j]));
				}else {
					if(tmp==1) {
						sList.add(i);
						break;
					}
				}
			}
		}
		answer = skill_trees.length - sList.size();
		System.out.println(answer);

		return answer;
	}
}
