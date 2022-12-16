package LEVEL0;

public class Sol0_25 {
	
	public static void main(String[] args) {
		
		int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}};
		
		int solution = new Solution().solution(board);
		
		// System.out.println(Arrays.toString(solution));
		System.out.println("solution = " + solution);
	}
	
	static class Solution {
		
		// 방문한적 있으면 방문처리
		public boolean visit(int i, int j, boolean[][] visited) {
			if ( i >= 0 && j >= 0 &&  i < visited.length && j < visited[i].length && !visited[i][j]) {
				visited[i][j] = true;
				return true;
			}
			return false;
		}
		
		public int solution(int[][] board) {
			int answer = 0;
			
			int y = board.length;
			int x = board[0].length;
			
			boolean[][] visited = new boolean[y][x];
			
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					// 폭탄 위치
					if (board[i][j] == 1) {
						
						if(!visited[i][j]){
							visited[i][j] = true;
							answer++;
						}
						
						for (int k = -1; k < 2; k++) {
							for (int h = -1; h < 2; h++) {
								if (visit(i + k , j + h, visited)) {
									answer++;
								}
							}
						}
					}
				}
			}
			return x*y - answer;
		}
	}
}
