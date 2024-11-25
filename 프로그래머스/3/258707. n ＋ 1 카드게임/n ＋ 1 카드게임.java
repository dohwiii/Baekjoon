import java.util.*;

class Solution {
    static int targetSum;
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        targetSum = n + 1;
        int rounds = 1;

        // 초기 카드 n/3 장 손에 넣기
        Set<Integer> original = new HashSet<>();
        Set<Integer> additional = new HashSet<>();
        
        for (int i = 0; i < n / 3; i++) {
            original.add(cards[i]);
        }
        // 카드 뭉치에서 나머지 카드 처리
        int index = n / 3;
        while (index < n) {
            // 손에 카드가 부족하면 종료
            if (original.size() == 0) break;
            
            // 카드를 두 장 뽑음
            additional.add(cards[index]);
            additional.add(cards[index + 1]);
            
            //넣는게 가능한지
            boolean isPossible = false;

            // 1. 현재 상태에서 n+1 조합 되는지 확인
            if(findSum(original)) {
                isPossible = true;
            }
            if(!isPossible) {
                 // 2. 한 장만 추가하고 조합 확인
                if(coin >= 1) {
                    for(int o : original) {
                        if(additional.contains(targetSum - o)) {
                            original.remove(o);
                            additional.remove(targetSum - o);
                            coin--;
                            isPossible = true;
                            break;
                        }
                    }
                }
            }
            if(!isPossible) {
                if(coin >= 2) {
                    for(int a : additional) {
                        if(additional.contains(targetSum - a)) {
                            additional.remove(a);
                            additional.remove(targetSum - a);
                            coin -= 2;
                            isPossible = true;
                            break;
                        }
                    }
                }
            }
            if(!isPossible) {
                break;
            }
            rounds++;
            index += 2;
        }

        return rounds;
    }
    public boolean findSum(Set<Integer> myCards) {
        for (int card : myCards) {
            int complement = targetSum - card;
            if (myCards.contains(complement) && card != complement) {
                myCards.remove(card);
                myCards.remove(complement);
                return true;
            }
        }
        return false;
    }
}