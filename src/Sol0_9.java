public class Sol0_9 {
	
	public static void main(String[] args) {
		
		int n = 976;
		
		int solution = new Solution().solution(n);
		
		System.out.println(solution);
	}
	
	static class Solution {
		public int solution(int n) {
			
			// 제곱근 특성상 해당 값의 중간 값을 넘어가지는 않음
			int half = n/2;
			
			for (int i = 2; i <= half; i++) {
				if (i*i == n) {
					return 1;
				} else if (i * i > n) {
					return 2;
				}
			}
			
			return 2;
		}
	}
	
}
