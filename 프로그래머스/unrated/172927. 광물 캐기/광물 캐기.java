import java.util.*;

class Solution {
    static int depth, calc;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {
        int tool = 0;
        ArrayList<Integer> pickList = new ArrayList<>();
        for (int i = 0; i < picks.length; i++) {
            for (int j = 0; j < picks[i]; j++) {
                if (picks[i] > 0) {
                    pickList.add(i);
                    tool++;
                }
            }
        }

        //주어진 곡괭이 수, 광물을 모두 캐는데 필요한 곡괭이 수
        depth = Math.min((int) Math.ceil((double) minerals.length / 5), tool);
        visited = new boolean[pickList.size()];

        dfs(0, pickList, minerals);
        return min;

    }
    public static void dfs(int index, ArrayList<Integer> pickList, String[] minerals) {

        if (calc >= min) {
            return;
        }
        if (index == depth) {
            min = Math.min(min, calc);
            return;
        }
        for (int i = 0; i < pickList.size(); i++) {
            if (!visited[i]) {
                int temp = fatigue(pickList.get(i), index, minerals);
                visited[i] = true;
                calc += temp;
                dfs(index + 1, pickList, minerals);
                visited[i] = false;
                calc -= temp;
            }

        }
    }
     public static int fatigue(int num, int start, String[] minerals) {
       //num : 곡괭이 타입(0:다이아 / 1:철 / 2:돌)
        start = start * 5;
        int range = Math.min(start + 5, minerals.length);
        int sum = 0;

        for (int i = start; i < range; i++) {
            switch (minerals[i]) {
                //다이아몬드 광물을 0:다이아몬드 곡괭이 / 1: 철 곡괭이 / 2: 돌 곡괭이
                case "diamond" -> sum += num == 0 ? 1 : num == 1 ? 5 : 25;

                case "iron" -> sum += num == 0 ? 1 : num == 1 ? 1 : 5;

                case "stone" -> sum += 1;
            }
        }
        return sum;
    }
}