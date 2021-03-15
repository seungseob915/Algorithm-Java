package kakao2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class 순위_검색 {
	static Map<String, ArrayList<Integer>> map=new HashMap<String, ArrayList<Integer>>();

	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] nquery = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		
		int[] result = new int[nquery.length];

		for (int i = 0; i < info.length; i++) {
			String infos[] = info[i].split(" ");
			String str = "";
			dfs(0, infos, str);
		}

		for(String s:map.keySet())
			Collections.sort(map.get(s));


		for (int i = 0; i < nquery.length; i++) {
			String q[] = nquery[i].split(" ");
			String temp = "";
			for(int j=0; j<q.length-1; j++) {
				if(q[j].equals("and")) continue;
				temp+=q[j];
			}
			int nowscore=Integer.parseInt(q[q.length-1]);
			if(map.containsKey(temp)){
				ArrayList<Integer> now=map.get(temp);
				
				int s=0;
				int e=now.size();
				
				while(s<e) {
					int mid=(s+e)/2;
					
					if(now.get(mid)<nowscore) {
						s=mid+1;
					}
					else {
						e=mid;
					}
				}
				result[i]=now.size()-s;
			}
		}
		for(int k=0; k<result.length; k++) {
			System.out.println(result[k]);
		}
	}

	private static void dfs(int depth, String[] infos, String str) {
		if (depth == 4) {
			if(map.containsKey(str)) {
				map.get(str).add(Integer.parseInt(infos[4]));
			}
			else {
				ArrayList<Integer> temp=new ArrayList<Integer>();
				temp.add(Integer.parseInt(infos[4]));
				map.put(str, temp);
			}
			return;
		}

		dfs(depth + 1, infos, str+infos[depth]);
		dfs(depth + 1, infos, str + "-");
	}

}

