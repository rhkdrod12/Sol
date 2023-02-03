package LEVEL2;

import Utils.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sol2_19 {
	public static void main(String[] args) {
		
		String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};
		
		
		Print.Out(new Solution().solution(maps));
		
	}
	
	static class Solution {
		public int[] solution(String[] maps) {
			
			xLength = maps[0].length();
			yLength = maps.length;
			
			// 방문여부용 
			boolean[][] visited = new boolean[yLength][xLength];
			
			// 값 확인용
			char[][] charsArr = new char[yLength][xLength];
			for (int i = 0; i < yLength; i++) {
				charsArr[i] = maps[i].toCharArray();
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < yLength; i++) {
				for (int j = 0; j < xLength; j++) {
					if (!visited[i][j]) {
						int result = count(j, i, charsArr, visited);
						if (result > 0) {
							list.add(result);
						}
					}
				}
			}
			
			if (list.size() == 0) {
				return new int[]{-1};
			}else{
				// 정렬처리
				list.sort(Integer::compareTo);
				int[] result = new int[list.size()];
				for (int i = 0; i < list.size(); i++) {
					result[i] = list.get(i);
				}
				return result;
			}
		}
		
		int xLength;
		int yLength;
		
		public int count(int x, int y, char[][] val, boolean[][] visited) {
			
			if (visited[y][x]) {
				return 0;
			}
			
			visited[y][x] = true;
			if (val[y][x] == 'X') {
				return 0;
			}
			
			int cnt = val[y][x] - 48;
			// 위
			if (y - 1 >= 0) {
				cnt += count(x, y - 1, val, visited);
			}
			// 오른쪽
			if (x + 1 < xLength) {
				cnt += count(x + 1, y, val, visited);
			}
			// 아래
			if (y + 1 < yLength) {
				cnt += count(x, y + 1, val, visited);
			}
			// 왼쪽
			if (x - 1 >= 0) {
				cnt += count(x - 1, y, val, visited);
			}
			
			return cnt;
		}
		
	}
}

