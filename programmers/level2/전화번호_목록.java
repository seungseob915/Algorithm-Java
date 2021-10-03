
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class 전화번호_목록 {

	public static void main(String[] args) {
		String[] phone_book = { "111113", "1112", "12" };
		boolean ret = solution(phone_book);
		System.out.println(ret);
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;

		Set<Integer> len = new LinkedHashSet<Integer>();
		Set<String> phone = new LinkedHashSet<String>();

		for (int i = 0; i < phone_book.length; i++) {
			len.add(phone_book[i].length());
			phone.add(phone_book[i]);
		}

		for (int now_len : len) {
			for (int j = 0; j < phone_book.length; j++) {
				if (now_len >= phone_book[j].length())
					continue;
				if (phone.contains(phone_book[j].substring(0, now_len))) {
					answer = false;
					break;
				}
			}
			if (!answer)
				break;
		}

		return answer;
	}
}
