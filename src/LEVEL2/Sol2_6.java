package LEVEL2;

import java.util.ArrayList;
import java.util.Arrays;

public class Sol2_6 {
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
		
		int k = 2;
		int[][] ranges = {{0,0}, {0, -50}, {50, 0}, {0, -1}, {1, 0}};
		
		printAnswer(new Solution().solution(k, ranges));
	}
	
	static class Solution {
		
		public double[] solution(int k, int[][] ranges) {
			
			
			// 크기를 지정할 수 없음으로 리스트 사용
			ArrayList<Double> areaList = new ArrayList<>();
			
			int curVal = k;
			int preVal = k;
			int minVal;
			int maxVal;
			
			while ((curVal = collatz(curVal)) > 1) {
				minVal = Math.min(curVal, preVal);
				maxVal = Math.max(curVal, preVal);
				areaList.add((double)(maxVal - minVal) / 2 + minVal);
				preVal = curVal;
			}
			
			minVal = Math.min(curVal, preVal);
			maxVal = Math.max(curVal, preVal);
			areaList.add((double)(maxVal - minVal) / 2 + minVal);
			
			// sumArea[i][j] : i에서 j + 1까지의 면적합을 저장하고 있는 배열 생성
			int size = areaList.size();
			double[][] sumArea = new double[size][size];
			for (int i = 0; i < size; i++) {
				sumArea[i][i] = areaList.get(i);
				for (int j = i+1; j < size; j++) {
					sumArea[i][j] = sumArea[i][j - 1] + areaList.get(j);
				}
			}
			
			double[] answer = new double[ranges.length];
			for (int i = 0; i < ranges.length; i++) {
				int a = ranges[i][0];
				int b = ranges[i][1] + size;
				answer[i] = a > b || b <= 0 ? -1d : sumArea[a][b-1];
			}
			
			return answer;
		}
		
		public int collatz(int val) {
			if (val == 1) {
				return val;
			} else if (val % 2 == 0) {
				return val / 2;
			} else {
				return val * 3 + 1;
			}
		}
		
	}
}

