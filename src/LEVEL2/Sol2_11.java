package LEVEL2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Sol2_11 {
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
		
		long begin = 1;
		long end = 100;
		
		printAnswer(new Solution().solution(begin, end));
		
	}
	
	static class Solution {
		// 숫자 블록
		public int[] solution(long begin, long end) {
			int[] answer = new int[(int)(end - begin + 1)];
			
			
			// n 번 블럭인 경우 n * 2 번 부터 시작함
			// 즉 최대 영향받을 수 있는 건 begin에서 end 사이에 들어갈 수 있는 최대값은 end / 2
			// 즉 n의 배수만큼 그 값으로 된단 말이지..
			// 홀수 인경우에는 제곱근
			
			
			int sqrt = sqrt(13);
			System.out.println("sqrt = " + sqrt);
			
			int idx = 1;
			if (begin == 1) {
				begin++;
				answer[idx++] = 0;
			}
			
			for (long i = begin; i <= end; i++) {
				if (i % 2 == 0) {
					answer[idx++] = (int) (i / 2);
				} else{
					answer[idx++] = sqrt(i);
				}
			}
			
			return answer;
		}
		
		public int sqrt(long i) {
			for (long j = 2; j*j <= i; j++) {
				if (j*j == i) {
					return (int)j;
				}
			}
			return 1;
		}
	}
}

