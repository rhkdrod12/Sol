package LEVEL0;

public class Sol0_10 {
	
	public static void main(String[] args) {
		
		String str1 = "ab6CDE443fgh22iJKlmn1o";
		String str2 = "6CD";
		
		int solution = new Solution().solution(str1, str2);
		
		System.out.println(solution);
	}
	
	static class Solution {
		public int solution(String str1, String str2) {
			return str1.contains(str2) ? 1 : 2;
		}
		
	}
	
}
