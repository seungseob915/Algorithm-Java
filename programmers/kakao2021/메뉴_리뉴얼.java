package kakao2021;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class 메뉴_리뉴얼 {
	static boolean[] alpha = new boolean[27];
	static Map<String, Integer> cnt = new HashMap<String, Integer>();
	static Set<String> result = new HashSet<String>();

	public static void main(String[] args) {
		String[] orders = { "XYZ", "XWY", "WXA" };
		int[] course = { 2, 3, 4 };

		String[] order = orders;
		int[] courses = course;

		for (int i = 0; i < courses.length; i++) {
			for (int j = 0; j < order.length; j++) {
				dfs(0, 0, courses[i], order[j], j);
			}
			Iterator<String> keys = cnt.keySet().iterator();
			if (cnt.size() != 0) {
				int now_max = Collections.max(cnt.values());
				if (now_max >= 2) {
					while (keys.hasNext()) {
						String str = keys.next();
						if (cnt.get(str) == now_max) {
							result.add(str);
						}
					}
				}
				cnt.clear();
			}
		}

		String[] ret = new String[result.size()];
		result.toArray(ret);
		Arrays.sort(ret);

		// return ret;

		for (int i = 0; i < ret.length; i++)
			System.out.println(ret[i]);
	}

	private static void dfs(int idx, int depth, int finish, String order, int ord_idx) {
		if (depth == finish) {
			String key = "";
			for (int i = 1; i < 27; i++) {
				if (alpha[i]) {
					key += (char) (i + 64);
				}
			}

			if (cnt.containsKey(key)) {
				cnt.put(key, cnt.get(key) + 1);
			} else {
				cnt.put(key, 1);
			}
		}

		for (int i = idx; i < order.length(); i++) {
			alpha[order.charAt(i) - 64] = true;
			dfs(i + 1, depth + 1, finish, order, ord_idx);
			alpha[order.charAt(i) - 64] = false;
		}
	}

}
