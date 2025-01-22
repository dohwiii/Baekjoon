import java.util.*;

class Solution {
    static List<Character> ops = new ArrayList<>(); //연산자
    static List<Long> nums = new ArrayList<>(); //숫자
    static boolean[] visited = new boolean[3];
    static List<char[]> priorityList = new ArrayList<>();
    static char[] operator = {'+', '*', '-'};
    static long max = 0;

    public long solution(String expression) {
        char[] priority = new char[3];
        long answer = 0;
        int start = 0;
        
        for(int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if(c == '*' || c == '-' || c == '+') {
                long number = Long.parseLong(expression.substring(start, i));
                nums.add(number);   //숫자 추가
                start = i + 1;  //인덱스 초기화
                ops.add(c); //연산자 추가
            }
        }
        nums.add(Long.parseLong(expression.substring(start)));  //마지막 숫자 추가
        permutation(0, priority);   //조합 
        
        for(char[] p : priorityList) {
            List<Character> opsCopy = new ArrayList<>(ops);
            List<Long> numsCopy = new ArrayList<>(nums);
            long result = Math.abs(calc(opsCopy, numsCopy, p));
            max = Math.max(max, result);
        }
    
        return max;
    }
    public long calc(List<Character> op, List<Long> num, char[] priority) {
        for(char c : priority) {    //연산자 조합
            int i = 0;
            
            while(i < op.size()) {
                if(c == op.get(i)) {    //연산자 일치
                    long left = num.get(i);
                    long right = num.get(i + 1);
                    long result = applyOperator(left, right, c);
                    
                    num.set(i, result);
                    num.remove(i+1);
                    op.remove((Object) c);
                }
                else {
                    i++;
                }
            }
        }
        return num.get(0);
    }
    public long applyOperator(long a, long b, char op) {
        switch(op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
        }
        return 0;
    }
    public void permutation(int depth, char[] priority) {
        if(depth == 3) {
            priorityList.add(priority.clone());
            return;
        }
        for(int i=0; i<3; i++) {
            if(!visited[i]) {
                visited[i] = true;
                priority[depth] = operator[i];
                permutation(depth + 1, priority);
                visited[i] = false;
            }
        }
    }
}