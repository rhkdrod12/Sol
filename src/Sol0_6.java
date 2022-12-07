import java.util.Arrays;

public class Sol0_6 {
	
	public static void main(String[] args) {
		
		// String A = "hello";
		// String B = "ohell";
		
		
		String A = "abcdef123";
		int n = 3;
		
		String[] solution = new Solution().solution(A, n);
		
		System.out.println(Arrays.toString(solution));
	}
	
	static class Solution {
		public String[] solution(String my_str, int n) {
			int length = my_str.length();
			int cnt = length / n;
			
			String[] answer = new String[length % n == 0 ?  cnt : cnt+1];
			for (int i = 0; i < length; i+= n) {
				answer[i / n] = my_str.substring(i, Math.min(i + n, length));
			}
			return answer;
		}
	}
	
}
