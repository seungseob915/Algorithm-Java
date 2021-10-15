import java.util.*;

class Infos{
    String id;
    String doing;
    
    public Infos(String id, String doing){
        this.id=id;
        this.doing=doing;
    }
}

class Solution {
    public String[] solution(String[] record) {
        ArrayList<Infos> ans_list = new ArrayList<>();
        HashMap<String, String> id_nick=new HashMap<>();
        
        for(int i=0; i<record.length; i++){
            String[] info=record[i].split(" ");

            if(info[0].equals("Enter")){
                ans_list.add(new Infos(info[1], "님이 들어왔습니다."));
                id_nick.put(info[1], info[2]);
            }
            else if(info[0].equals("Leave")){
                ans_list.add(new Infos(info[1], "님이 나갔습니다."));
            }
            else{
                id_nick.replace(info[1], info[2]);
            }
        }
        
        String[] answer=new String[ans_list.size()];
        
        for(int i=0; i<ans_list.size(); i++){
            answer[i]=id_nick.get(ans_list.get(i).id)+ans_list.get(i).doing;
        }
        
        return answer;
    }
}