package LEVEL2;

import java.util.Arrays;

public class Sol2_15 {
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
		
		int[][] users = {{40, 10000}, {25, 10000}};
		int[] emoticons = {7000, 9000};
		
		printAnswer(new Solution().solution(users, emoticons));
		
	}
	
	static class Solution {
		
		int[] result = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
		int[] emotionPrice;
		int[] emoticonSelect;
		int[] sales = {10, 20, 30, 40};
		int emticonLength;
		int[][] users;
		
		// 이모티콘 할인행사
		public int[] solution(int[][] users, int[] emoticons) {
			this.emticonLength = emoticons.length;
			this.users = users;
			this.emotionPrice = new int[emticonLength];
			this.emoticonSelect = new int[emticonLength];
			
			// 해당 이모티콘을 할인한 경우에
			solve(0, emoticons);
			
			return result;
		}
		
		public void cal(){
			int cnt = 0;
			int price = 0;
			
			for (int[] user : users) {
				int userSalePer = user[0];
				int userPrice = user[1];
				
				int tempPrice = 0;
				for (int i = 0; i < emticonLength; i++) {
					if (this.emoticonSelect[i] >= userSalePer) {
						tempPrice += this.emotionPrice[i];
					}
				}
				
				if (tempPrice >= userPrice) {
					cnt++;
				}else{
					price += tempPrice;
				}
			}
			
			if (result[0] < cnt) {
				result[0] = cnt;
				result[1] = price;
			} else if (result[0] == cnt && result[1] < price) {
				result[1] = price;
			}
			
		}
		
		
		public void solve(int depth, int[] emoticons) {
			
			if (depth == emticonLength) {
				cal();
				return;
			}
			
			for (int i = 0; i < sales.length; i++) {
				emoticonSelect[depth] = sales[i];
				emotionPrice[depth] = emoticons[depth] / 100 * (100 - sales[i]);
				solve(depth + 1, emoticons);
			}
		}
	}
}

