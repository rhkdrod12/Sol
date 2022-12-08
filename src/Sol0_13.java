import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Sol0_13 {
	
	public static void main(String[] args) {
		
		int n = 3;
		int[] numList = {4, 5, 6, 7, 8, 9, 10, 11, 12};
		int[] solution = new Solution().solution(n, numList);
		
		System.out.println(Arrays.toString(solution));
	}
	
	static class Solution {
		public int[] solution(int n, int[] numlist) {
			// return Arrays.stream(numlist).filter(item -> item % n == 0).toArray();
			
			ArrayList<Integer> result = new ArrayList<>();
			for (int i : numlist) {
				if (i % n == 0) {
					result.add(i);
				}
			}
			
			int[] resultArr = new int[result.size()];
			for (int i = 0; i < result.size(); i++) {
				resultArr[i] = result.get(i);
			}
			
			return resultArr;
		}
	}
}
