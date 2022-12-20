package LEVEL2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Sol2_2 {
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
		
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		
		System.out.println();
		printAnswer(new Solution().solution(n, data));
	}
	
	static class Solution {
		public int solution(int n, String[] data) {
			int answer = 0;
			
			/**
			 * data의 원소는 5글자로 이루어진 문자열
			 * 첫번째 글자는 제시한 프랜즈
			 * 두번째 글자는 항상 ~
			 * 세번째 글자는 상대방 프랜즈
			 * 네번째는 비교문
			 * 다섯번째는 비교문의 크기를 의미
			 *
			 *
			 * 조건은 최소 1개부터 최대 100개까지 있을 수 있음
			 *
			 * 일때 주어진 조건을 만족하는 경우의 수를 구하시오인 문제임
			 *
			 * 첫번째 문제는 사실 누가 제시했고 상대방 프랜즈가 누구인지는 필요없는 상황
			 * 그냥 누구와 누구가 거리를 얼마나 배치하냐 문제임
			 *
			 * N 과 F의 간격은 바로 옆 0의 간격으로 배치해야함
			 * R 과 T의 간격은 3이상의 간격으로 배치해야함
			 * 음 근데 간격이 의미가 있나..?
			 *
			 * 재네들을 일단 배치하고 나서 나머지 배치하는 경우의 수를 구하면 된다는 건데..
			 * 간격이 3이면
			 *
			 */
			
			
			
			return answer;
		}
	}
}

