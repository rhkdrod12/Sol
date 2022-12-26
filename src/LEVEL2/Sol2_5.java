package LEVEL2;

import java.util.Arrays;

public class Sol2_5 {
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
		
		int m = 6;
		int n = 4;
		int[][] picture = {
		{1, 1, 1, 0},
		{1, 2, 2, 0},
		{1, 0, 0, 1},
		{0, 0, 0, 1},
		{0, 0, 0, 3},
		{0, 0, 0, 3}};
		
		printAnswer(new Solution().solution(m, n, picture));
	}
	
	static class Solution {
		
		public int[] solution(int m, int n, int[][] picture) {
			int numberOfArea = 0;
			int maxSizeOfOneArea = 0;
			
			boolean[][] visited = new boolean[m][n];
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && picture[i][j] != 0) {
						numberOfArea++;
						maxSizeOfOneArea = Math.max(maxSizeOfOneArea, find(j, i, picture[i][j], picture, visited));
					}
				}
			}
			
			int[] answer = new int[2];
			answer[0] = numberOfArea;
			answer[1] = maxSizeOfOneArea;
			return answer;
		}
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
		
		public int find(int x, int y, int color, int[][] picture, boolean[][] visited) {
			
			if (y < 0 || x < 0 || y >= picture.length || x >= picture[y].length || visited[y][x] || color != picture[y][x]) {
				return 0;
			}
			visited[y][x] = true;
			
			int val = 1;
			for (int i = 0; i < 4; i++) {
				val += find(x + dx[i], y + dy[i], picture[y][x], picture, visited);
			}
			
			return val;
		}
		
	}
}

