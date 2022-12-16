package LEVEL1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sol1_13 {
	
	public static void main(String[] args) {
		
		
		int[] food = {1, 3, 4, 6};
		
		String solution = new Solution().solution(food);
		
		System.out.println();
		// System.out.println("solution = " + Arrays.toString(solution));
		System.out.println("solution = " + solution);
	}
	
	static class Solution {
		// 푸드 파이트 대회
		public String solution(int[] food) {
			StringBuilder sb = new StringBuilder();
			sb.append(0);
			for (int j = food.length - 1; j > 0; j--) {
				for (int i = 0; i < food[j] / 2; i++) {
					sb.insert(0, j);
					sb.append(j);
				}
			}
			return sb.toString();
		}
	}
}

