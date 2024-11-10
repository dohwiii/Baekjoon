import java.util.*;

class Solution {
    static int N, M;
    static List<Set<Integer>> candidateKeys; // 후보키 목록을 Set<Integer>로 저장
    static int answer = 0;

    public int solution(String[][] relation) {
        N = relation.length;    // 행의 수 (튜플 개수)
        M = relation[0].length; // 열의 수 (속성 개수)
        candidateKeys = new ArrayList<>();

        // 1개 속성 조합부터 M개 속성 조합까지 생성
        for (int r = 1; r <= M; r++) {
            findCombinations(new HashSet<>(), 0, r, relation);
        }

        return candidateKeys.size(); // 후보키의 개수
    }

    // 조합을 생성하고 유일성, 최소성 검사를 수행하는 메소드
    private void findCombinations(Set<Integer> combination, int start, int r, String[][] relation) {
        // r개의 조합이 완성되면 유일성 및 최소성 검사
        if (combination.size() == r) {
            if (isUnique(combination, relation) && isMinimal(combination)) {
                candidateKeys.add(new HashSet<>(combination)); // 후보키로 추가
            }
            return;
        }

        // 조합 생성 (백트래킹)
        for (int i = start; i < M; i++) {
            combination.add(i);
            findCombinations(combination, i + 1, r, relation);
            combination.remove(i); // 백트래킹
        }
    }

    // 유일성 검사
    private boolean isUnique(Set<Integer> combination, String[][] relation) {
        Set<String> uniqueCheck = new HashSet<>();

        for (int i = 0; i < N; i++) {
            StringBuilder key = new StringBuilder();
            for (int col : combination) {
                key.append(relation[i][col]).append(",");
            }
            if (!uniqueCheck.add(key.toString())) { // 유일성 검사 실패
                return false;
            }
        }
        return true;
    }

    // 최소성 검사
    private boolean isMinimal(Set<Integer> combination) {
        for (Set<Integer> key : candidateKeys) {
            if (combination.containsAll(key)) {
                return false; // 기존 후보키의 부분집합이면 최소성 실패
            }
        }
        return true;
    }
}
