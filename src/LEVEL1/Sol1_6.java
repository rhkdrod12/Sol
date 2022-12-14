package LEVEL1;

import java.util.HashSet;
import java.util.Set;

public class Sol1_6 {
	
	public static void main(String[] args) {
		
		
		String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		int solution = new Solution().solution(babbling);
		
		System.out.println();
		System.out.println("solution = " + solution);
		
	}
	
	static class Solution {
		public int solution(String[] babbling) {
			String[] ableWord = {"aya", "ye", "woo", "ma"};
			int answer = 0;
			for (String s : babbling) {
				if (check(s, 0, -1, ableWord)) {
					answer++;
				}
			}
			return answer;
		}
		
		public boolean check(String val, int offset, int skipIndx, String[] abledWord) {
			
			if (offset >= val.length()) {
				return true;
			}
			
			for (int i = 0; i < abledWord.length; i++) {
				if (skipIndx != i && val.startsWith(abledWord[i], offset)) {
					return check(val, offset + abledWord[i].length(), i, abledWord);
				}
			}
			
			return false;
		}
		
		
	}
	
}

