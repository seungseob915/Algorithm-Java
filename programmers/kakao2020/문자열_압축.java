package kakao2020;

public class 문자열_압축 {

	public static void main(String[] args) {
		String s = "xxxxxxxxxxyyy";
		int ans = solution(s);
		System.out.println(ans);
	}

	private static int solution(String s) {
		int answer = 987654321;

		for (int i = 1; i <= s.length(); i++) {
			String t_ans = "";
			
			for (int j = 0; j < s.length(); j++ ) {
				if (j + i <= s.length()) {
					String now = s.substring(j, j + i);
					int stop_idx = -1;
					int tcnt = 1;

					for (int k = j + i; k + i <= s.length(); k += i) {
						if (!s.substring(k, k + i).equals(now)) {
							stop_idx = k;
							break;
						}
						tcnt++;
						if(k+i>=s.length())
							stop_idx=k+i;
						else if(k+2*i>=s.length())
							stop_idx=k+i;
					}

					if (tcnt != 1) {
						t_ans += (String.valueOf(tcnt) + now);
						j = stop_idx - 1;
					} else {
						t_ans += now;
						j+=(i-1);
					}
				}
				else {
					t_ans+=s.charAt(j);
				}
			}
			if (t_ans.length() != 0)
				answer = Math.min(t_ans.length(), answer);
		}

		return answer == 987654321 ? s.length() : answer;
	}

}
