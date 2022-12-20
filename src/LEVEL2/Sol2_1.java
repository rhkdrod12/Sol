package LEVEL2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Sol2_1 {
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
		
		String[] grid = {"SLSL", "SSSS", "SSSS", "SLLS", "LSSL"};
		
		int sIdx = 0;
		int n = 5;
		int m = 3;

		int idx = sIdx;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.printf("%02d ", idx++);
			}
			System.out.println();
		}
		
		System.out.println();
		printAnswer(new Solution().solution(grid));
	}
	
	
	static class Solution {
		
		char[] ableWord;
		int m;
		int n;
		int totalIdx;
		
		public int[] solution(String[] grid) {
			
			m = grid[0].length();
			n = grid.length;
			
			totalIdx = 0;
			ableWord = new char[m * n];
			
			for (String s : grid) {
				for (char c : s.toCharArray()) {
					ableWord[totalIdx++] = c;
				}
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			boolean[][] visited = new boolean[totalIdx][4];
			for (int i = 0; i < totalIdx; i++) {
				for (int direct = 0; direct < 4; direct++) {
					int cal = cal(i, direct, i, direct, visited, 0);
					if (cal > 0) {
						list.add(cal);
					}
					System.out.println("cal = " + cal);
				}
			}
			
			list.sort(Comparator.naturalOrder());
			
			int[] answer = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				answer[i] = list.get(i);
			}
			return answer;
		}
		
		/**
		 * 현재위치와 방향이 시작위치와 시작방향과 일치하면 사이클 형성가능
		 * 현재위치와 방향이 이미 방문했던 위치인데 시작위치와 시작방향이 아니면 사이클 형성 불가능
		 * 재귀쓰면 테스트케이스 7번에서 오버플로우남
		 * @param idx       현재 위치
		 * @param direct    현재 위치로 진입한방향
		 * @param sIdx      시작 위치
		 * @param sDirect   시작 위치로 진입한방향
		 */
		public int cal(int idx, int direct, int sIdx, int sDirect, boolean[][] visited, int result) {
			
			System.out.printf("idx : %2d , direct: %2d result: %d \n", idx, direct, result);
			
			while (true) {
				// 시작위치와 시작방향이 같으면 종료
				if (idx == sIdx && direct == sDirect && visited[idx][direct]) {
					return result;
				} else if (visited[idx][direct]) {
					return -1;
				}
				
				// 해당 idx와 방향을 방문처리
				visited[idx][direct] = true;
				
				direct = newDirect(direct, ableWord[idx]);
				idx = movePosition(idx, direct);
				result++;
			}
			
			// // 시작위치와 시작방향이 같으면 종료
			// if (idx == sIdx && direct == sDirect && visited[idx][direct]) {
			// 	return result;
			// } else if (visited[idx][direct]) {
			// 	return -1;
			// }
			//
			// // 해당 idx와 방향을 방문처리
			// visited[idx][direct] = true;
			//
			// char ch = ableWord[idx];
			// int newDirect = newDirect(direct, ch);
			//
			// return cal(movePosition(idx, newDirect), newDirect, sIdx, sDirect, visited, result + 1);
		}
		
		int newDirect(int direct, char moveAble){
			int newDirect;
			// 오른쪽
			if (moveAble == 'R') {
				newDirect = (direct + 1) % 4;
			}
			// 왼쪽
			else if (moveAble == 'L') {
				newDirect = (direct + 3) % 4;
			}
			// 직진
			else{
				newDirect = (direct) % 4;
			}
			return newDirect;
		}
		
		/**
		 *  해당 방향이 k이고 이동가능한 곳이 D면 다음 위치에서 R에서 출발하여 D방향에서 목적지에 도착
		 *
		 *  k   D   N   R
		 *  0   S   0   2
		 *  1   S   1   3
		 *  2   S   2   0
		 *  3   S   3   1
		 *
		 *  0   R   1   3
		 *  1   R   2   0
		 *  2   R   3   1
		 *  3   R   0   2
		 *
		 *  0   L   3   1
		 *  1   L   0   2
		 *  2   L   1   3
		 *  3   L   2   0
		 */
		/**
		 *
		 * @param idx
		 * @param direct
		 * @return
		 */
		int movePosition(int idx, int direct) {
			switch (direct) {
				// 위쪽 방향
				case 0:
					return idx + m < totalIdx ? idx + m : (idx % m);
				// 오른쪽
				case 1:
					return idx % m != 0 ? idx - 1 : ((idx / m) + 1) * m - 1;
				// 아래
				case 2:
					return idx - m >= 0 ? idx - m : (n - 1) * m + (idx % m);
				// 왼쪽
				case 3:
					return (idx + 1) % m != 0 ? idx + 1 : idx / m * m;
			}
			
			return 0;
		}
	}
}

