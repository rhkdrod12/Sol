package LEVEL1;

import java.util.PriorityQueue;

public class Sol1_10 {
	
	public static void main(String[] args) {
		
		int k = 4;
		int m = 3;
		int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
		
		
		int solution = new Solution().solution(k, m, score);
		
		System.out.println();
		// System.out.println("solution = " + Arrays.toString(solution));
		System.out.println("solution = " + solution);
	}
	
	static class Solution {
		// 과일 장수
		public int solution(int k, int m, int[] score) {
			int answer = 0;
			
			PriorityQueue<Number> qu = new PriorityQueue<>();
			// 가격대로 정렬
			for (int i : score) {
				qu.add(new Number(i));
			}
			
			while (qu.size() >= m) {
				for (int i = 0; i < m - 1; i++) {
					qu.poll();
				}
				answer += qu.poll().num * m;
			}
			return answer;
		}
		
		static class Number implements Comparable<Number> {
			public Number(int num) {
				this.num = num;
			}
			
			int num;
			@Override
			public int compareTo(Number o) {
				return o.num - num;
			}
		}
	}
	
}

