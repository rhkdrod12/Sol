package LEVEL2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Sol2_9 {
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
		
		String[] info = {
			"java backend junior pizza 150",
			"java backend junior chicken 80",
			"python frontend senior chicken 210",
			"python frontend senior chicken 150",
			"cpp backend senior pizza 260",
			"python backend senior chicken 50"
		};
		
		String[] query = {
			"java and backend and junior and pizza 100",
			"python and frontend and senior and chicken 200",
			"cpp and - and senior and pizza 250",
			"- and backend and senior and - 150",
			"- and - and - and chicken 100",
			"- and - and - and - 150"
		};
		
		printAnswer(new Solution().solution(info, query));
	}
	
	static class Solution {
		// 순위 검색
		public int[] solution(String[] info, String[] query) {
			int[] answer = new int[query.length];
			/**
			 * 개발 언어
			 * cpp, java, python
			 * 직군
			 * backend, frontend
			 * 경력
			 * junior, senior
			 * 소울푸드
			 * chicken, pizza
			 */
			
			String[] dev = {"-", "cpp", "java", "python", "backend", "frontend", "junior", "senior", "chicken", "pizza"};
			for (int i = 0; i < dev.length; i++) {
				devMap.put(dev[i], i);
			}
			
			// 모든 경우의 수 구하기
			getQueryCase(info);
			
			for (int i = 0; i < query.length; i++) {
				answer[i] = getCnt(query[i].split(" "));
			}
			return answer;
		}
		
		int[] queryIdxArr = new int[]{0, 2, 4, 6};
		// "java and backend and junior and pizza 100",
		int getCnt(String[] query) {
			
			StringBuilder sb = new StringBuilder();
			for (int j : queryIdxArr) {
				sb.append(devMap.get(query[j]));
			}
			
			int target = Integer.parseInt(query[7]);
			ArrayList<Integer> scoreCase = queryCaseMap.get(sb.toString());
			return scoreCase != null ? binarySearch(target, scoreCase) : 0;
		}
		
		int binarySearch(int val, List<Integer> list) {
			int startIdx = 0;
			int endIdx = list.size() - 1;
			while (startIdx <= endIdx) {
				int mid = (startIdx + endIdx) / 2 ;
				if (list.get(mid) < val) {
					startIdx = mid + 1;
				}else{
					endIdx = mid - 1;
				}
			}
			return list.size() - startIdx;
		}
		
		HashMap<String, Integer> devMap = new HashMap<>();
		HashMap<String, ArrayList<Integer>> queryCaseMap = new HashMap<>();
		void getQueryCase(String[] info) {
			
			for (String s : info) {
				String[] s1 = s.split(" ");
				int devScore = Integer.parseInt(s1[4]);
				circuit(devScore, "", 0, s1);
			}
			
			for (ArrayList<Integer> value : queryCaseMap.values()) {
				value.sort(Integer::compareTo);
			}
		}
		
		void circuit(int devScore, String str, int idx, String[] devInfo) {
			if (idx == devInfo.length - 1) {
				if (queryCaseMap.containsKey(str)) {
					ArrayList<Integer> integers = queryCaseMap.get(str);
					integers.add(devScore);
				}else{
					ArrayList<Integer> integers = new ArrayList<>();
					integers.add(devScore);
					queryCaseMap.put(str, integers);
				}
				
				return;
			}
			
			String val = devInfo[idx];
			circuit(devScore, str + devMap.get(val), idx + 1, devInfo);
			circuit(devScore, str + 0, idx + 1, devInfo);
		}
	}
}

