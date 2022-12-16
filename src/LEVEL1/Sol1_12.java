package LEVEL1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sol1_12 {
	
	public static void main(String[] args) {
		
		
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		
		int[] solution = new Solution().solution(lottos, win_nums);
		
		System.out.println();
		System.out.println("solution = " + Arrays.toString(solution));
		// System.out.println("solution = " + solution);
	}
	
	static class Solution {
		// 로또의 최고 순위와 최저 순위
		public int[] solution(int[] lottos, int[] win_nums) {
			int[] answer = {};
			
			int zero = 0;
			Set<Integer> lottoSet = new HashSet<>();
			for (int lotto : lottos) {
				if(lotto == 0) zero++;
				lottoSet.add(lotto);
			}
			
			int match = 0;
			for (int win_num : win_nums) {
				if(lottoSet.contains(win_num)) match++;
			}
			
			return new int[]{7 - Math.max(match + zero, 1), 7 - Math.max(match, 1)};
		}
	}
}

