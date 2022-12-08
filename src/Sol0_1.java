import java.util.HashSet;
import java.util.Set;

public class Sol0_1 {
	
	public static void main(String[] args) {
		
		String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa", "yeara"};
		
		int solution = new Solution().solution(babbling);
		
		// 	answer = 1
		System.out.println("solution = " + solution);
		
	}
	
	
	static class Solution {
		public int solution(String[] babbling) {
			int answer = 0;
			
			// 아기가 발음 가능한 발음
			String[] ableWord = {"aya", "ye", "woo", "ma"};
			
			// 4가지이므로 최대 64가지의 발음이 가능하기 때문에 해당 경우의 수를 모두 구한 상태에서
			// Set을 사용하여 가능 여부를 파악하도록 처리
			
			Set<String> list = new HashSet<>();
			boolean[] visited = new boolean[ableWord.length];
			// 초기값 지정
			repeat("", -1, 3, ableWord, list, visited);
			
			// 횟수 찾기
			for (String s : babbling) {
				if (list.contains(s)) {
					answer++;
				}
			}
			
			return answer;
		}
		
		public void repeat(String val, int startIndex, int count, String[] words, Set<String> list, boolean[] visited) {
			
			if(count == -1 ) return;
			
			for (int i = 0; i < words.length; i++) {
				if (!visited[i] && startIndex != i) {
					String tempVal = val + "" + words[i];
					list.add(tempVal);
					// 방문 처리해야 재귀시에 해당 부분을 접근 안하도록 함
					visited[i] = true;
					// 재귀처리하여 최대 연결 횟수만큼 연결함
					repeat(tempVal, i, count - 1, words, list, visited);
					// 다음 루프부터는 해당 부분을 다시 접근할 수 있어야하기 떄문에 상태 미방문 상태로 변경
					visited[i] = false;
				}
			}
		}
		
		// 0 , 1 ,
	}
	
	
}

