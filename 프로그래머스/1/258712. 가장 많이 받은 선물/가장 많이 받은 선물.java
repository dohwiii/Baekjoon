import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int N = friends.length;
        int[][] giveTake = new int[N][N];
        int[][] present = new int[N][3];
        int[] receive = new int[N];
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for(String s : friends) {
            map.put(s, index++);
        }
        
        for(int i=0; i<gifts.length; i++) {
            String[] person = gifts[i].split(" ");
            String A = person[0];
            String B = person[1];
            
            int aIndex = map.get(A);
            int bIndex = map.get(B);
            
            giveTake[aIndex][bIndex]++; 
            present[aIndex][0]++;   //준 선물
            present[bIndex][1]++;   //받은 선물
            
        }
        for(int i=0; i<N; i++) {
            present[i][2] = present[i][0] - present[i][1];  //준거 - 받은거
        }
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(i==j) continue;
                int a = giveTake[i][j];
                int b = giveTake[j][i];
                if(a > b) {
                    receive[i]++;
                }
                else if(a < b) {
                    receive[j]++;
                }
                else {
                    if(present[i][2] > present[j][2]) {
                        receive[i]++;
                    }
                    else if(present[i][2] < present[j][2]) {
                        receive[j]++;
                    }
                }
            }
        }
        for(int i=0; i<N; i++) {
            answer = Math.max(answer, receive[i]);
        }
        
        return answer;
    }
}