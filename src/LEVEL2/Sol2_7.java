package LEVEL2;

import java.util.Arrays;

public class Sol2_7 {
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
		
		int n = 5;
		int[] info = {2,1,1,1,0,0,0,0,0,0,0};
		
		printAnswer(new Solution().solution(n, info));
	}
	
	static class Solution {
		// 양궁대회
		public int[] solution(int n, int[] info) {
			
			/**
			 * 어차피가 모든 점수에서 이긴 경우의 최대 점수
			 */
			int appeachCost = 0;
			for (int i = 0; i < info.length; i++) {
				if (info[i] > 0) {
					appeachCost += (10 - i);
				}
			}
			
			System.out.println("appeachCost = " + appeachCost);
			
			/**
			 * 10
			 * 17
			 * 23
			 * [2,1,1,1,0,0,0,0,0,0,0]
			 * [3,2,2,2,1,1,1,1,1,1,1]
			 * [0,2,2,0,1,0,0,0,0,0,0]
			 * 점수       소요횟수    투자비용
			 * 10           3            3.3333333333....
			 * 09           2            4.5
			 * 08           2            4
			 * 07           2            3.5
			 * 06           1            6
			 * 05           1            5
			 * 04           1            4
			 * 03           1            3
			 * 02           1            2
			 * 01           1            1
			 *
			 * 1.일단 사용가능 횟수가 남아있으면 qu에 계속 집어넣음
			 * 2.소요횟수보다 사용가능 횟수가 더 작으면 qu에서 투자비용이 가장 낮은 점수와 현재의 점수의 투자비용을 비교하여
			 *   더 작은 쪽을 제거처리함, 이 때 선택된 점수로 아파치 총 점수를 빼내며 라이언 점수를 그 만큼 올림
			 * 3.1,2를 반복하면서 라이언 점수가 아파치 점수보다 높아지는 지점에서 최대 지점이 될 것임(높은 점수에서 낮은 점수로 내려갈 테니까)
			 * 4.점수가 바뀌는 지점 이전 배치가 정답이 될 것으로 예상
			 */
			
			int rionCost = 0;
			int[] visited = new int[11];
			
			solve(0, n, appeachCost, rionCost, info, visited);
			
			return winAble ? result : new int[]{-1};
		}
		
		int maxGap = Integer.MIN_VALUE;
		int[] result = new int[11];
		
		boolean winAble = false;
		
		boolean lowerScore(int[] rScoreInfo) {
			for (int i = 10; i >=0 ; i--) {
				if (rScoreInfo[i] > result[i]) {
					return true;
				} else if (rScoreInfo[i] < result[i]) {
					return false;
				}
			}
			return false;
		}
		
		void solve(int idx, int cnt, int aScore, int rScore, int[] info, int[] rScoreInfo) {
			
			// idx = 10의 위치는 전혀 상관없지 않나..??
			// 누가 이기든 결국에는 0점이자나
			if (idx == 11 || cnt == 0) {
				int diff = rScore - aScore;
				if (rScore > aScore && maxGap <= diff) {
					rScoreInfo[10] += cnt;
					if (maxGap !=diff || lowerScore(rScoreInfo)) {
						winAble = true;
						maxGap = diff;
						result = Arrays.copyOf(rScoreInfo, rScoreInfo.length);
					}
					rScoreInfo[10] -= cnt;
				}
				return;
			}
			
			// 해당 인덱스를 선택한 경우와 미선택한 경우로 회귀 처리 하여
			int aCnt = info[idx];
			int score = 10 - idx;
			
			// 선택시
			if (aCnt < cnt) {
				rScoreInfo[idx] += (aCnt+1);
				solve(idx + 1, cnt - aCnt - 1, aCnt > 0 ? aScore - score : aScore, rScore + score, info, rScoreInfo);
				rScoreInfo[idx] -= (aCnt+1);
			}
			
			// 미선택시
			solve(idx + 1, cnt, aScore, rScore, info, rScoreInfo);
		}
	}
}

