package LEVEL0;

public class Sol0_5 {
	
	public static void main(String[] args) {
		
		// String A = "hello";
		// String B = "ohell";
		
		String A = "apple|apple|apple";
		String B = "elppa";
		
		int solution = new Solution().solution(A, B);
		
		System.out.println(solution);
	}
	
	static class Solution {
		public int solution(String A, String B) {
			
			// 동일 문자가 있을 수 있기 때문에 첫문자로 비교하기는 어려워보이고
			// 그치만 첫문자로 해당 문자를 찾은 다음에 짤라서 비교해 볼 수 있는 있겠네..
			int bLength = B.length();
			char firstChar = A.charAt(0);
			char[] chars = B.toCharArray();
			
			for (int i = 0; i < chars.length; i++) {
				if(firstChar == chars[i] && A.equals(B.substring(i, bLength) + B.substring(0, i))){
					return i;
				}
			}
			return -1;
		}
	}
	
}
