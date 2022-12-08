import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Sol0_15 {
	
	public static void main(String[] args) {
		
		String[] s1 = {"a", "b", "c"};
		String[] s2 = {"com", "b", "d", "p", "c"};
		
		int solution = new Solution().solution(s1, s2);
		
		System.out.println(solution);
	}
	
	static class Solution {
		public int solution(String[] s1, String[] s2) {
			
			Set<String> set = new HashSet<>();
			Collections.addAll(set, s1);
			
			int answer = 0;
			for (String s : s2) {
				if (set.contains(s)) {
					answer++;
				}
			}
			
			return answer;
		}
	}
}
