package LEVEL0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sol0_20 {
	
	public static void main(String[] args) {
		
		String s = "aaaa";
		
		String solution = new Solution().solution(s);
		
		// System.out.println(Arrays.toString(solution));
		System.out.println("solution = " + solution);
	}
	
	static class Solution {
		public String solution(String s) {
			
			Map<Character, Integer> map = new HashMap<>();
			char[] chars = s.toCharArray();
			for (char aChar : chars) {
				map.put(aChar, map.getOrDefault(aChar, 0) + 1);
			}
			
			List<Character> list = new ArrayList<>();
			for (Character character : map.keySet()) {
				if (map.get(character) == 1) {
					list.add(character);
				}
			}
			
			// 정렬처리
			Collections.sort(list);
			
			StringBuilder sb = new StringBuilder();
			for (Character character : list) {
				sb.append(character);
			}
			
			return sb.toString();
		}
		
	}
}
