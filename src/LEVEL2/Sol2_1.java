package LEVEL2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		
		String[] grid = {"SL", "LR"};
		
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
		
		// ((2 / m) + 1) % n * m + (2 % m)
		
		System.out.println();
		//printAnswer(new Solution().solution(grid));
	}
	
	static class Solution {
		// 빛의 경로 사이클
		public int[] solution(String[] grid) {
			// 빛이 이동하면서 자기 자신으로 돌아오면 사이클 종료
			// 끝 점에서 나가면 반대편으로 돌아오는 구조이기 떄문에 사이클이 되지 않는 경우는 없음
			
			// 특정 격자에서 나간 사이클이 있을 때 해당 반대방향으로 오는 사이클을 연산할 필요는 없음 -> 어차피 사이클 수가 같을 테니까.
			
			// 특정 지점에서 특정 지점으로 이동했을 때 그 때 그 다른 지점으로 이동한 기록이 없으면 새로운 사이클이라는 거니
			// 그렇게 판단하면 될 것 같은데..
			// 정방향 역방향 둘다 생각해서 판단하면 될 것 같고..
			
			// visited[i][j][k] : (i,j)에서 k방향 쪽으로 방문여부
			// 0 <= k < 4 (k는 위, 아래, 오른쪽, 왼쪽을 의미)
			// i 는 격자 번호를 의미
			
			// 배열의 최대 크기는 알수 없기 떄문에 List를 사용하여 나중에 배열로 반화처리하겠음
			int n = grid.length;
			int m = grid[0].length();
			int k = 4;
			List<Integer> result = new ArrayList<>();
			
			// 음.. 그냥 (i, j)를 index화 하는게 나으려나.. 괜히 3중 배열인디..
			// 방문 여부
			boolean[][][] visited = new boolean[n][m][k];
			// 이동 가능 부분 저장
			char[][] moveAble = new char[n][];
			for (int i = 0; i < grid.length; i++) {
				moveAble[i] = grid[i].toCharArray();
			}
			
			// for (int k = -1; k < 2; k++) {
			// 	for (int h = -1; h < 2; h++) {
			// 		if (visit(i + k , j + h, visited)) {
			// 			answer++;
			// 		}
			// 	}
			// }
			
			for (int i = 0; i < moveAble.length; i++) {
				for (int j = 0; j < moveAble[i].length; j++) {
					for (int e = 0; e < k; e++) {
					
					}
				}
			}
			
			return null;
		}
		// visited[y][x][k] : (x,y)에 k방향쪽에서 날라왔을 때 방문 여부
		// k는 날라온 방향 0 : 위 , 1: 오른쪽, 2: 아래쪽, 3: 왼쪽
		// public boolean BFS(int x, int y, int k, char[][] moveAble, boolean[][][] visited) {
		// 	if(visited[y][x][k]){
		// 		return false;
		// 	}else ()
		//
		// }
		
	}
}

