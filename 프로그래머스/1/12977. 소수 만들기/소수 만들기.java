import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer;
    
    public int solution(int[] nums) {
        visited = new boolean[nums.length];
        combi(0, 0, nums);
        return answer;
    }
    public static void combi(int start, int depth, int[] nums) {
        if(depth == 3) {    //3개 다 뽑음
            int sum = 0;
            for(int i=0; i<nums.length; i++) {
                if(visited[i]) {
                    sum += nums[i];
                }
            }
            boolean isTrue = true;
            if(sum > 1) {
                for(int i = 2; i < sum; i++) {
                    if(sum % i == 0) {
                        isTrue = false;
                        break;
                    }
                }
                if(isTrue) {
                    answer++;
                }
            }         
            return;
        }
        for(int i = start; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combi(i + 1, depth + 1, nums);
                visited[i] = false;
            }
        }
    }
}