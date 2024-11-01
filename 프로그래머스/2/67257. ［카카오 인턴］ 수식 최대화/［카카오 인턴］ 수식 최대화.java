import java.util.*;

class Solution {
    static String[] operator = {"*", "-", "+"};
    static boolean[] visited = new boolean[3];
    static long max = 0;
    
    public long solution(String expression) {
        long answer = 0;
        String[] priority = new String[3];
        combination(0, expression, priority);
        return max;
    }
    public void combination(int depth, String expression, String[] priority) {
        if(depth == 3) {
            long result = Long.parseLong(calculate(expression, priority));
            max = Math.max(max, Math.abs(result));
            return;
        }
        for(int i=0; i<3; i++) {
            if(!visited[i]) {
                visited[i] = true;
                priority[depth] = operator[i];
                combination(depth + 1, expression, priority);
                visited[i] = false;
            }
        }
    }
    public String calculate(String expression, String[] priority) {
        String[] arr = expression.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)"); //문자와 숫자 분리
        List<String> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            list.add(arr[i]);
        }
        for(String op : priority) {
            int i = 0;
            while(i < list.size()) {
                if(list.get(i).equals(op)) {
                    long left = Long.parseLong(list.get(i-1));
                    long right = Long.parseLong(list.get(i+1));
                    long result = 0;
                    
                    switch(op) {
                        case "*" :
                            result = left * right;
                            break;
                        case "+" :
                            result = left + right;
                            break;
                        case "-" :
                            result = left - right;
                            break;
                    }
                        
                    list.set(i-1, String.valueOf(result));
                    list.remove(i); //연산자 제거
                    list.remove(i); //우측 피연산자 제거
                }
                else {
                    i++;
                }
            }
        }
        return list.get(0);
    }
}