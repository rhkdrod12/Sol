package LEVEL1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sol1_7 {
	
	public static void main(String[] args) {
		
		
		int k = 100;
		// int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
		int[] score = new int[7];
		
		for (int i = 0; i < score.length; i++) {
			score[i] = (int) (Math.random() * 2000);
		}
		
		
		int[] solution = new Solution().solution(k, score);
		
		System.out.println();
		System.out.println("solution = " + Arrays.toString(solution));
		
	}
	
	static class Solution {
		public int[] solution(int k, int[] score) {
			int maxLevel = Math.min(k, score.length);
			int[] answer = new int[score.length];
			PriorityQueue<Integer> queue = new PriorityQueue<>();
			for (int i = 0; i < maxLevel; i++) {
				queue.add(score[i]);
				answer[i] = queue.peek();
			}
			for (int i = maxLevel; i < score.length; i++) {
				queue.add(score[i]);
				queue.poll();
				answer[i] = queue.peek();
			}
			return answer;
		}
	}
	
}

