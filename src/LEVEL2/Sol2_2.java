package LEVEL2;

import java.util.Arrays;
import java.util.HashMap;

public class Sol2_2 {
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
		
		int n = 2;
		String[] data = {"M~C<2", "M~C<3"};
		
		System.out.println();
		printAnswer(new Solution().solution(n, data));
	}
	
	static class Solution {
		public int solution(int n, String[] data) {
			int answer = 0;
			
			/**
			 * data의 원소는 5글자로 이루어진 문자열
			 * 첫번째 글자는 제시한 프랜즈
			 * 두번째 글자는 항상 ~
			 * 세번째 글자는 상대방 프랜즈
			 * 네번째는 비교문
			 * 다섯번째는 비교문의 크기를 의미
			 *
			 *
			 * 조건은 최소 1개부터 최대 100개까지 있을 수 있음
			 *
			 * 일때 주어진 조건을 만족하는 경우의 수를 구하시오인 문제임
			 *
			 * 첫번째 문제는 사실 누가 제시했고 상대방 프랜즈가 누구인지는 필요없는 상황
			 * 그냥 누구와 누구가 거리를 얼마나 배치하냐 문제임
			 *
			 * N 과 F의 간격은 바로 옆 0의 간격으로 배치해야함
			 * R 과 T의 간격은 3이상의 간격으로 배치해야함
			 * 음 근데 간격이 의미가 있나..?
			 *
			 * 재네들을 일단 배치하고 나서 나머지 배치하는 경우의 수를 구하면 된다는 건데..
			 * 간격이 3이면
			 * a 와 b 의 조건은 여러개일 수 있지..
			 * boolean의 배열형태로 만들어서 모든 거리 조건을 true false로 처리할까..?
			 */
			
			HashMap<Character, Integer> indexMap = new HashMap<>();
			for (int i = 0; i < friends.length; i++) {
				indexMap.put(friends[i], i);
			}
			
			for (String  str : data) {
				char[] chars = str.toCharArray();
				boolean b = setCondition(indexMap.get(chars[0]), indexMap.get(chars[2]), chars[4] - 48, chars[3]);
				if (!b) {
					return 0;
				}
			}
			
			boolean[] visited = new boolean[maxFriends];
			int[] select = new int[maxFriends];
			count(0, visited, select);
			
			return result;
		}
		// "N~F=0", "R~T>2"
		char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
		int result = 0;
		
		public void count(int idx,  boolean[] visited, int[] select){
			if (idx == maxFriends) {
				result++;
				return;
			}
			for (int i = 0; i < maxFriends; i++) {
				if (!visited[i]) {
					visited[i] = true;
					select[idx] = i;
					if (ableSeat(select, idx)) {
						count(idx + 1, visited, select);
					}
					visited[i] = false;
				}
			}
		}
		
		
		public boolean ableSeat(int[] select, int idx){
			for (int i = 0; i < idx; i++) {
				if (conditions[select[i]][select[idx]][idx - i - 1]) {
					return false;
				}
			}
			return true;
		}
		
		// 총 인원은 8명
		// 거리는 0 ~ 6
		// condition[a][b][l] a와 b가 l만큼 간격에서 배치될 수 있는지 여부
		// 기본적으로 전부 배치되는건데 조건으로 인해서 더이상 배치가 안되는거니
		// false가 배치 가능 true가 배치 불가능으로 판단합시다.
		int maxFriends = 8;
		int maxDistance = 7;
		boolean[][][] conditions = new boolean[maxFriends][maxFriends][maxDistance];
		
		/**
		 *  condtion은 false일 때 갈 수 있고 true일 때 갈 수없으로 판단할 것임
		 */
		public boolean setCondition(int a, int b, int distance, char condition) {
			for (int i = 0; i < maxDistance; i++) {
				// 조건 중에서 이미갈 수 없는 상황이면
				if (!(conditions[a][b][i] || conditions[b][a][i])) {
					boolean flag = !operation(i, distance, condition);
					conditions[a][b][i] = flag;
					conditions[b][a][i] = flag;
				}
			}
			return true;
		}
		
		public boolean operation(int cur, int distance, char condition) {
			if (condition == '=') {
				return cur == distance;
			} else if (condition == '<') {
				return cur < distance;
			}else {
				return cur > distance;
			}
		}
	}
}

