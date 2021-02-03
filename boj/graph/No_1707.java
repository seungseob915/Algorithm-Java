package kr.boj.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_1707 {
	static LinkedList<Integer> node[];
	static int nodetype[];	//0 아직 방문 x, 1, 2 ==> 이분그래프 : 1, 2 두 종류가 되어야함
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int input = Integer.parseInt(br.readLine());
		
		while(input>0){
			String str=br.readLine();
			StringTokenizer st=new StringTokenizer(str, " ");
			int v=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			
			node=new LinkedList[v+1];
			nodetype=new int[v+1];
			
			Arrays.fill(nodetype, 0);
			
			for(int j=0; j<=v; j++)	node[j]=new LinkedList<Integer>();
			
			// 간선 저장
			for(int j=0; j<c; j++) {
				String str2=br.readLine();
				StringTokenizer st2=new StringTokenizer(str2, " ");
				int n1=Integer.parseInt(st2.nextToken());
				int n2=Integer.parseInt(st2.nextToken());
				
				node[n1].add(n2);
				node[n2].add(n1);
			}
			
			boolean chk=true;
			
			// 1개 노드씩 방문하며 체크하자
			for(int j=1; j<=v; j++) {
				if(nodetype[j]==0)
					if(dfs(j, 1)==false)
						chk=false;	
			}
			
			if(chk) bw.write("YES");
			else bw.write("NO");
			bw.newLine();
			input--;
		}
		bw.flush();
		bw.close();
	}

	public static boolean dfs(int idx, int no) {
		
		nodetype[idx]=no;	// 방문 후 type설정
		
		Iterator<Integer> it=node[idx].listIterator();
		
		while(it.hasNext()) {
			int next=it.next();
			
			//1. 다음 노드가 아직 방문 안한 상태
			if(nodetype[next]==0) {
				// 현재 - 다음 노드타입이 1-2 / 2-1 형태가 아니라면
				if(dfs(next, 3-no)==false)
					return false;
			}
			//2. 다음 노드가 체크되어있는데, 현재 노드와 타입이 같으면 -> 이분그래프가 아님
			else if(nodetype[next] == nodetype[idx])
				return false;
		}
		return true;
	}

}
