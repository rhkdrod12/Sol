public class Sol0_4 {
	
	public static void main(String[] args) {
		
		int m = 1;
		int n = 1;
		
		int solution = new Solution().solution(m, n);
		
		
		// 3이면 총 가로로 2번 커팅 후
		// 세로로 4번씩 3번 12번이면 커팅
		System.out.println("solution = " + solution);
		
	}
	
	static class Solution {
		public int solution(int M, int N) {
			// 종이를 짜를 때 가장 적게 자를 수 있는 부분으로 짜르고 나서 그 다음에 그 만큼을 더 큰 쪽으로 짜르면 되려나..
			
			int max = Math.max(M, N);
			int min = Math.min(M, N);
			
			return min * (max - 1) + min - 1;
		}
	}
	
}
