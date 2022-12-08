import java.util.Arrays;

public class Sol0_18 {
	
	public static void main(String[] args) {
		
		String message = "happy birthday!";
		
		int solution = new Solution().solution(message);
		
		//System.out.println(Arrays.toString(solution));
		System.out.println("solution = " + solution);
	}
	
	static class Solution {
		public int solution(String message) {
			return message.length() * 2;
		}
	}
}
