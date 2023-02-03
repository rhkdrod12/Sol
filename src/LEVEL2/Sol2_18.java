package LEVEL2;

import Utils.Print;

import java.util.*;

public class Sol2_18 {
	public static void main(String[] args) {
		
		int[] weights = {100, 180, 360, 233,765,34334,2234,6767,44566,100, 270, 100, 100, 180,200,500,720,304,532,777,342,423,8124,15345,23222,1111,2333,444,5566,7778,999};
		
		// 100 100 100 300 300
		// 100 300
		
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int[] val = new int[100000];
		for (int i = 0; i < 100000; i++) {
			val[i] = i;
		}
		
		weights = val;
		
		Print.Out(new Solution().solution(weights));
		Print.Out(new Solution().solution2(weights));
		
	}
	
	static class Solution {
		
		public long count(long num) {
			return num * (num - 1) / 2;
		}
		
		
		public long solution2(int[] weights) {
			long answer = 0;
			
			int[][] caseArr = {{1, 1}, {1, 2}, {2, 3}, {3, 4}};
			
			for (int i = 0; i < weights.length; i++) {
				for (int j = i+1; j < weights.length; j++) {
					for (int[] ints : caseArr) {
						if (weights[i] * ints[0] == weights[j] * ints[1] || weights[i] * ints[1] == weights[j] * ints[0]) {
							answer++;
						}
					}
				}
			}
			return answer;
		}
		
		// 시소 짝꿍
		public long solution(int[] weights) {
			long answer = 0;
			Map<Integer, Long> map = new HashMap<>();
			
			for (int weight : weights) {
				map.put(weight, map.getOrDefault(weight, 0L) + 1);
			}
			
			Integer[] integers = map.keySet().toArray(new Integer[0]);
			int[][] caseArr = {{1, 2}, {2, 3}, {3, 4}};
			for (int i = 0; i < integers.length; i++) {
				if (map.get(integers[i]) > 1) {
					answer += (count(map.get(integers[i])));
				}
				for (int j = i+1; j < integers.length; j++) {
					for (int[] ints : caseArr) {
						if (integers[i] * ints[0] == integers[j] * ints[1] || integers[i] * ints[1] == integers[j] * ints[0]) {
							answer += ((long)map.get(integers[i]) * map.get(integers[j]));
						}
					}
				}
			}
			
			return answer;
		}
	}
}

