package LEVEL2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Sol2_17 {
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
			
			
			HashMap<Integer, String> convertMap = new HashMap<>();
			convertMap.put(0, "1");
			convertMap.put(1, "00000");
			convertMap.put(2, "11011");
			
			
			HashMap<Integer, String> tableMap = new HashMap<>();
			tableMap.put(0, "1");
			
			tableMap.put(1, "11011");
			
			ArrayList<Node2> list = new ArrayList<>();
			list.add(new Node2(0,"1", 0));
			list.add(new Node2(1,"11011", 1));
			
			if (n > 1) {
				for (int i = 2; i < n; i++) {
					list.add(new Node2(i, list.get(i - 1)));
				}
			}
			
			return answer;
		}
		
		public long count(Node2 node2, long l, long r) {
			long midStat = node2.sideNode.size;
			long midEnd = midStat + node2.midZeroCnt;
			long end = node2.size;
			
			long answer = 0;
			
			// 시작 지점이
			// 노드 왼쪽에 있는 경우
			if (midStat < l) {
				if (midStat < r) {
					answer+= count(node2.sideNode, l, midStat);
				} else if(midStat > r){
					answer+= count(node2.sideNode, l, r);
				} else if (l == 0) {
					return node2.oneSize;
				}
			} else if (midEnd > l) {
				answer+= count(node2.sideNode, l, r);
				
				answer+= count(node2.sideNode, l - midEnd, midStat);
			} else{
				return 0;
			}
			
			return answer;
		}
		
		class Node2{
			int n;
			
			long midStart;
			
			long midEnd;
			
			long midZeroCnt;
			long size;
			long oneSize;
			String val;
			Node2 sideNode;
			
			public Node2(int n, String val, int midZeroCnt) {
				this.n = n;
				this.val = val;
				this.size = val.length();
				this.midZeroCnt = midZeroCnt;
				this.oneSize = this.size - this.midZeroCnt;
				
			}
			public Node2(int n, Node2 node2) {
				this.n = n;
				this.size = (long) Math.pow(5, n);
				this.midZeroCnt = (long) Math.pow(5, n-1);
				this.sideNode = node2;
				this.oneSize = 4 * node2.oneSize;
			}
		}
		
		class Node{
			int n;
			int nodeSize;
			int oneCnt;
			String val;
			List<Node> node = new ArrayList<>();
			
			public Node(int n, String val) {
				this.n = n;
				this.val = val;
			}
			
			public Node(int n, Node node) {
				this.n = n;
				
			}
		}
	}
}

