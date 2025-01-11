import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int appleAmount = score.length; //사과 개수

        Arrays.sort(score);

        int remain = appleAmount % m;   //남는 사과(버림)
            
        for(int i=score.length - 1; i>remain; i-=m) {
            int start = score[i - m + 1];
            answer += (start * m);
        }
        
        return answer;
    }
}