package LEVEL1;

public class Sol1_3 {
	
	public static void main(String[] args) {
		
		
		String s = "a";
		
		int solution = new Solution().solution(s);
		System.out.println();
		System.out.println("solution = " + solution);
		// System.out.println("solution = " + Arrays.toString(solution));
		
	}
	
	static class Solution {
		public int solution(String s) {
			char[] chars = s.toCharArray();
			return countWord(chars[0], 0, chars) + 1;
		}
		
		public int countWord(char sChar, int startIdx, char[] chars) {
			
			int firstChar = 0;
			int otherChar = 0;
			int remainCnt = (chars.length - startIdx) / 2;
			
			for (int i = startIdx; i < chars.length - 1; i++) {
				if (chars[i] == sChar) {
					firstChar++;
				}else{
					otherChar++;
				}
				// 서로 같아지는 지점이면
				if (firstChar == otherChar) {
					return 1 + countWord(chars[i+1], i + 1, chars);
				}
				else if (firstChar > remainCnt) {
					return 0;
				}
			}
			
			return 0;
		}
		
	}
	
	
	
	
}

