package LEVEL0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sol0_21 {
	
	public static void main(String[] args) {
		
		String my_string = "my_string";
		int num1 = 1;
		int num2 = 2;
		
		String solution = new Solution().solution(my_string, num1, num2);
		
		// System.out.println(Arrays.toString(solution));
		System.out.println("solution = " + solution);
	}
	
	static class Solution {
		public String solution(String my_string, int num1, int num2) {
			
			char temp = my_string.charAt(num1);
			
			StringBuilder stringBuilder = new StringBuilder(my_string);
			stringBuilder.setCharAt(num1, my_string.charAt(num2));
			stringBuilder.setCharAt(num2, temp);
			
			return stringBuilder.toString();
		}
		
	}
}
