package LEVEL2;

import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sol2_3 {
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
		
		int n = 1;
		int k = 1;
		int[] enemy = {1, 1};
		
		// int n = 6;
		// int k = 4;
		// int[] enemy = {3, 1, 3, 3, 5, 2, 1, 1};
		
		printAnswer(new Solution().solution(n, k, enemy));
	}
	
	static class Solution {
		
		public int solution(int n, int k, int[] enemy) {
			
			// 무적권이 적라운드보다 크면 그냥 적 라운드 반환처리
			if (enemy.length <= k) {
				return enemy.length;
			}
			
			PriorityQueue<Integer> queue = new PriorityQueue<>();
			// 0 ~ k - 1까지 선택한 것으로 생성, 다음 값이 현재 선택된 애보다 더 작으면서 n을 안넘어갈 때까지 반복, 넘어가는 순간 종료!
			for (int i = 0; i < k; i++) {
				queue.add(enemy[i]);
			}
			
			int round = k;
			for (int i = k; i < enemy.length; i++) {
				
				int curVal;
				if (queue.peek() < enemy[i]) {
					curVal = queue.poll();
					queue.add(enemy[i]);
				}else{
					curVal = enemy[i];
				}
				
				if (n >= curVal) {
					n -= curVal;
				}else{
					break;
				}
				
				round++;
			}
			
			return round;
		}
	}
}

