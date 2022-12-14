package LEVEL0;

import java.util.ArrayList;
import java.util.Arrays;

public class Sol0_14 {
	
	public static void main(String[] args) {
		
		int num = 232443;
		int k = 4;
		
		int solution = new Solution().solution(num, k);
		
		System.out.println(solution);
	}
	
	static class Solution {
		public int solution(int num, int k) {
			int i = String.valueOf(num).indexOf(k + 48);
			return i != -1 ? i + 1 : i;
		}
	}
}
