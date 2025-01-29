import java.util.*;

class Solution {
    private char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private boolean[] visited = new boolean[8];
    private String[] conditions;
    private int answer;
    private char[] current = new char[8];
    
    public int solution(int n, String[] data) {
        conditions = data;
        answer = 0;
        permutation(0);
        return answer;
    }
    
    // 순열 생성
    private void permutation(int depth) {
        if (depth == 8) {
            if (checkConditions()) {
                answer++;
            }
            return;
        }
        
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current[depth] = friends[i];
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
    
    // 조건 체크
    private boolean checkConditions() {
        for (String condition : conditions) {
            int pos1 = -1, pos2 = -1;
            char friend1 = condition.charAt(0);
            char friend2 = condition.charAt(2);
            char operator = condition.charAt(3);
            int value = condition.charAt(4) - '0';
            
            // 두 프렌즈의 위치 찾기
            for (int i = 0; i < 8; i++) {
                if (current[i] == friend1) pos1 = i;
                if (current[i] == friend2) pos2 = i;
            }
            
            int gap = Math.abs(pos1 - pos2) - 1;
            
            // 조건 체크
            if (operator == '=' && gap != value) return false;
            if (operator == '<' && gap >= value) return false;
            if (operator == '>' && gap <= value) return false;
        }
        return true;
    }
}