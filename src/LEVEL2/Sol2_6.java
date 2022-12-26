package LEVEL2;

import java.util.Arrays;

public class Sol2_6 {
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
		
		int k = 5;
		int[][] ranges = {{0,0},{0,-1},{2,-3},{3,-3}};
		
		printAnswer(new Solution().solution(k, ranges));
	}
	
	static class Solution {
		
		public double[] solution(int k, int[][] ranges) {
			double[] answer = {};
			
			
			return answer;
		}
		
	}
}

