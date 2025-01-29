class Solution {
    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static char[] current = new char[8];
    static boolean[] visited = new boolean[8];
    static int answer;
    
    public int solution(int n, String[] data) {
        answer = 0;
        permutation(0, data);
        
        return answer;
    }
    public void permutation(int depth, String[] data) {
        if(depth == 8) {    //탐색 끝
            if(checkCondition(data)) {
                answer++;
            }
            return;
        }
        for(int i=0; i<8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                current[depth] = friends[i];
                permutation(depth + 1, data);
                visited[i] = false;
            }
        }
    }
    public boolean checkCondition(String[] data) {
        for(String d : data) {
            int p1 = -1, p2 = -1;
            char f1 = d.charAt(0);
            char f2 = d.charAt(2);
            char op = d.charAt(3);
            int interval = d.charAt(4) - '0';
            
            for(int i=0; i<8; i++) {
                if(current[i] == f1) {
                    p1 = i;
                }
                if(current[i] == f2) {
                    p2 = i;
                }
            }
            int gap = Math.abs(p1 - p2) - 1;
            
            if(op == '=' && gap != interval) {
                return false;
            }
            if(op == '<' && gap >= interval) {
                return false;
            }
            if(op == '>' && gap <= interval) {
                return false;
            }
        }
        return true;
    }
}