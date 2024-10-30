import java.util.*;

class Solution {
    static Map<String, List<Integer>> infoMap;
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        infoMap = new HashMap<>();
        
        for(int i=0; i<info.length; i++) {
            String[] arr = info[i].split(" ");
            buildCombination(arr, "", 0, Integer.parseInt(arr[4]));
        }
        for(String key : infoMap.keySet()) {
            Collections.sort(infoMap.get(key)); //점수 리스트 정렬
        }
        for(int i=0; i<query.length; i++) {
            String[] q = query[i].replaceAll(" and ", "").split(" ");
            String key = q[0];
            int targetScore = Integer.parseInt(q[1]);
            
            if(infoMap.containsKey(key)) {
                List<Integer> scores = infoMap.get(key);
                int idx = lowerBound(scores, targetScore);
                answer[i] = scores.size() - idx;
            }
        }
        return answer;
    }
    public void buildCombination(String[] arr, String str, int depth, int score) {
        if(depth == 4) {
            infoMap.computeIfAbsent(str, s -> new ArrayList<>()).add(score);    //점수 추가
            return;
        }
        buildCombination(arr, str + "-", depth + 1, score);
        buildCombination(arr, str + arr[depth], depth + 1, score);
    }
    public int lowerBound(List<Integer> scores, int targetScore) {
        int left = 0, right = scores.size();
        
        while(left < right) {
            int mid = (left + right) / 2;
            if(scores.get(mid) >= targetScore) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}