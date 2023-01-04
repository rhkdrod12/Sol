package LEVEL2;

import java.util.Arrays;

public class Sol2_8 {
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
		
		int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
		int col = 2;
		int row_begin = 2;
		int row_end = 3;
		int result = 4;
		
		printAnswer(new Solution().solution(data, col, row_begin, row_end));
	}
	
	static class Solution {
		// 테이블 해시 함수
		public int solution(int[][] data, int col, int row_begin, int row_end) {
			
			int colIdx = col-1;
			
			// 정렬처리
			Arrays.sort(data, (o1, o2) -> {
				if (o1[colIdx] == o2[colIdx]) {
					return o2[0] - o1[0];
				}else{
					return o1[colIdx] - o2[colIdx];
				}
			});
			
			// 초기값 입력
			int startIdx = row_begin - 1;
			int answer = 0;
			for (int val : data[startIdx]) {
				answer += (val % (startIdx+1));
			}
			
			// xor연산
			for (int i = startIdx + 1; i < row_end; i++) {
				int[] tempArr = data[i];
				int tempSum = 0;
				for (int val : tempArr) {
					tempSum += (val % (i+1));
				}
				answer ^= tempSum;
			}
			
			return answer;
		}
	}
}

