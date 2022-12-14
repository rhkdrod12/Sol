package LEVEL0;

import java.util.Arrays;

public class Sol0_17 {
	
	public static void main(String[] args) {
		
		int[] array = {9, 10, 11, 8};
		
		int[] solution = new Solution().solution(array);
		
		System.out.println(Arrays.toString(solution));
	}
	
	static class Solution {
		public int[] solution(int[] array) {
			// 해당 배열에서 가장 큰 수와 가장 작은 수의 인덱스를 반환
			int max = 0;
			for (int i = 0; i < array.length; i++) {
				max = array[i] > array[max] ? i : max;
			}
			return new int[]{array[max], max};
		}
	}
}
