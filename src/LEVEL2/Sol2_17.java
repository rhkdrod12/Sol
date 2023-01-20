package LEVEL2;

import java.util.*;

public class Sol2_17 {
	public static void printAnswer(Object val) {
		if (val instanceof int[]) {
			System.out.println("val = " + Arrays.toString((int[]) val));
		} else if (val instanceof long[]) {
			System.out.println("val = " + Arrays.toString((long[]) val));
		} else if (val instanceof double[]) {
			System.out.println("val = " + Arrays.toString((double[]) val));
		} else if (val instanceof String[]) {
			System.out.println("val = " + Arrays.toString((String[]) val));
		} else {
			System.out.println("val = " + val);
		}
	}
	
	public static void main(String[] args) {
		
		// int cap = 4;
		// int n = 5;
		// int[] deliveries = {1, 0, 3, 1, 2};
		// int[] pickups = {0, 3, 0, 4, 0};
		int n = 20;
		long l = 1;
		long r = 1;
		
		printAnswer(new Solution().solution(n, l, r));
		
	}
	
	static class Solution {
		// 택배 배달과 수거하기
		public int solution(int n, long l, long r) {
			ArrayList<Node> list = new ArrayList<>();
			list.add(new Node(0, "1", 1));
			list.add(new Node(1, "11011", 4));
			if (n > 1) {
				for (int i = 2; i <= n; i++) {
					list.add(new Node(i, list.get(i - 1)));
				}
			}
			return (int)count(list.get(n), l - 1, r - 1);
		}
		
		public long count(Node node, long l, long r) {
			
			long answer = 0;
			
			if (r >= node.totalSize) {
				r = node.totalSize - 1;
			}
			if (l < 0) {
				l = 0;
			}
			
			if (l >= node.totalSize || r < 0 || l > r) {
				return 0;
			} else if (node.n < 2) {
				char[] chars = node.val.toCharArray();
				for (int i = (int)l; i <= r; i++) {
					if (chars[i] == '1') {
						answer++;
					}
				}
				return answer;
			} else if (l == node.sLIdx1 && r == node.totalSize - 1) {
				return node.oneSize;
			}
			
			// 왼쪽 첫번째 구간
			answer += this.count(node.sideNode, l, r);
			// 왼쪽 두번째 구간
			answer += this.count(node.sideNode, l - node.sLIdx2, r - node.sLIdx2);
			// 오른쪽 첫번째 구간
			answer += this.count(node.sideNode, l - node.sRIdx1, r - node.sRIdx1);
			// 오른쪽 두번째 구간
			answer += this.count(node.sideNode, l - node.sRIdx1 - node.sRIdx2, r - node.sRIdx1 - node.sRIdx2);
			
			return answer;
		}
		
		class Node {
			int n;
			// 왼쪽 자식1 노드 시작 위치
			long sLIdx1 = 0;
			// 왼쪽 자식2 노드 시작 위치
			long sLIdx2;
			// 오른쪽 자식1 노드 시작 위치
			long sRIdx1;
			// 오른쪽 자식2 노드 시작 위치
			long sRIdx2;
			
			long totalSize;
			long oneSize;
			String val;
			Node sideNode;
			
			public Node(int n, String val, int oneSize) {
				this.n          = n;
				this.val        = val;
				this.totalSize  = val.length();
				this.oneSize    = oneSize;
			}
			
			public Node(int n, Node node) {
				this.n          = n;
				this.sLIdx2     = node.totalSize;
				this.sRIdx1     = node.totalSize * 2 + (long) Math.pow(5, n - 1);
				this.sRIdx2     = this.sRIdx1 + node.totalSize;
				
				this.totalSize  = (long) Math.pow(5, n);
				this.sideNode   = node;
				this.oneSize    = 4 * node.oneSize;
			}
		}
	}
}

