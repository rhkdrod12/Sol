package LEVEL2;

import java.util.Arrays;

public class Sol2_11 {
	public static void printAnswer(Object val){
		if (val instanceof int[]) {
			System.out.println("val = " + Arrays.toString((int[]) val));
		} else if (val instanceof long[]) {
			System.out.println("val = " + Arrays.toString((long[]) val));
		} else if (val instanceof double[]) {
			System.out.println("val = " + Arrays.toString((double[]) val));
		} else if (val instanceof String[]) {
			System.out.println("val = " + Arrays.toString((String[]) val));
		} else{
			System.out.println("val = " + val);
		}
	}
	
	public static void main(String[] args) {
		
		long begin = 1;
		long end = 100;
		
		printAnswer(new Solution().solution(begin, end));
		
	}
	
	static class Solution {
		// 숫자 블록
		public int[] solution(long begin, long end) {
			int[] answer = new int[(int)(end - begin + 1)];
			
			int idx = 0;
			if (begin == 1) {
				begin++;
				answer[idx++] = 0;
			}
			
			for (long i = begin; i <= end; i++) {
				answer[idx++] = solve(i);
			}
			
			return answer;
		}
		
		public int solve(long i) {
			for (long j = 2; j*j <= i; j++) {
				if (i % j == 0 && i / j <= 10000000) {
					return (int) (i / j);
				}
			}
			return 1;
		}
	}
}

