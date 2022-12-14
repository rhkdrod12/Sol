package LEVEL0;

public class Sol0_2 {
	public static void main(String[] args) {
		
		System.out.println((int) Math.pow(-2, 2) == 0);
		
		int[] common = {2, 4, 8};
		
		int solution = new Solution().solution(common);
		
		// 	answer = 1
		System.out.println("solution = " + solution);
		
	}
	
	static class Solution {
		public int solution(int[] common) {
			// 값중 0이 있으면 등비가 성립될 수 없으니..
			if (common[0] * common[2] == Math.pow(common[1], 2) && (common[0] != 0)) {
				return common[common.length - 1] * (common[1] / common[0]);
			}else{
				return common[common.length - 1] + (common[1] - common[0]);
			}
		}
	}
	
	
}
