package LEVEL2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sol2_4 {
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
		
		// int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
		// int[][] line = {{1, -1, 0}, {2, -1, 0}};
		// int[][] line = {{1, -1, 0}, {2, -1, 0}, {4, -1, 0}};
		int[][] line = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
		
		
		// int n = 6;
		// int k = 4;
		// int[] enemy = {3, 1, 3, 3, 5, 2, 1, 1};
		
		printAnswer(new Solution().solution(line));
	}
	
	static class Solution {
		
		public String[] solution(int[][] line) {
			
			
			/**
			 *
			 * Ax + By + E = 0
			 * Cx + Dy + F = 0
			 *
			 * x = (BF - ED) / (AD - BC)
			 * y = (EC - AF) / (AD - BC)
			 *
			 *
			 * 주어진 라인에서 두 개씩 뽑아서 연산 해야함
			 */
			
			int maxX = Integer.MIN_VALUE;
			int maxY = Integer.MIN_VALUE;
			int minX = Integer.MAX_VALUE;
			int minY = Integer.MAX_VALUE;
			
			int maxLength = 1000;
			
			int n = 0;
			int[][] arr = new int[maxLength][2];
			for (int i = 0; i < line.length; i++) {
				for (int j = i + 1; j < line.length; j++) {
					long[] point = pointCal(line[i], line[j]);
					if (point != null) {
						int pointX = (int) (point[0] % maxLength);
						int pointY = (int) (point[1] % maxLength);
						
						maxX = Math.max(pointX, maxX);
						maxY = Math.max(pointY, maxY);
						minX = Math.min(pointX, minX);
						minY = Math.min(pointY, minY);
						
						arr[n++] = new int[]{pointX, pointY};
					}
				}
			}
			
			int rengeX = Math.abs(maxX - minX + 1);
			int rengeY = Math.abs(maxY - minY + 1);
			
			boolean[][] points = new boolean[rengeY][rengeX];
			for (int i = 0; i < n; i++) {
				points[arr[i][1] - minY][arr[i][0] - minX] = true;
			}
			
			String[] answer = new String[points.length];
			for (int i = rengeY - 1; i >= 0; i--) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j <= rengeX - 1; j++) {
					sb.append(points[i][j] ? '*' : '.');
				}
				answer[rengeY - 1 - i] = sb.toString();
			}
			
			return answer;
		}
		
		public long[] pointCal(int[] a, int[] b) {
			
			long xx = ((long)a[1] * (long)b[2] - (long)a[2] * (long)b[1]);
			long yy = ((long)a[2] * (long)b[0] - (long)a[0] * (long)b[2]);
			long bb = ((long)a[0] * (long)b[1] - (long)a[1] * (long)b[0]);
			
			// 나머지가 있으면 소수점 자리가 있다는 소리이니 교점이라고 해도 패스
			if (bb == 0 || xx % bb != 0 || yy % bb != 0) {
				return null;
			}else{
				return new long[]{(xx / bb), (yy / bb)};
			}
		}
	}
}

