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
        int length = s.length();
        String trans = s.replace("0", "");
        zeroCnt += (length - trans.length());
        String binary = Integer.toBinaryString(trans.length());
        cnt++;
        solve(binary);
    }
}