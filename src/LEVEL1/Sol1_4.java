package LEVEL1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Sol1_4 {
	
	public static void main(String[] args) {
		
		
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {4,4,4,4,4};
		
		String solution = new Solution().solution(survey, choices);
		
		System.out.println();
		System.out.println("solution = " + solution);
		// System.out.println("solution = " + Arrays.toString(solution));
		
	}
	
	static class Solution {
		public String solution(String[] survey, int[] choices) {
			
			StringBuilder answer = new StringBuilder();
			char[][] charac = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
			int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
			
			
			Map<Character, Integer> scoreMap = new HashMap<>();
			for (int i = 0; i < survey.length; i++) {
				String s = survey[i];
				int choice = choices[i];
				char key = choice < 4 ? s.charAt(0) : s.charAt(1);
				scoreMap.put(key, score[choice] + scoreMap.getOrDefault(key, 0));
			}
			
			for (char[] chars : charac) {
				int a1 = scoreMap.getOrDefault(chars[0], 0);
				int a2 = scoreMap.getOrDefault(chars[1], 0);
				if (a1 == a2) {
					answer.append(chars[0] < chars[1] ? chars[0] : chars[1]);
				}else{
					answer.append(a1 > a2 ? chars[0] : chars[1]);
				}
			}
			
			return answer.toString();
		}
		
		
	}
	
	
	
	
}

