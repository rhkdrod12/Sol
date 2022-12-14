package LEVEL1;

import java.util.HashMap;
import java.util.Map;

public class Sol1_5 {
	
	public static void main(String[] args) {
		
		
		int number = 10;
		int limit = 3;
		int power = 2;
		
		int solution = new Solution().solution(number, limit, power);
		
		System.out.println();
		System.out.println("solution = " + solution);
		// System.out.println("solution = " + Arrays.toString(solution));
		
	}
	
	static class Solution {
		public int solution(int number, int limit, int power) {
			int answer = 0;
			for (int i = 1; i <= number; i++) {
				int cnt = divisorCnt(i);
				answer += (cnt > limit ? power : cnt);
			}
			return answer;
		}
		
		public int divisorCnt(int val){
			int cnt = 1 + (val > 1 ? 1 : 0);
			for (int i = 2; i <= Math.sqrt(val) ; i++) {
				if (val % i == 0) {
					cnt++;
					if (val / i != i) {
						cnt++;
					}
				}
			}
			return cnt;
		}
		
	}
	
}

