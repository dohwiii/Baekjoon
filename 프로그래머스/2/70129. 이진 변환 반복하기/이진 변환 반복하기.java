import java.util.*;

class Solution {
    static int zeroCnt;
    static int cnt;
    
    public int[] solution(String s) {  
        solve(s);
        int[] answer = new int[]{cnt, zeroCnt};
        return answer;
    }
    public void solve(String s) {
        if(s.equals("1")) {
            return;
        }
        String[] arr = s.split("1");
        for(String str : arr) {
            if(!str.isEmpty()) {
                zeroCnt += str.length();
            }
        }
        String trans = s.replace("0", "");
        String binary = Integer.toBinaryString(trans.length());
        cnt++;
        solve(binary);
    }
}