import java.util.*;

class Solution {
    static List<Integer> list;
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        list = new ArrayList<>();
        list.add(k);
        
        int times = calc(k, 0); //몇번 했는지
        double[] function = new double[times+1];
        int index = 0;
        for(int i = 0; i < times; i++) {
            function[i] = calcArea(i, i+1, times);
        }
        for(int[] range : ranges) {
            int start = range[0];
            int end = times + range[1];
            if(start > end) {
                answer[index++] = -1.0;
                continue;
            }
            double sum = 0;
            for(int i=start; i<end; i++) {
                sum += function[i];
            }
            answer[index++] = sum;
        }

        return answer;
    }
    public double calcArea(int a, int b, int n) {
        int start = a;
        int end = b;
        int height = end - start;
        
        return (list.get(start) + list.get(end)) * height * 0.5;
    }
    public int calc(int num, int depth) {
        if(num == 1) {
            return depth;
        }
        if(num % 2 == 0) {
            list.add(num / 2);
            return calc(num / 2, depth + 1);
        }
        else {
            list.add(num * 3 + 1);
            return calc(num * 3 + 1, depth + 1);
        }
    }
}