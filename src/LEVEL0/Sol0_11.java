package LEVEL0;

import java.util.Arrays;

public class Sol0_11 {
	
	public static void main(String[] args) {
		
		String[] quiz = {"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"};
		
		String[] solution = new Solution().solution(quiz);
		
		System.out.println(Arrays.toString(solution));
	}
	
	static class Solution {
		public String[] solution(String[] quiz) {
			String[] answer = new String[quiz.length];
			
			for (int i = 0; i < quiz.length; i++) {
				String s = quiz[i];
				String[] s1 = s.split(" ");
				
				int a = Integer.parseInt(s1[0]);
				String oper = s1[1];
				int b = Integer.parseInt(s1[2]);
				int result = Integer.parseInt(s1[4]);
				
				if (oper.equals("-")) {
					answer[i] = a - b == result ? "O" : "X";
				} else {
					answer[i] = a + b == result ? "O" : "X";
				}
			}
				
			return answer;
		}
	}
}
