package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 위장{
	public static void main(String[] args) {
		String[][] clothes= {{"crowmask", "face"}, 
				{"bluesunglasses", "face"}, 
				{"smoky_makeup", "face"}
		};
		
		int ret=solution(clothes);
		System.out.println(ret);
	}
	
	public static int solution(String[][] clothes) {
		Map<String, ArrayList<String>> cloth=new HashMap<String, ArrayList<String>>();
        
        for(int i=0; i<clothes.length; i++) {
        	if(cloth.containsKey(clothes[i][1])) {
        		ArrayList<String> temp=cloth.get(clothes[i][1]);
        		temp.add(clothes[i][0]);
        		cloth.put(clothes[i][1], temp);
        	}
        	else {
        		ArrayList<String> temp=new ArrayList<String>();
        		temp.add(clothes[i][0]);
        		cloth.put(clothes[i][1], temp);
        	}
        }
        
        int cnt=1;
        
        for(String keys : cloth.keySet()) {
        	cnt*=(cloth.get(keys).size()+1);
        }
        
        return cnt-1;
    }
}
