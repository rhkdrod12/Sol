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
		
		// public int solution(int n, int k, int[] enemy) {
		//
		// 	// 무적권이 적라운드보다 크면 그냥 적 라운드 반환처리
		// 	if (enemy.length <= k) {
		// 		return enemy.length;
		// 	}
		//
		// 	PriorityQueue<Node> queue = new PriorityQueue<>();
		// 	// 0 ~ k - 1까지 선택한 것으로 생성, 다음 값이 현재 선택된 애보다 더 작으면서 n을 안넘어갈 때까지 반복, 넘어가는 순간 종료!
		// 	for (int i = 0; i < k; i++) {
		// 		queue.add(new Node(i, enemy[i]));
		// 	}
		//
		// 	int round = k;
		// 	for (int i = k; i < enemy.length; i++) {
		//
		// 		int curVal;
		// 		if (queue.peek().value < enemy[i]) {
		// 			Node poll = queue.poll();
		// 			curVal = poll.value;
		// 			queue.add(new Node(i, enemy[i]));
		// 		}else{
		// 			curVal = enemy[i];
		// 		}
		//
		// 		if (n >= curVal) {
		// 			n -= curVal;
		// 		}else{
		// 			break;
		// 		}
		//
		// 		round++;
		// 	}
		//
		// 	return round;
		// }
		//
		// class Node implements Comparable<Node> {
		// 	int idx;
		// 	int value;
		//
		// 	public Node(int idx, int value) {
		// 		this.idx   = idx;
		// 		this.value = value;
		// 	}
		//
		// 	@Override
		// 	public int compareTo(Node o) {
		// 		return value - o.value;
		// 	}
		// }
		
		// public int solution(int n, int k, int[] enemy) {
		// 	int answer = 0;
		//
		// 	// n은 병사수
		// 	// enemy는 회차당 처들어오는 병사수
		// 	// 막을 때마다 적 병사 수만큼 n이 감소함
		// 	// k번 만큼 병사 소모 없이 막아낼 수 있을 때
		// 	// 최대 막을 수 있는 라운드 수는..?
		//
		// 	// 2가지 경우로 k를 사용했을 때랑 안했을 떄로 재귀
		//
		// 	int result1 = k > 0 ? recursion(n, k - 1, 1, enemy) : 0;
		// 	int result2 = n < enemy[0] ? recursion(n - enemy[0], k, 1, enemy) : 0;
		//
		// 	answer = Math.max(result1, result2);
		//
		// 	return answer;
		// }
		//
		// /**
		//  * 재귀를 십만번이나돌리면-> 오버플로우 확률 매우 높음
		//  * @param curAmy     현재 남은 병사수
		//  * @param k     현재 남은 무적권
		//  * @param round 진행한 라운드수
		//  * @param enemy 적군정보
		//  * @return
		//  */
		// public int recursion(int curAmy, int k, int round, int[] enemy){
		//
		// 	if(round >= enemy.length){
		// 		return round;
		// 	}
		//
		// 	int curEnemy = enemy[round];
		//
		// 	int result1 = k > 0 ? recursion(curAmy, k - 1, round + 1, enemy) : round;
		// 	int result2 = curAmy > curEnemy ? recursion(curAmy - curEnemy, k, round + 1, enemy) : round;
		//
		// 	return Math.max(result1, result2);
		// }
		
	}
}

