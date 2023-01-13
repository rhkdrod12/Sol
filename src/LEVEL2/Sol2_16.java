package LEVEL2;

import java.util.Arrays;

public class Sol2_16 {
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
		
		// int cap = 4;
		// int n = 5;
		// int[] deliveries = {1, 0, 3, 1, 2};
		// int[] pickups = {0, 3, 0, 4, 0};
		int cap = 2;
		int n = 7;
		int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
		int[] pickups = {0, 2, 0, 1, 0, 2, 0};
		
		
		printAnswer(new Solution().solution(cap, n, deliveries, pickups));
		
	}
	
	static class Solution {
		// 택배 배달과 수거하기
		public long solution(int cap, int n, int[] deliveries, int[] pickups) {
			long answer = 0;
			
			/*
			 * 일단 최소 이동거리가 되기 위해서는
			 * 최대한 많이 내려주면서 많이 실어야함
			 *
			 * 아니지... 저건 수거하는거고 cap 중에서 수거 물품, 배송 물품이 섞여있자나
			 * cap을 꽉채우거나 남은 값이 cap을 초과하면 맨 처음으로 다시 돌아가야함
			 *
			 * 감이 안잡히네...
			 * 무식하게 하면 하긴하겠는데.. 근데 저건 속도가 느릴거고...
			 * 최단거리를 가기 위해서는, 최대한 먼 곳 부터 배달하는게 이득이긴 하지..
			 *
			 * int[] deliveries =   {1, 0, 3, 1, 2};
			 * int[] pickups =      {0, 3, 0, 4, 0};
			 *
			 */
			
			int deliveryIdx = n - 1;
			int pickupIdx = n - 1;
			
			for (int i = n - 1; i >= 0; i--) {
				if (deliveries[i] > 0 || pickups[i] > 0) {
					deliveryIdx = reduce(deliveryIdx, cap, deliveries);
					pickupIdx   = reduce(pickupIdx, cap, pickups);
					
					answer += (2 * i + 2);
					
					i = Math.max(deliveryIdx, pickupIdx) + 1;
				}
			}
			
			return answer;
		}
		
		public int reduce(int idx, int cap, int[] arr) {
			while (idx != -1 && (arr[idx] == 0 || cap != 0)) {
				if (arr[idx] != 0) {
					if (arr[idx] <= cap) {
						cap -= arr[idx];
						arr[idx] = 0;
					}else{
						arr[idx] -= cap;
						            cap = 0;
					}
				}
				if (arr[idx] == 0) {
					idx--;
				}
			}
			return idx;
		}
	}
}

