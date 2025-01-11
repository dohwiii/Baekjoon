import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int appleAmount = score.length; //사과 개수
        int boxAmount = appleAmount / m;    //포장 상자 개수

        Arrays.sort(score);

        if(appleAmount % m == 0) {  //모든 사과를 포장할 수 있다면
            int index = 0;
            
            while(index < score.length) {
                int min = score[index]; //제일 최소 점수
                int s = min * m;
                answer += s;
                index += m;
            }
        }
        else {
            int remain = appleAmount % m;
            
            for(int i=score.length - 1; i>remain; i-=m) {
                int start = score[i - m + 1];
                answer += (start * m);
            }
        }
        
        return answer;
    }
}