import java.util.*;
import java.util.function.BiFunction;

class Solution {
    static String[] operator = {"*", "-", "+"};
    static boolean[] visited = new boolean[3];
    static long max = 0;
    static Map<String, BiFunction<Long, Long, Long>> operations = new HashMap<>();
    
    static {
        operations.put("*", (a, b) -> a * b);
        operations.put("+", (a, b) -> a + b);
        operations.put("-", (a, b) -> a - b);
    }
    
    public long solution(String expression) {
        max = 0;  // reset max for each call
        String[] priority = new String[3];
        combination(0, expression, priority);
        return max;
    }
    
    public void combination(int depth, String expression, String[] priority) {
        if (depth == 3) {
            long result = Math.abs(calculate(expression, priority));
            max = Math.max(max, result);
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                priority[depth] = operator[i];
                combination(depth + 1, expression, priority);
                visited[i] = false;
            }
        }
    }
    
    public long calculate(String expression, String[] priority) {
        List<String> list = new ArrayList<>(Arrays.asList(expression.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)")));
        
        for (String op : priority) {
            int i = 0;
            while (i < list.size()) {
                if (list.get(i).equals(op)) {
                    long left = Long.parseLong(list.get(i - 1));
                    long right = Long.parseLong(list.get(i + 1));
                    long result = operations.get(op).apply(left, right);
                    
                    list.set(i - 1, String.valueOf(result));
                    list.remove(i); // 연산자 제거
                    list.remove(i); // 우측 피연산자 제거
                } else {
                    i++;
                }
            }
        }
        return Long.parseLong(list.get(0));
    }
}
