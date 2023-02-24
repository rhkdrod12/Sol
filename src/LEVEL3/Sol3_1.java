package LEVEL3;

import Utils.Print;

public class Sol3_1 {
	public static void main(String[] args) {
		
		
		String sentence = "HaEaLaLaObWORLDb";
		
		Print.Out(new Solution().solution(sentence));
	}
	
	static class Solution {
		/*
			"HaEaLaLaObWORLDb"	    "HELLO WORLD"
			"SpIpGpOpNpGJqOqA"	    "SIGONG JOA"
			"AxAxAxAoBoBoB"	        "invalid"
		*/
		
		// 브라이언의 고민
		public String solution(String sentence) {
			String answer = "";
			
			StringBuilder sb = new StringBuilder();
			// 97 ~ 122
			char[] chars = sentence.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				char aChar = chars[i];
				
				
			}
			return answer;
		}
		
		public int check(int index, char[] chars, StringBuilder sb) {
			// 소문자가 온경우 true, false
			
			char roleChar = chars[index];
			boolean role = roleChar >= 97;
			
			for (int i = index + 1; i < chars.length; i++) {
				if (role && roleChar != chars[i]) {
				
				}
			}
			
			/**
			 * [조건 성립하는 경우]
			 * 1. 대문자만 있는 경우
			 * 2. 앞뒤로 같은 소문자가 있는 경우
			 * 3. 대문자 사이사이에 소문자가 있는 경우
			 *
			 *
			 */
			
			return -1;
		}
	}
}

