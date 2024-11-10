import java.util.*;

class Solution {
    static int N, M;
    static boolean[] candidate;
    static Set<String> confirmCandidate;
    static int answer;
    
    public int solution(String[][] relation) {
        N = relation.length;    //행
        M = relation[0].length; //열(속성 개수)
        candidate = new boolean[M];
        confirmCandidate = new HashSet<>();
        
        for(int i=1; i<=M; i++) {
            candidate = new boolean[M];
            solve(0, i, relation, 0);
        }
        return answer;
    }
    public void solve(int depth, int candidateCnt, String[][] relation, int index) {  //순열
        if(depth == candidateCnt) { //개수만큼 다 뽑았을 때
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<M; i++) {
                if(candidate[i]) {
                    list.add(i);
                }
            }
            if(checkCandidateKey(list, relation)) {
                answer++;
            }
            return;
        }
        for(int i=index; i<M; i++) {
            if(!candidate[i]) {
                candidate[i] = true;
                solve(depth + 1, candidateCnt, relation, i+1);
                candidate[i] = false;
            }
        }
    }
    public boolean checkCandidateKey(List<Integer> colList, String[][] relation) {
        List<String> rowList = new ArrayList<>();
        //후보키 중에 같은 값이 있는지 걸러냄(유일성)
        for(int i=0; i<N; i++) {
            StringBuilder sb = new StringBuilder();
            for(int col : colList) {
                sb.append(relation[i][col]);
            }
            String str = sb.toString();
            if(rowList.contains(str)) { //이미 값이 존재한다면
                return false;
            }
            rowList.add(str);
        }
        //같은 값을 안가지는 컬럼집합 중에서 최소키가 만족하는지(최소성)
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for(int i : colList) {
            list.add(i);
            sb.append(i);
        }
        String str = sb.toString();
        // System.out.println(str);
        for(String s : confirmCandidate) {
            if(s.contains(str) || str.contains(s)) {
                // System.out.println(str + " " + s);
                return false;
            }
        }
        for(String s : confirmCandidate) {  //02
            int index = 0;
            for(char str_c : str.toCharArray()) {   //012
                if(s.charAt(index) == str_c) {
                    index++;
                }
                if(index == s.length()) {
                    return false;
                }
            }
        }
        confirmCandidate.add(str);
        return true;
    }
}