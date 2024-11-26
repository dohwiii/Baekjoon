import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 0;
        Set<Integer> original = new HashSet<>();
        Set<Integer> additional = new HashSet<>();
        int N = cards.length;
        int sum = N + 1;
        
        for(int i=0; i<N/3; i++) {
            original.add(cards[i]);
        }
        int index = N/3;
        int round = 1;
        
        while(index < N) {
            additional.add(cards[index]);
            additional.add(cards[index + 1]);
            boolean isPossible = false;
            
            //가지고 있는 것 중에서 해결
            for(int a : original) {
                if(original.contains(sum - a)) {
                    original.remove(sum - a);
                    original.remove(a);
                    isPossible = true;
                    break;
                }
            }
            if(!isPossible) {
                if(coin > 0) {
                    for(int a : original) {
                        if(additional.contains(sum - a)) {
                            additional.remove(sum - a);
                            original.remove(a);
                            isPossible = true;
                            coin--;
                            break;
                        }
                    }
                }
            }
            if(!isPossible) {
                if(coin > 1) {
                    for(int a : additional) {
                        if(additional.contains(sum - a)) {
                            additional.remove(sum - a);
                            additional.remove(a);
                            isPossible = true;
                            coin -= 2;
                            break;
                        }
                    }
                }
            }
            
            if(!isPossible) {
                break;
            }
            
            round++;
            index+=2;
        }
        
        
        
        return round;
    }
}