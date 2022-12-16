package LEVEL1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sol1_16 {
	public static void printAnswer(Object val){
		if (val instanceof int[]) {
			System.out.println("val = " + Arrays.toString((int[]) val));
		} else if (val instanceof long[]) {
			System.out.println("val = " + Arrays.toString((long[]) val));
		} else if (val instanceof double[]) {
			System.out.println("val = " + Arrays.toString((double[]) val));
		} else if (val instanceof String[]) {
			System.out.println("val = " + Arrays.toString((String[]) val));
		} else{
			System.out.println("val = " + val);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {3,3,3,2,2,4};
		printAnswer(new Solution().solution(nums));
	}
	
	static class Solution {
		// 폰켓몬
		public int solution(int[] nums) {
			// 선택 가능한 폰켓몬 수
			int selectCnt = nums.length / 2;
			
			// 포켓몬 종류
			Set<Integer> kind = new HashSet<>();
			for (int num : nums) {
				kind.add(num);
			}
			// 즉 포켓몬 종류에서 최대 선택 가능한 개수는 종류별로 한개씩 뽑고나서 나머지를 채우는게 가장 많이
			// 고를 수 있는 방법이겠지
			
			// 종류가 선택지보다 적으면 종류 수가 정답이 될것이고
			// 선택지보다 종류가 많으면 선택지가 정답이 될거고
			
			return Math.min(selectCnt, kind.size());
		}
	}
}

