import java.util.ArrayList;
import java.util.Arrays;

public class Sol0_19 {
	
	public static void main(String[] args) {
		
		int n = 1;
		
		int[] solution = new Solution().solution(n);
		
		System.out.println(Arrays.toString(solution));
		// System.out.println("solution = " + solution);
	}
	
	static class Solution {
		public int[] solution(int n) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 1; i <= n/2; i++) {
				if (n % i == 0) {
					list.add(i);
				}
			}
			list.add(n);
			
			int[] result = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				result[i] = list.get(i);
			}
			
			return result;
		}
	}
}
