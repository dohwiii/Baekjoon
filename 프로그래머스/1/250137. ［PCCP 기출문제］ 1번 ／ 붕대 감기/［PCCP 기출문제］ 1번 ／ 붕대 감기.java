import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int strength = health;
        int straight = 0;
        int second = 1;
        int lastTime = attacks[attacks.length - 1][0];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int[] attack : attacks) {
            map.put(attack[0], attack[1]);  //공격 시간, 피해량
        }
        
        while(second <= lastTime && strength > 0) {
            if(map.containsKey(second)) {   //지금 공격시간이라면
                strength -= map.get(second);  //공격
                straight = 0;
            }
            else {  //공격 X
                straight++; //연속
                strength = Math.min(health, strength + bandage[1]);
                
                if(straight == bandage[0]) {    //추가회복
                    strength = Math.min(health, strength + bandage[2]);
                    straight = 0;
                }
            }
            System.out.println(second+" "+ straight+" "+strength);
            second++;
        }
        if(strength <= 0) {
            strength = -1;
        }
        
        return strength;
    }
}