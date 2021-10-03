
import java.util.PriorityQueue;

public class 더_맵게 {

	public static void main(String[] args) {
		int[] scoville= {1, 2, 3, 9, 10, 12};
		int K=7;
		
		int ans=solution(scoville, K);
		System.out.println(ans);
		
	}
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i=0; i<scoville.length; i++)
        	pq.offer(scoville[i]);
       
        while(true) {
        	int now=pq.poll();
        	
        	if(answer>scoville.length-1) {
        		answer=-1;
        		break;
        	}
        	if(now>=K) break;
        	
        	int s_now=pq.poll();
        	
        	int new_one=now+(s_now*2);
        	answer++;
        	pq.offer(new_one);
        }
        
        return answer;
    }

}
