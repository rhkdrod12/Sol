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
			
			int appeachCost = 0;
			for (int i = 0; i < info.length; i++) {
				appeachCost += info[i] * (10 - i);
			}
			
			int rionCost = 0;
			boolean[] visited = new boolean[10];
			PriorityQueue<Node> qu = new PriorityQueue<>();
			int idx = 0;
			while (true) {
				if (info[idx] < n) {
					int rionCurCnt = info[idx] + 1;
					int rionCurCost = (10 - idx) * rionCurCnt;
					
					n -= rionCurCnt;
					qu.add(new Node(idx, rionCurCost));
				}
			}
			
			return answer;
		}
		
		class Node implements Comparable<Node> {
			
			int idx;
			int cost;
			
			public Node(int idx, int cost) {
				this.idx = idx;
				this.cost = cost;
			}
			
			@Override
			public int compareTo(Node o) {
				return o.cost - cost;
			}
		}
	}
}

