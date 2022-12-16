package LEVEL1;

import java.util.HashSet;
import java.util.Set;

public class Sol1_9 {
	
	public static void main(String[] args) {
		
		String new_id = "a.$.a";
		
		String solution = new Solution().solution(new_id);
		
		System.out.println();
		// System.out.println("solution = " + Arrays.toString(solution));
		System.out.println("solution = " + solution);
		System.out.println("solution.length() = " + solution.length());
	}
	
	static class Solution {
		// 신규 아이디 추천
		public String solution(String new_id) {
			String answer = new_id.toLowerCase();
			answer = answer.replaceAll("([^0-9a-z-_.])","" );
			answer = answer.replaceAll("(\\.+(?=\\.))","" );
			answer = answer.replaceAll("(^\\.+)|(\\.+$)","" );
			
			if (answer.length() == 0) {
				answer = "a";
			} else if (answer.length() > 15) {
				answer = answer.substring(0, 15);
			}
			answer = answer.replaceAll("(^\\.+)|(\\.+$)", "");
			
			if (answer.length() <= 2) {
				answer = answer + String.valueOf(answer.charAt(answer.length() -1 )).repeat(3 - answer.length());
			}
			
			System.out.println("answer = " + answer);
			
			
			return answer;
			// Set<Character> ableWord = new HashSet<>();
			// for (char i = 'a'; i <= 'z' ; i++) {
			// 	ableWord.add(i);
			// }
			// for (char i = '0'; i <= '9' ; i++) {
			// 	ableWord.add(i);
			// }
			// ableWord.add('-');
			// ableWord.add('_');
			// ableWord.add('.');
			//
			// // 1.소문자화
			// String s = new_id.toLowerCase();
			//
			// // 2.규칙외 문자 제거
			// StringBuilder sb = new StringBuilder();
			// char[] chars = s.toCharArray();
			// char prevChar = 0;
			// for (char aChar : chars) {
			// 	if (!(aChar == '.' && prevChar == aChar) && ableWord.contains(aChar)) {
			// 		sb.append(aChar);
			// 	}
			// 	prevChar = aChar;
			// }
			//
			// // 첫과 끝의 dot제거
			// String s1 = removeDot(sb.toString());
			//
			// if(s1.length() == 0 ){
			// 	s1 = "a";
			// }else if(s1.length() > 15){
			// 	s1 = s1.substring(0, 15);
			// }
			//
			// s1 = removeDot(s1);
			//
			// if (s1.length() <= 2) {
			// 	s1 = s1 + String.valueOf(s1.charAt(s1.length() -1 )).repeat(3 - s1.length());
			// }
			//
			// return s1;
		}
		
		public String removeDot(String s) {
			
			boolean first = true;
			char preChar = 0;
			
			char[] chars = s.toCharArray();
			int sLength = s.length();
			
			int firstDotIdx = -1;
			int lastDotIdx = sLength;
			
			for (int i = 0; i < chars.length; i++) {
				char c = chars[i];
				if (c == '.') {
					if(first) firstDotIdx = i;
					if(preChar != c) lastDotIdx = i;
				}else{
					first = false;
					lastDotIdx = sLength;
				}
				preChar = c;
			}
			
			return sLength > 0 ? s.substring(Math.min(firstDotIdx + 1, sLength - 1) , lastDotIdx) : s;
		}
		
		
	}
	
}

