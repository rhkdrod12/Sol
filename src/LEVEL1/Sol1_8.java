package LEVEL1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sol1_8 {
	
	public static void main(String[] args) {
		
		String x = "1000";
		String y = "2000";
		
		
		String solution = new Solution().solution(x, y);
		
		System.out.println();
		// System.out.println("solution = " + Arrays.toString(solution));
		System.out.println("solution = " + solution);
	}
	
	static class Solution {
		// 숫자 짝꿍
		public String solution(String X, String Y) {
			String answer = "";
			
			// 나온 수를 저장할 용
			int[][] charArr = new int[2][10];
			
			char[] charsX = X.toCharArray();
			for (char x : charsX) {
				charArr[0][x - 48]++;
			}
			char[] charsY = Y.toCharArray();
			for (char c : charsY) {
				charArr[1][c - 48]++;
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 9; i > 0; i--) {
				int min = Math.min(charArr[0][i], charArr[1][i]);
				if (min > 0) {
					sb.append(String.valueOf(i).repeat(min));
				}
			}
			
			int zero = Math.min(charArr[0][0], charArr[1][0]);
			if (zero > 0) {
				if (sb.length() == 0) {
					sb.append("0");
				}else{
					sb.append(String.valueOf("0").repeat(zero));
				}
			}
			
			return sb.length() > 0 ? sb.toString() : "-1";
		}
	}
	
}

