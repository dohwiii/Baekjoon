import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int N = progresses.length;
        int[] need = new int[N];
        
        for(int i=0; i<N; i++) {
            int left = 100 - progresses[i]; // 남은 퍼센트
            int day = (int) Math.ceil(left / (double) speeds[i]);
            need[i] = day;
        }
        List<Integer> answerList = new ArrayList<>();
        int cnt = 1;
        int day = need[0];  // 첫번째 작업
        for(int i=1; i<N; i++) {
            if(day >= need[i]) {    // 같이 배포할 수 있다면
                cnt++;
            }
            else {  // 시간 더 소요
                answerList.add(cnt);
                cnt = 1;
                day = need[i];  // 초기화
            }
        }
        if(cnt > 0) {
            answerList.add(cnt);
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}