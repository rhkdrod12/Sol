package LEVEL0;

public class Sol0_8 {
	
	public static void main(String[] args) {
		
		int n = 7;
		int t = 15;
		
		int solution = new Solution().solution(n, t);
		
		System.out.println(solution);
	}
	
	static class Solution {
		public int solution(int n, int t) {
			return (int) (n * Math.pow(2, t));
		}
	}
	
}
