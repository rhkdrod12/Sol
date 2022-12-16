package LEVEL1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Sol1_2 {
	
	public static void main(String[] args) {
		
		
		int[] ingredient = {2};
		int solution = new Solution().solution(ingredient);
		
		System.out.println("solution = " + solution);
		// System.out.println("solution = " + Arrays.toString(solution));
		
	}
	
	static class Solution {
		public int solution(int[] ingredient) {
			int[] stack = new int[ingredient.length];
			int sp = 0;
			int answer = 0;
			for (int i : ingredient) {
				stack[sp++] = i;
				if (sp >= 4 && stack[sp - 1] == 1 && stack[sp - 2] == 3 && stack[sp - 3] == 2 && stack[sp - 4] == 1) {
					sp -= 4;
					answer++;
				}
			}
			return answer;
		}
		
	}
	
	
}

