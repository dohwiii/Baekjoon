import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        Map<String, Integer> idMap = new HashMap<>();
        boolean[][] reports = new boolean[n][n];
        
        for(int i=0; i<n; i++) {
            idMap.put(id_list[i], i);
        }
        
        for(String str : report) {
            String[] parts = str.split(" ");
            String reporter = parts[0];
            String reported = parts[1];
            
            reports[idMap.get(reporter)][idMap.get(reported)] = true;
        }
        int[] reportCount = new int[n];
        
        for(int i=0; i<n; i++) {    //신고한사람
            for(int j=0; j<n; j++) {    //신고당한사람
                if(reports[i][j]) {
                    reportCount[j]++;
                }  
            }
        }
        for(int i=0; i<n; i++) {    //신고당한 사람
            if(reportCount[i] >= k) {
                for(int j=0; j<n; j++) {    //신고한사람
                    if(reports[j][i]) {
                        answer[j]++;
                    }
                }
            }
        }
        
        
        return answer;
    }
}