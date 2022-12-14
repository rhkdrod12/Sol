package LEVEL1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sol1_1 {
	
	public static void main(String[] args) {
		
		System.out.println(1<<1);
		
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		int[] solution = new Solution().solution(id_list, report, k);
		
		// System.out.println("solution = " + solution);
		System.out.println("solution = " + Arrays.toString(solution));
		
	}
	
	/**
	 * 신고에는 횟수제한은 없으나 동일 유저에 대한 중복 신고도 가능하나 중복신고는 1회로 취급
	 * k번 이상 신고된 유저는 정지처리 및 해당 유저를 신고한 모든 유저에 결과 메시지 보냄
	 * 유저가 결과메시지를 받는 횟수를 배열형태로 반환
	 */
	
	static class Solution {
		public int[] solution(String[] id_list, String[] report, int k) {
			int[] answer = new int[id_list.length];
			
			/*
			 * 해당 유저를 신고했을 떄 누가 신고했는지에 대한 정보를 저장하고 있어야하긋네..?
			 * 그냥 해당 유저마다 map형태로 저장하고 있으면 되지 않을까...?
			 * 근데 일단 배열순서대로 그대로 사용하라고 했으니 굳이 문자열 형태로 사용할 필요는 없을꺼고 인덱스 형태로 치환해서 사용해서 되겠네..
			 *
			 * 동일인이 중복신고는 1회로 취급
			 *
			 * 일단 map형태로
			 *
			 * bitmask 쓰면 될것 같은데.. 해당 유저를 누가 신고했는지는 bitmask를 사용하여 합시다.
			 *
			 * 문자열 비교 보다는 숫자형 더 빠를 거고
			 *
			 * 1231231241234,3123123123123,
			 *
			 * 임의 좌표들이 주어졌을 때 0,0과의 거리 순서대로 정렬하시오
			 *
			 * (1,5), (10,5), (15352352345324,2342342343242),(2342342,43242342342)
			 *
			 */
			
			// 신고자 정보의 ID를 키로 인덱스를 값으로 맵을 만듬
			Map<String, Integer> reportMap = new HashMap<>();
			for (int i = 0; i < id_list.length; i++) {
				reportMap.put(id_list[i], i);
			}
			
			List list = new ArrayList<>();
			// list 확보된 공간있을 텐데 ~~ 지점에 도달되면 재할당 -> stack->
			// 1만개 엄청 큰 공간아니냐
			// 저희는 지금 메모리가 넘치는 세상에 살고있습니다.
			
			// reportChk[i][j] => i 가 j를 신고했었는지 여부를 저장할 배열 신고했으면 true, 안했으면 false
			boolean[][] reportChk = new boolean[id_list.length][id_list.length];
			// reportCnt[i] => i 가 몇 번 신고 당했는지를 저장할 배열
			int[] reportCnt = new int[id_list.length];
			
			//
			for (int i = 0; i < report.length; i++) {
				String[] s = report[i].split(" ");
				Integer reporterIdx = reportMap.get(s[0]);
				Integer prosecutorIdx = reportMap.get(s[1]);
				
				if (!reportChk[reporterIdx][prosecutorIdx]) {
					reportChk[reporterIdx][prosecutorIdx] = true;
					reportCnt[prosecutorIdx]++;
				}
			}
			
			for (int i = 0; i < id_list.length; i++) {
				boolean[] booleans = reportChk[i];
				for (int j = 0; j < booleans.length; j++) {
					if (booleans[j] && reportCnt[j] >= k) {
						System.out.printf("%s가 %s를 신고하였습니다\n", id_list[i], id_list[j]);
						answer[i]++;
					}
				}
			}
			
			return answer;
		}
		
	}
	
	
}

