package LEVEL2;

import java.util.Arrays;

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
			
			int mid = 500;
			boolean[][] points = new boolean[1001][1001];
			for (int i = 0; i < line.length; i++) {
				for (int j = i + 1; j < line.length; j++) {
					long[] point = pointCal(line[i], line[j]);
					if (point != null && Math.abs(point[0]) <= 1000 && Math.abs(point[1]) <= 1000) {
						maxX = (int)Math.max(point[0], maxX);
						maxY = (int)Math.max(point[1], maxY);
						minX = (int)Math.min(point[0], minX);
						minY = (int)Math.min(point[1], minY);
						points[(int) (point[1] + mid)][(int) (point[0] + mid)] = true;
					}
				}
			}
			
			
			// -8 ~ -4
			// 길이는 4
			// i = 0 부터일 때 i - min
			
			int y1 = Math.abs(maxY - minY);
			int x1 = Math.abs(maxX - minX);
			
			String[] answer = new String[maxY - minY + 1];
			for (int i = y1; i >= 0; i--) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j <= x1; j++) {
					sb.append(points[i + minY + mid][j + minX + mid] ? '*' : '.');
				}
				answer[y1 - i] = sb.toString();
			}
			
			return answer;
		}
		
		public long[] pointCal(int[] a, int[] b) {
			
			long xx = ((long)a[1] * b[2] - (long)a[2] * b[1]);
			long yy = ((long) a[2] * b[0] - (long)a[0] * b[2]);
			long bb = ((long)a[0] * b[1] - (long)a[1] * b[0]);
			
			if (bb == 0 || xx % bb != 0 || yy % bb != 0) {
				return null;
			}else{
				return new long[]{(xx / bb), (yy / bb)};
			}
		}
		
	}
}

