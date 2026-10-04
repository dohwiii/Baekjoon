import java.util.*;

// 각 곡괭이는 광물 5개까지 캘 수 있음
// 한번 사용하면 사용할 수 없을 때까지 사용
// 광물은 순서대로만!
 // 가지고 있는 곡괭이 수보다 광물 수가 더 많다면 -> 캘 수 있는 광물까지만 계산
class Solution {
    static int min = Integer.MAX_VALUE;
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalMinerals = minerals.length;
        int totalPicks = 0;
        
        for(int a : picks) {
            totalPicks += a;
        }
        int[] copyPicks = picks.clone();
        int index = 0;
        int[] allPicks = new int[totalPicks];

        int needPicks = (int) Math.ceil((double)totalMinerals / 5); // 모든 광물들 캐기 위해서 필요한 곡괭이 수
        int endMinerals = minerals.length;
        
        if(totalPicks < needPicks) {
            needPicks = totalPicks;
        }
        choosePick(0, new int[needPicks], new boolean[allPicks.length], needPicks, copyPicks, endMinerals, minerals);
        
        // 마인이 작업을 끝내기까지 필요한 최소한의 피로도
        return min;
    }
    private static void choosePick(int depth, int[] arr, boolean[] visited, int needPicks, int[] copyPicks, int end, String[] minerals) {   // 사용할 곡괭이 선정
        if(depth == needPicks) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<arr.length; i++) {
                sb.append(arr[i]);
            }
            int result = gainMinerals(end, arr, minerals);
            min = Math.min(min, result);
            return;
        }

        for(int i=0; i<copyPicks.length; i++) {
            if(copyPicks[i] > 0) {
                copyPicks[i]--;
                if(i == 0) { // 다이아몬드
                    arr[depth] = 1;
                }
                else if(i == 1) {    // 철
                    arr[depth] = 2;
                }
                else {
                    arr[depth] = 3;
                }     
                choosePick(depth+1, arr, visited, needPicks, copyPicks, end, minerals);
                copyPicks[i]++;
            }
        }
        
    }
    private static int gainMinerals(int end, int[] choicePicks, String[] minerals) {
        int picksIndex = 0;
        int fatigue = 0;
        
        for(int i=0; i<end; i++) {
            if(picksIndex >= choicePicks.length) {
                break;
            }
            if(choicePicks[picksIndex] == 1) {   // 다이아몬드 곡괭이라면
                fatigue += 1;
            }
            else if(choicePicks[picksIndex] == 2) {  // 철 곡괭이라면
                if(minerals[i].equals("diamond")) {
                    fatigue += 5;
                }
                else {
                    fatigue += 1;
                }
            }
            else {  // 돌 곡괭이
                if(minerals[i].equals("diamond")) {
                    fatigue += 25;
                }
                else if(minerals[i].equals("iron")) {
                    fatigue += 5;
                }
                else {
                    fatigue += 1;
                }
            }
            if((i + 1) % 5 == 0) {  // 쓰던 곡괭이 사용 끝
                picksIndex++;
            }       
        }
        return fatigue;
    }
}