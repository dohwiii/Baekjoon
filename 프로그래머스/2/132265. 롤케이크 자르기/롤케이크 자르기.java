import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> lset = new HashSet<>();
        Map<Integer, Integer> rmap = new HashMap<>();
        
        for(int i=0; i<topping.length; i++) {
            rmap.put(topping[i], rmap.getOrDefault(topping[i], 0)+1);
        }
        int rCnt = rmap.size();
        
        for(int i=0; i<topping.length; i++) {
            int now = topping[i];
            int cnt = rmap.getOrDefault(now, 0);
            
            if(cnt - 1 == 0) {    // 1개 들어가있어서 빼면 0개 -> map에서 삭제, 왼쪽 카운트 증가
                rmap.remove(now);
                lset.add(now);
                rCnt--;
            }
            else if(cnt > 0) {  // 오른쪽에 여전히 존재
                lset.add(now);
                rmap.put(now, cnt - 1);
            }
            int lCnt = lset.size();
            if(lCnt == rCnt) {
                answer++;
            }
        }
        
        
        
        return answer;
    }
}