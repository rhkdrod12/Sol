package LEVEL1;

import java.util.Arrays;

public class Sol1_14 {
	
	public static void main(String[] args) {
		
		
		int a = 2;
		int b = 1;
		int n = 20;
		
		// System.out.println("solution = " + Arrays.toString(new Solution().solution(a, b, n)));
		System.out.println("solution = " + new Solution().solution(a, b, n));
	}
	
	static class Solution {
		// 콜라 문제
		public int solution(int a, int b, int n) {
			return cal(a, b, n);
		}
		
		public int cal(int a, int b, int n) {
			// 교환 가능한 횟수
			int exchangeCnt = n / a;
			
			if (exchangeCnt == 0) {
				return 0;
			}else{
				// 되돌려받을 수 있는 개수
				int backCnt = b * exchangeCnt;
				return backCnt + cal(a, b, backCnt + (n % a));
			}
		}
	}
}

