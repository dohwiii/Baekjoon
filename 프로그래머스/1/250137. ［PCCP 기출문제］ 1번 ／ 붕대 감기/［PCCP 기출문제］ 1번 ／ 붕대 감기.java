import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 변수 초기화
        int currentHealth = health;
        int consecutiveSuccess = 0;
        int attackIndex = 0;
        int time = 1;

        // 공격 시간 처리
        while (currentHealth > 0 && attackIndex < attacks.length) {
            int nextAttackTime = attacks[attackIndex][0];

            // 공격 시간 전까지 가능한 최대 연속 회복 시간 계산
            int recoveryTime = nextAttackTime - time;

            if (recoveryTime > 0) {
                // 가능한 회복 횟수 계산
                int fullCycles = Math.min(recoveryTime / bandage[0], (health - currentHealth) / (bandage[0] * bandage[1] + bandage[2]));

                // 체력을 회복할 수 있는 경우
                if (fullCycles > 0) {
                    currentHealth = Math.min(health, currentHealth + fullCycles * (bandage[0] * bandage[1] + bandage[2]));
                    consecutiveSuccess = 0;
                    time += fullCycles * bandage[0];
                }

                // 남은 시간 동안의 회복 계산
                while (time < nextAttackTime && currentHealth < health) {
                    currentHealth = Math.min(health, currentHealth + bandage[1]);

                    if (++consecutiveSuccess == bandage[0]) {
                        currentHealth = Math.min(health, currentHealth + bandage[2]);
                        consecutiveSuccess = 0;
                    }

                    time++;
                }
            }

            // 공격 처리
            currentHealth -= attacks[attackIndex][1];
            consecutiveSuccess = 0;
            attackIndex++;
            time = nextAttackTime + 1;
        }

        // 마지막 공격 이후 남은 시간 동안 회복
        while (currentHealth > 0 && time <= attacks[attacks.length - 1][0]) {
            currentHealth = Math.min(health, currentHealth + bandage[1]);

            if (++consecutiveSuccess == bandage[0]) {
                currentHealth = Math.min(health, currentHealth + bandage[2]);
                consecutiveSuccess = 0;
            }

            time++;
        }

        // 체력이 0 이하라면 -1 반환
        return currentHealth > 0 ? currentHealth : -1;
    }
}