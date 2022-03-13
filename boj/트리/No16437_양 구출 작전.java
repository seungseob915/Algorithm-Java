import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int idx;
        int root;
        int objSize;
        boolean isWolf;
        ArrayList<Node> edge;

        public Node(int idx) {
            this.idx = idx;
            this.root = -1;
            this.objSize = 0;
            this.isWolf = false;
            this.edge = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Node node[]=new Node[N+1];
        long dpSum[]=new long[N+1];

        for(int i=0; i<=N; i++)
            node[i]=new Node(i);

        for(int i=2; i<=N; i++){
            StringTokenizer stk=new StringTokenizer(br.readLine());
            node[i].isWolf = stk.nextToken().charAt(0) == 'W' ? true : false;
            node[i].objSize = Integer.parseInt(stk.nextToken());

            int edgeIdx=Integer.parseInt(stk.nextToken());
            node[edgeIdx].edge.add(node[i]);
            dpSum[i]=node[i].isWolf==true?-(node[i].objSize):node[i].objSize;
        }

        dfs(node[1], dpSum);

        bw.write(String.valueOf(dpSum[1]));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(Node now, long[] dpSum) {
//        String debug="Lㅡㅡㅡ";
//        for(int i=0; i<depth; i++)
//            debug+="ㅡㅡㅡㅡ";
//        System.out.println(debug + " " + "Idx : " + now.idx);

//        System.out.println("   Sheep : " + nSheep + "  / wolf : "+nWolf);

        for(Node child : now.edge){
            child.root = now.idx;
            dfs(child, dpSum);
        }

        if(now.idx!=1){
            if(dpSum[now.idx]>0){
                dpSum[now.root]+=dpSum[now.idx];
            }
        }
    }
}

