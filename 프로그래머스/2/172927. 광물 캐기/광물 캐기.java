import java.util.*;

class Solution {
    static List<Integer> pickList;
    static int depth;
    static boolean[] visited;
    static int result;
    static int min = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int index = 0;
        pickList = new ArrayList<>();   //갖고 있는 곡괭이 
        
        for(int i=0; i<picks.length; i++) {
            int now = picks[i];
            while(now-- > 0) {
                pickList.add(i);
            }
        }

        visited = new boolean[pickList.size()];
        depth = Math.min(pickList.size(), (int) Math.ceil((double) minerals.length / 5));
        dfs(0, minerals);
                         
        return min;
    }
    public static void dfs(int index, String[] minerals) {
        if(result >= min) {
            return;
        }
        if(index == depth) {    //광물을 다 탐색했거나 or 곡괭이 다 썼다면
            min = Math.min(min, result);
            return;
        }
        for(int i=0; i<pickList.size(); i++) {
            if(visited[i]) continue;
            int fatigue = calcFatigue(pickList.get(i), index, minerals); //피로도 계산
            visited[i] = true;
            result += fatigue;
            dfs(index + 1, minerals);
            visited[i] = false;
            result -= fatigue;
        }
    }
    public static int calcFatigue(int pick, int start, String[] minerals) {
        start *= 5;
        int end = Math.min(start + 5, minerals.length);
        int sum = 0;

        for(int m = start; m < end; m++) {
            if(minerals[m].equals("diamond")) {
                sum += pick == 0 ? 1 : pick == 1 ? 5 : 25;
            }
            else if(minerals[m].equals("iron")) {
                sum += pick == 1 ? 1 : pick == 0 ? 1 : 5;
            }
            else {
                sum += pick == 2 ? 1 : pick == 0 ? 1 : 1;
            }
        }
        return sum;
    }
} 