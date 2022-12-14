package LEVEL0;

import java.util.Arrays;

public class Sol0_3 {
	public static void main(String[] args) {
		
		int num = 5;
		int total = 15;
		
		int[] solution = new Solution().solution(num, total);
		
		// 	answer = 1
		System.out.println("solution = " + Arrays.toString(solution));
		
	}
	
	static class Solution {
		public int[] solution(int num, int total) {
			int[] answer = new int[num];
			int n = (1 - num + (2 * total) / num) / 2;
			for (int i = 0; i < num; i++) {
				answer[i] = n + i;
			}
			return answer;
		}
	}
	
}
