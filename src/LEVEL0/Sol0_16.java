package LEVEL0;

public class Sol0_16 {
	
	public static void main(String[] args) {
		
		String my_string = "3 + 4 + 4";
		
		int solution = new Solution().solution(my_string);
		
		System.out.println(solution);
	}
	
	static class Solution {
		public int solution(String my_string) {
			
			String[] s = my_string.split(" ");
			
			// 초기값 지정
			int answer = Integer.parseInt(s[0]);
			
			// 나머지는 연산자가 오고 다음에 숫자가 오는 형태
			for (int i = 1; i < s.length; i += 2) {
				answer = ("-".equals(s[i]) ? answer - Integer.parseInt(s[i+1]) : answer + Integer.parseInt(s[i+1]));
			}
			
			return answer;
		}
	}
}
