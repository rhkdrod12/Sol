package LEVEL1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Sol1_11 {
	
	public static void main(String[] args) {
		
		String s = "foobar";
		
		
		int[] solution = new Solution().solution(s);
		
		System.out.println();
		System.out.println("solution = " + Arrays.toString(solution));
		// System.out.println("solution = " + solution);
	}
	
	static class Solution {
		// 가장 가까운 같은 글자
		public int[] solution(String s) {
			int[] answer = new int[s.length()];
			HashMap<Character, Integer> map = new HashMap<>();
			char[] chars = s.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				char c = chars[i];
				answer[i] = !map.containsKey(c) ? -1 : i - map.get(c);
				map.put(c, i);
			
			}
			return answer;
		}
	}
	
}

