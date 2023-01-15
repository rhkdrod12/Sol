package LEVEL2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
		int n = 4;
		long l = 4;
		long r = 17;
		
		printAnswer(new Solution().solution(n, l, r));
		
	}
	
	static class Solution {
		// 택배 배달과 수거하기
		public int solution(int n, long l, long r) {
			int answer = 0;
			
			ArrayList<Node2> list = new ArrayList<>();
			list.add(new Node2(0, "1", 0));
			list.add(new Node2(1, "11011", 1));
			
			if (n > 1) {
				for (int i = 2; i < n; i++) {
					list.add(new Node2(i, list.get(i - 1)));
				}
			}
			
			long count = count(list.get(n - 1), l, r);
			System.out.println("count = " + count);
			
			return answer;
		}
		
		public long count(Node2 node2, long l, long r) {
			long answer = 0;
			
			if (node2.n < 2) {
				char[] chars = node2.val.toCharArray();
				for (int i = 0; i < chars.length; i++) {
					if (i <= l && l <= r && chars[i] == '1') {
						answer++;
					}
				}
				return answer;
			}
			
			//
			long stat = 0;
			long midStat = 2 * node2.sideNode.totalSize;
			long midEnd = midStat + node2.midZeroCnt;
			long end = node2.totalSize;
			
			 if (l == stat && r == end) {
				return node2.oneSize;
			} else if ((l == stat && r == (midStat - 1)) || (l == midEnd && r == end)) {
				return node2.sideNode.oneSize * 2;
			}
			
			if (l < midStat && r > midEnd) {
				if (l < node2.sideNode.totalSize) {
					answer += count(node2.sideNode, l, node2.sideNode.totalSize) + node2.sideNode.oneSize;
				} else {
					answer += count(node2.sideNode, l, node2.sideNode.totalSize);
				}
				if (r - midEnd < node2.sideNode.totalSize) {
					answer += count(node2.sideNode, 0, r - midEnd);
				} else {
					answer += count(node2.sideNode, 0, r - node2.sideNode.totalSize) + node2.sideNode.oneSize;
				}
				
			} else if (l < midStat && r < midStat) {
				if (l < node2.totalSize && r < node2.totalSize) {
					answer += count(node2.sideNode, l, r);
				} else if (l < node2.totalSize && r > node2.totalSize) {
					answer += count(node2.sideNode, l, node2.sideNode.totalSize) + count(node2.sideNode, 0, r - node2.sideNode.totalSize);
				} else if (l > node2.totalSize) {
					answer += count(node2.sideNode, 0, r - l);
				}
			}
			
			return answer;
		}
		
		class Node2 {
			int n;
			long midZeroCnt;
			long totalSize;
			long oneSize;
			String val;
			Node2 sideNode;
			
			public Node2(int n, String val, int midZeroCnt) {
				this.n          = n;
				this.val        = val;
				this.totalSize  = val.length();
				this.midZeroCnt = midZeroCnt;
				this.oneSize    = this.totalSize - this.midZeroCnt;
			}
			
			public Node2(int n, Node2 node2) {
				this.n          = n;
				this.totalSize  = (long) Math.pow(5, n);
				this.midZeroCnt = (long) Math.pow(5, n - 1);
				this.sideNode   = node2;
				this.oneSize    = 4 * node2.oneSize;
			}
		}
	}
}

