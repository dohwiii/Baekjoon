import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        boolean isPossible = true;
        Map<String, Integer> map = new HashMap<>(); //사야할 제품과 수량
        Map<String, Integer> buy = new HashMap<>(); //할인 제품 산 것
        for(int i=0; i<want.length; i++) {
            map.put(want[i], number[i]);
        } 
        for(int i=0; i<10; i++) {
            buy.put(discount[i], buy.getOrDefault(discount[i], 0) + 1);
        }
        if(checkMatches(map, buy)) {
            answer++;
        }
        int quantity = 0;
        for(int i=1; i<discount.length - 9; i++) {
            isPossible = true;

            String prev = discount[i - 1];
            quantity = buy.get(prev);
            if(quantity == 1) {
                buy.remove(prev);
            }
            else if(quantity > 1) {
                buy.put(prev, quantity - 1);
            }

            String next = discount[i + 9];
            quantity = buy.getOrDefault(next, 0);
            buy.put(next, quantity + 1);

            //수량 맞는지 확인
            if(checkMatches(map, buy)) {
                answer++;
            }
        }
        
        return answer;
    }
    public boolean checkMatches(Map<String, Integer> wantMap, Map<String, Integer> buyMap) {
        for(String key : wantMap.keySet()) {
            if(!buyMap.getOrDefault(key, 0).equals(wantMap.get(key))) {
                return false;
            }
        }
        return true;
    }
}