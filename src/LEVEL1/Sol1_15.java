package LEVEL1;

import java.util.HashSet;
import java.util.Set;

public class Sol1_15 {
	
	public static void main(String[] args) {
		
		
		int[] nums = {1,2,7,6,4};
		
		// System.out.println("solution = " + Arrays.toString(new Solution().solution(a, b, n)));
		System.out.println("solution = " + new Solution().solution(nums));
	}
	
	static class Solution {
		// 소수 만들기
		public int solution(int[] nums) {
			int answer = 0;
			
			// 2 ~ 1000까지의 모든 소수 구하기
			Set<Integer> primeNumberSet = primeNumberSieve();
			
			// 3가지의 수를 합하여 해당 값이 소수인지 판단 하는 로직이므로 조합하여 소수인지 확인
			int length = nums.length;
			for (int i = 0; i < length; i++) {
				for (int j = i+1; j < length; j++) {
					for (int k = j+1; k < length; k++) {
						if(primeNumberSet.contains(nums[i] + nums[j] + nums[k])){
							answer++;
						}
					}
				}
			}
			
			return answer;
		}
		
		Set<Integer> primeNumberSieve() {
			int number = 3000;
			boolean[] a = new boolean[number+1];
			
			for(int i=2;i<=number;i++) {
				if(a[i]) continue; // 이미 지워진 수라면 건너뛰기
				for(int j= 2*i; j<=number; j+=i) {
					a[j] = true;
				}
			}
			
			Set<Integer> result = new HashSet<>();
			for(int i=2;i<=number;i++) {
				if(!a[i]){
					result.add(i);
				}
			}
			
			return result;
		}
	}
}

