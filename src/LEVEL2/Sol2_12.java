package LEVEL2;

import java.nio.file.FileAlreadyExistsException;
import java.util.Arrays;

public class Sol2_12 {
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
		
		// int[] arrayA = {17, 17};
		// int[] arrayB = {1, 20};
		int[] arrayA = {12, 30, 24};
		int[] arrayB = {4, 4, 16};
		// int[] arrayA = {14, 35, 119};
		// int[] arrayB = {18, 30, 102};
		
		printAnswer(new Solution().solution(arrayA, arrayB));
		
	}
	
	static class Solution {
		// 숫자 카드 나누기
		public int solution(int[] arrayA, int[] arrayB) {
			
			// 작은 수로 정렬처리
			
			int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;
			int length = arrayA.length;
			
			for (int i = 0; i < length; i++) {
				minA = Math.min(minA, arrayA[i]);
				minB = Math.min(minB, arrayB[i]);
			}
			
			int gcdVal = 0;
			boolean flagA, flagB;
			for (int i = Math.max(minA, minB); i > 1 ; i--) {
				flagA = i <= minA;
				flagB = i <= minB;
				
				for (int j = 0; j < length; j++) {
					// A 조건을 만족하지 못할 때~ B에 나눠지거나 A에 나눠지지 않는 경우
					if (arrayB[j] % i == 0 || arrayA[j] % i != 0) {
						flagA = false;
					}
					// B 조건을 만족하지 못할 떄~
					if (arrayA[j] % i == 0 || arrayB[j] % i != 0) {
						flagB = false;
					}
					// 둘 다 이미 만족하지 못한 상태이면 false지
					if (!flagA && !flagB) {
						break;
					}
				}
				
				if (flagA || flagB) {
					gcdVal = i;
					break;
				}
			}
			
			return gcdVal;
		}
		
	}
}

