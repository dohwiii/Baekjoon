import java.util.*;

class Solution {
    static List<Integer> collatz;
    static List<Double> areas;
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        areas = new ArrayList<>();
        collatz = new ArrayList<>();
        collatz.add(k);
        
        calc(k); //좌표, 면적 계산
        int index = 0;
        int n = areas.size();
        
        for(int[] range : ranges) {
            int start = range[0];
            int end = n + range[1];
            if(start > end) {
                answer[index++] = -1.0;
                continue;
            }
            double sum = 0;
            for(int i=start; i<end; i++) {
                sum += areas.get(i);
            }
            answer[index++] = sum;
        }

        return answer;
    }
    public void calc(int num) {
        if(num == 1) {
            return;
        }
        if(num % 2 == 0) {
            int next = num / 2;
            areas.add((next + num) / 2.0);
            collatz.add(next);
            calc(next);
        }
        else {
            int next = num * 3 + 1;
            areas.add((next + num) / 2.0);
            collatz.add(next);
            calc(next);
        }
    }
}