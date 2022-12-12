import java.util.ArrayList;
import java.util.Arrays;

public class Sol0_24 {
	
	public static void main(String[] args) {
		
		int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}, {5, 3}, {22, 4}};
		
		int solution = new Solution().solution(dots);
		
		// System.out.println(Arrays.toString(solution));
		System.out.println("solution = " + solution);
	}
	
	static class Solution {
		public int solution(int[][] dots) {
			int answer = 0;
			
			
			ArrayList<Integer[]> list = new ArrayList<>();
			
			boolean[] visited = new boolean[dots.length];
			
			
			BFS(0, dots.length, list, dots, visited);
			
			boolean cal = cal(dots[0], dots[1], dots[2], dots[3]);
			System.out.println("cal = " + cal);
			
			return answer;
		}
		// 2개씩 2번 선택해야함
		//
		
		// 아이템 개수
		int selectCnt = 2;
		// 그룹 개수
		int groupCnt = 2;
		
		ArrayList<Integer[]> result = new ArrayList<>();
		
		public void BFS(int selectdIdx , int totalCnt, ArrayList<Integer[]> result, int[][] dots, boolean[] visited) {
			
			if (totalCnt == 0) {
				return ;
			}
			
			// 1이 선택이 되었음
			// 이전으로 다시 돌아갈 필요는 없음
			for (int i = 0; i < dots.length; i++) {
				if (!visited[i]) {
					// 해당 부분 방문처리
					visited[i] = true;
					if (selectdIdx == 0) {
						Integer[] ints = new Integer[selectCnt];
						result.add(ints);
						ints[selectdIdx] = i;
						BFS(selectdIdx + 1, totalCnt - 1, result, dots, visited);
					}
				}
			}
		}
		
		
		
		public boolean cal(int[] coordinate1, int[] coordinate2, int[] coordinate3, int[] coordinate4) {
			
			// 기울기 gradient
			int gradient1 = (coordinate1[1] - coordinate2[1]) / (coordinate1[0] - coordinate2[0]);
			// y-절편
			int intercept1 = coordinate1[1] - coordinate1[0] * gradient1;
			// 기울기 gradient
			int gradient2 = (coordinate3[1] - coordinate4[1]) / (coordinate3[0] - coordinate4[0]);
			// y-절편
			int intercept2 = coordinate3[1] - coordinate3[0] * gradient2;
			
			// gradient y-intercept
			// o o : 겹침
			// o x : 평행
			// x o : 겹침
			// x x : 겸침
			
			return !(gradient1 == gradient2 && intercept1 != intercept2);
		}
	}
}
