package LEVEL0;

import java.util.HashMap;
import java.util.Map;

public class Sol0_22 {
	
	public static void main(String[] args) {
		
		String numbers = "onetwothreefourfivesixseveneightnine";
		
		long solution = new Solution().solution(numbers);
		
		// System.out.println(Arrays.toString(solution));
		System.out.println("solution = " + solution);
	}
	
	static class Solution {
		public long solution(String numbers) {
			
			//"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
			Map<String, Integer> valueMap = new HashMap<>();
			valueMap.put("zero", 0);
			valueMap.put("one", 1);
			valueMap.put("two", 2);
			valueMap.put("three", 3);
			valueMap.put("four", 4);
			valueMap.put("five", 5);
			valueMap.put("six", 6);
			valueMap.put("seven", 7);
			valueMap.put("eight", 8);
			valueMap.put("nine", 9);
			
			Map<Integer, Integer> wordMap = new HashMap<>();
			wordMap.put('z'* 2 + 'e', 4);
			wordMap.put('o'* 2 + 'n', 3);
			wordMap.put('t'* 2 + 'w', 3);
			wordMap.put('t'* 2 + 'h', 5);
			wordMap.put('f'* 2 + 'o', 4);
			wordMap.put('f'* 2 + 'i', 4);
			wordMap.put('s'* 2 + 'i', 3);
			wordMap.put('s'* 2 + 'e', 5);
			wordMap.put('e'* 2 + 'i', 5);
			wordMap.put('n'* 2 + 'i', 4);
			
			Map<Integer, String> valMap = new HashMap<>();
			valMap.put('z'* 2 + 'e', "0");
			valMap.put('o'* 2 + 'n', "1");
			valMap.put('t'* 2 + 'w', "2");
			valMap.put('t'* 2 + 'h', "3");
			valMap.put('f'* 2 + 'o', "4");
			valMap.put('f'* 2 + 'i', "5");
			valMap.put('s'* 2 + 'i', "6");
			valMap.put('s'* 2 + 'e', "7");
			valMap.put('e'* 2 + 'i', "8");
			valMap.put('n'* 2 + 'i', "9");
			
			StringBuilder result = new StringBuilder();
			
			char[] chars = numbers.toCharArray();
			for (int i = 0; i < chars.length; ) {
				Integer word = chars[i] * 2 + chars[i + 1] ;
				result.append(valMap.get(word));
				i += wordMap.get(word);
			}
			
			return Long.parseLong(result.toString());
		}
		
		// public long solution(String numbers) {
		//
		// 	//"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
		// 	Map<String, Integer> valueMap = new HashMap<>();
		// 	valueMap.put("zero", 0);
		// 	valueMap.put("one", 1);
		// 	valueMap.put("two", 2);
		// 	valueMap.put("three", 3);
		// 	valueMap.put("four", 4);
		// 	valueMap.put("five", 5);
		// 	valueMap.put("six", 6);
		// 	valueMap.put("seven", 7);
		// 	valueMap.put("eight", 8);
		// 	valueMap.put("nine", 9);
		//
		// 	StringBuilder result = new StringBuilder();
		// 	StringBuilder sb = new StringBuilder();
		//
		// 	char[] chars = numbers.toCharArray();
		// 	for (char aChar : chars) {
		// 		sb.append(aChar);
		//
		// 		String val = sb.toString();
		// 		if (valueMap.containsKey(val)) {
		// 			result.append(valueMap.get(val));
		// 			sb.setLength(0);
		// 		}
		// 	}
		//
		// 	return Long.parseLong(result.toString());
		// }
	}
}
