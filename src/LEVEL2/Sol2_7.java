package LEVEL2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Sol2_7 {
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
		
		int n = 5;
		int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
		
		printAnswer(new Solution().solution(n, info));
	}
	
	static class Solution {
		// 양궁대회
		public int[] solution(int n, int[] info) {
			int[] answer = {};
			
			/**
			 * 어차피가 모든 점수에서 이긴 경우의 최대 점수
			 */
			int appeachCost = 0;
			for (int i = 0; i < info.length; i++) {
				if (info[i] > 0) {
					appeachCost += (10 - i);
				}
			}
			
			// 10점을 따내기 위해 5번이 소요되었고
			// 09점을 따내기 위해 3번이 소요되었으면
			//
			
			/**
			 * 10점을 따내기 위해 5번이 소요되었고
			 * 09점을 따내기 위해 3번이 소요되었으면
			 *
			 */
			int rionCost = 0;
			boolean[] visited = new boolean[10];
			PriorityQueue<Node> qu = new PriorityQueue<>();
			
			int idx = 0;
			while (true) {
				if (info[idx] < n) {
				
				}
			}
			
			
			return answer;
		}
		
		class Node implements Comparable<Node> {
			
			int idx;
			int cnt;
			int cost;
			
			public Node(int idx, int cnt, int cost) {
				this.idx = idx;
				this.cnt = cnt;
				this.cost = cost;
			}
			
			@Override
			public int compareTo(Node o) {
				return o.cost - cost;
			}
			
			@Override
			public String toString() {
				return "Node{" +
				       "idx=" + idx +
				       ", cnt=" + cnt +
				       ", cost=" + cost +
				       '}';
			}
		}
	}
}

