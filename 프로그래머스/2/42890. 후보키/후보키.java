import java.util.*;

class Solution {
    static int N, M;
    static int answer;
    static List<Integer> candidateKeys;

    public int solution(String[][] relation) {
        N = relation.length;    // 행
        M = relation[0].length; // 열(속성 개수)
        candidateKeys = new ArrayList<>();

        for (int i = 1; i < (1 << M); i++) {
            if (isUnique(i, relation) && isMinimal(i)) {
                candidateKeys.add(i);
            }
        }

        return candidateKeys.size();
    }

    // 유일성 검사
    private boolean isUnique(int subset, String[][] relation) {
        Set<String> seen = new HashSet<>();
        
        for (String[] row : relation) {
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < M; j++) {
                if ((subset & (1 << j)) != 0) {  // j번째 속성이 subset에 포함되면 추가
                    key.append(row[j]).append(",");
                }
            }
            if (!seen.add(key.toString())) {  // 이미 존재하는 키이면 유일성 실패
                return false;
            }
        }
        return true;
    }

    // 최소성 검사
    private boolean isMinimal(int subset) {
        for (int key : candidateKeys) {
            if ((key & subset) == key) { // subset이 key를 포함하고 있으면 최소성 실패
                return false;
            }
        }
        return true;
    }
}
