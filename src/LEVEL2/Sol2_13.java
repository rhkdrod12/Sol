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
			length = n;
			int[][] queenSeat = new int[length][2];
			// Arrays.fill(queenSeat, -1);
			return solve(queenSeat, 0);
			
		}
		
		int length;
		public int solve(int[][] queenSeat, int y) {
			// n * n인데 n개를 배치해야하므로
			// 퀸은 열 하나당 한개씩만 배치가 가능
			if (y >= length) {
				return 1;
			}
			
			int answer = 0;
			for (int x = 0; x < length; x++) {
				if (ableQueen2(x, y, queenSeat)) {
					queenSeat[y] = new int[]{x, y};
					answer += solve(queenSeat, y + 1);
				}
			}
			
			return answer;
		}
		
		public boolean ableQueen2(int x, int y, int[][] queenSeat) {
			for (int i = 0; i < y; i++) {
				int seatX = queenSeat[i][0];
				int seatY = queenSeat[i][1];
				if (seatY == y || seatX == x || Math.abs(seatY - y) == Math.abs(seatX - x)) {
					return false;
				}
			}
			return true;
		}
	}
}

