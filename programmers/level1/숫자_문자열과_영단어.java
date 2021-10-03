import java.util.*;

class Solution {

    public int solution(String s) {

        int answer = 0;

        String ns=s.replace("zero", "0");
        ns=ns.replace("one", "1");
        ns=ns.replace("two", "2");
        ns=ns.replace("three", "3");
        ns=ns.replace("four", "4");
        ns=ns.replace("five", "5");
        ns=ns.replace("six", "6");
        ns=ns.replace("seven", "7");
        ns=ns.replace("eight", "8");
        ns=ns.replace("nine", "9");

        answer=Integer.parseInt(ns);

        return answer;
    }
}