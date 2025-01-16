import java.util.HashSet;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 당첨 번호를 Set에 저장
        HashSet<Integer> winSet = new HashSet<>();
        for (int win : win_nums) {
            winSet.add(win);
        }

        int zeroCount = 0; // 0의 개수
        int matchCount = 0; // 맞힌 번호 개수

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++; // 0의 개수 증가
            } else if (winSet.contains(lotto)) {
                matchCount++; // 당첨 번호와 일치하는 경우
            }
        }

        // 순위 계산 (맞힌 개수가 6이면 1등, 5면 2등, ... 0개면 6등)
        int maxRank = Math.min(7 - (matchCount + zeroCount), 6);
        int minRank = Math.min(7 - matchCount, 6);

        return new int[] {maxRank, minRank};
    }
}