package LEVEL2;

import java.util.*;

public class Sol2_10 {
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
		
		int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};
		printAnswer(new Solution().solution(cards));
		
	}
	
	static class Solution {
		// 혼자 놀기의 달인
		public int solution(int[] cards) {
			int answer = 0;
			boolean[] visited = new boolean[cards.length];
			
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < cards.length; i++) {
				if (!visited[i]) {
					int val = i;
					int cnt = 0;
					while (!visited[val]) {
						visited[val] = true;
						val = cards[val] - 1;
						cnt++;
					}
					list.add(cnt);
				}
			}
			
			list.sort(Comparator.reverseOrder());
			
			if (list.size() > 1) {
				return list.get(0) * list.get(1);
			}else{
				return 0;
			}
		}
	}
}

