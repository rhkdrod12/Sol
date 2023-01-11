package LEVEL2;

import java.util.Arrays;

public class Sol2_14 {
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
		
		int k = 100000;
		int d = 100000;
		
		printAnswer(new Solution().solution(k, d));
		
	}
	
	static class Solution {
		// 점 찍기
		public long solution(int k, int d) {
			long answer = 0;
			
			long powD = (long)d * d;
			long maxX =  ((long)d / k) * k;
			long height = maxX;
			
			for (long i = 0; i <= height; i+=k) {
				while (maxX > 0) {
					if (maxX*maxX + i * i <= powD) {
						break;
					}
					maxX--;
				}
				answer += (maxX / k + 1);
			}
			
			return answer;
		}
	}
}

