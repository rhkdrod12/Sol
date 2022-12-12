import java.util.HashMap;
import java.util.Map;

public class Sol0_23 {
	
	public static void main(String[] args) {
		
		String my_string = "cccCCC";
		
		String solution = new Solution().solution(my_string);
		
		// System.out.println(Arrays.toString(solution));
		System.out.println("solution = " + solution);
	}
	
	static class Solution {
		public String solution(String my_string) {
			StringBuilder sb = new StringBuilder();
			char[] chars = my_string.toCharArray();
			for (char aChar : chars) {
				sb.appendCodePoint(aChar > 96 ? (aChar - 32) : aChar + 32);
			}
			return sb.toString();
		}
		
	}
}
