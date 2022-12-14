package LEVEL0;

public class Sol0_7 {
	
	public static void main(String[] args) {
		
		// String A = "hello";
		// String B = "ohell";
		
		
		int[] n = {7, 77, 17};
		
		Byte aByte = 77;
		
		System.out.println("n[1] = " + (n[2] >> 10));
		
		int solution = new Solution().solution(n);
		
		System.out.println(solution);
	}
	
	static class Solution {
		public int solution(int[] array) {
			int answer = 0;
			
			StringBuilder stringBuilder = new StringBuilder();
			
			for (int i : array) {
				stringBuilder.append(i);
			}
			
			for (int i = 0; i < stringBuilder.length(); i++) {
				if (stringBuilder.charAt(i) == '7') {
					answer++;
				}
			}
			return answer;
		}
	}
	
}
