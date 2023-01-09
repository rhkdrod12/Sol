package LEVEL2;

import java.util.Arrays;

public class Sol2_13 {
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
		
		int n = 4;
		
		printAnswer(new Solution().solution(n));
		
	}
	
	static class Solution {
		// N-Queen
		public int solution(int n) {
			int answer = 0;
			
			length = n;
			
			
			
			return answer;
		}
		
		int length;
		public int bfs(int x, int y, int cnt, boolean[][] visited) {
			if (visited[x][y]) {
				return 0;
			} else if (cnt == visited.length) {
				return 1;
			}
			
			for (int i = 0; i < length; i++) {
				boolean a = visited[i][y];
				boolean b = visited[x][i];
				
				boolean c = visited[x][i];
				
				
			}
			
			
		}
	}
}

