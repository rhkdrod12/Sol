package LEVEL0;

import java.util.Arrays;

public class Sol0_12 {
	
	public static void main(String[] args) {
		
		int n = 930211;
		
		int solution = new Solution().solution(n);
		
		System.out.println(solution);
	}
	
	static class Solution {
		public int solution(int n) {
			int answer = 0;
			do {
				answer += n % 10;
			} while ((n /= 10) != 0);
			return answer;
		}
	}
}
