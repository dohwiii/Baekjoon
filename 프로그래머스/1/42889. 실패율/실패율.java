import java.util.*;
class Solution {
    static class Score {
        double percent;
        int stage;
        public Score(double percent, int stage) {
            this.percent = percent;
            this.stage=stage;
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int people = stages.length;
        int[] progress = new int[N + 2];
        Score[] ratio = new Score[N];
        
        for(int i=0; i<stages.length; i++) {
            progress[stages[i]]++;
        }
        for(int i=1; i<=N; i++) {
            double s = progress[i] / (double) people;
            if(people == 0) {
                s = 0.0;
            }
            ratio[i - 1] = new Score(s, i);
            people -= progress[i];
        }
        Arrays.sort(ratio, new Comparator<Score>() {
            @Override
            public int compare(Score s1, Score s2) {
                return Double.compare(s2.percent, s1.percent);
            }
        });
        for(int i=0; i<N; i++) {
            answer[i] = ratio[i].stage;
        }
        return answer;
    }
}