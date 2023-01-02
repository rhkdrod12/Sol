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
			
			/**
			 * [3,2,2,2,1,1,1,1,1,1,1]
			 * [0,2,2,0,1,0,0,0,0,0,0]
			 * 점수       소요횟수    사용비용    투자비용
			 * 10           3           30          3.3333333333....
			 * 09           2           18          4.5
			 * 08           2           16          4
			 * 07           2           14          3.5
			 * 06           1           06          6
			 * 05           1           05          5
			 * 04           1           04          4
			 * 03           1           03          3
			 * 02           1           02          2
			 * 01           1           01          1
			 *
			 * 사용비용이 높을 수록 좋을 것이 없음??
			 *
			 */
			
			int rionCost = 0;
			boolean[] visited = new boolean[10];
			PriorityQueue<Node> qu = new PriorityQueue<>();
			
			int idx = 0;
			while (true) {
				if (info[idx] < n) {
					break;
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

