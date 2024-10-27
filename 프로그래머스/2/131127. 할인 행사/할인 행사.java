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
       
        for(int i=0; i<=discount.length-10; i++) {
            buy = new HashMap<>();
            boolean isEnd = true;   //중도에 틀린 것 없이 다 탐색했다면
            isPossible = true;  //사야할 수량과 같다면
            
            for(int j=i; j<i+10; j++) {
                if(!map.containsKey(discount[j])) { //사야할 제품이 아니라면
                    isEnd = false;
                    break;
                }
                int amount = map.get(discount[j]);  //사야할 수량
                int buyAmount = buy.getOrDefault(discount[j], 0);   //이제까지 산거
                // System.out.println(i+" "+discount[j]+" "+amount+" "+(buyAmount+1));
                if(buyAmount + 1 > amount) {    //사야할 것보다 더 샀다면
                    isEnd = false;
                    break;
                }
                buy.put(discount[j], buyAmount + 1); //구매
            }
            if(isEnd) {
                for(String key : map.keySet()) {
                    int amount = map.get(key);
                    if(amount != buy.get(key)) {
                        isPossible = false;
                        break;
                    }
                    if(!buy.containsKey(key)) {
                        isPossible = false;
                        break;
                    }
                }
                if(isPossible) {
                    answer++;
                }
            }       
            
        }
        
        
        return answer;
    }
}