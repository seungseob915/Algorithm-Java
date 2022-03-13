import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int idx;
        int root;
        ArrayList<Node> edge;

        public Node(int idx) {
            this.idx = idx;
            this.root = -1;
            this.edge = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int N=Integer.parseInt(br.readLine());
        Node node[]=new Node[N+1];
        for(int i=1; i<=N; i++) {
            node[i] = new Node(i);
        }

        for(int i=0; i<N-1; i++){
            StringTokenizer stk=new StringTokenizer(br.readLine());

            int ta=Integer.parseInt(stk.nextToken());
            int tb=Integer.parseInt(stk.nextToken());

            node[ta].edge.add(node[tb]);
            node[tb].edge.add(node[ta]);
        }

        Queue<Node> q=new LinkedList<>();
        boolean chk[]=new boolean[N+1];

        q.add(node[1]);
        chk[1]=true;

        while(!q.isEmpty()){
            Node now=q.poll();

            for(Node child : now.edge){
                if(!chk[child.idx]){
                    chk[child.idx]=true;
                    child.root=now.idx;
                    q.add(child);
                }
            }
        }

        for(int i=2; i<=N; i++){
            bw.write(node[i].root+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

