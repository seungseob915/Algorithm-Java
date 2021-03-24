package kakao2020;

import java.util.Stack;

public class 괄호_변환 {
	public static void main(String[] args) {
		String p = "()))((()";
		String answer=solution(p);
		System.out.println(answer);
	}

	private static String solution(String p) {
		String answer = "";

		if (p.length() == 0)
			return answer;

		answer = simulate(0, p);

		return answer;
	}

	private static String simulate(int start_idx, String p) {
        if(check(p.substring(start_idx, p.length())))
            return p.substring(start_idx, p.length());
        
		int chk = 0;
		int v_start = -1;
		boolean go = false;

		for (int i = start_idx; i < p.length(); i++) {
			if (p.charAt(i) == '(')
				chk++;
			else
				chk--;
			
			if (go != false && chk == 0) {
				v_start = i + 1;
				break;
			}
			go = true;
		}

		String temp = "";
		if (!go)
			return temp;
		
		// u가 올바른 문자열이라면
		if (check(p.substring(start_idx, v_start))) {
			return p.substring(start_idx, v_start) + simulate(v_start, p);
		} else {
			temp += ( "(" + simulate(v_start, p) + ")" + reorder(p.substring(start_idx, v_start)));
			return temp;
		}
	}

	private static boolean check(String str) {
		Stack<Character> stack = new Stack<Character>();
		boolean ret = true;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(')
				stack.add('(');
			else {
				if (stack.isEmpty()) {
					ret = false;
					break;
				}
				stack.pop();
			}
		}
		if (!stack.isEmpty())
			ret = false;

		return ret;
	}

	private static String reorder(String str) {
		String ret = "";

		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) == '(')
				ret += ")";
			else
				ret += "(";
		}

		return ret;
	}
}
