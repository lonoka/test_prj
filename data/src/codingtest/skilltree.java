package codingtest;

import java.util.ArrayList;
import java.util.List;


public class skilltree {
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };
		solution(skill, skill_trees);
	}

	/**
	 *	스킬트리에 포함되지 않은 단어들을 모두 삭제한 후
	 *	남아있는 단어가 스킬트리순서와 맞는지 안맞는지 확인
	 *	CBD의 경우 CB도 가능하기 때문에 가장 마지막부터 확인하여 해당 스킬이 존재하는 경우 그 위치보다 앞에 선행 스킬이 있는지 확인 
	 */
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
