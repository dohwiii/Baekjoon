import java.util.*;

class Solution {
    static String[] operators = {"+", "-", "*"};
    static long max = 0;

    public long solution(String expression) {
        // 모든 연산자 우선순위 조합 생성
        List<String[]> permutations = generatePermutations(operators);
        max = 0;

        // 수식 파싱
        List<Long> numbers = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        parseExpression(expression, numbers, ops);

        for (String[] priority : permutations) {
            // 파싱 결과를 복사해 사용
            List<Long> numCopy = new ArrayList<>(numbers);
            List<Character> opsCopy = new ArrayList<>(ops);

            // 우선순위에 따라 계산
            long result = Math.abs(calculate(numCopy, opsCopy, priority));
            max = Math.max(max, result);
        }

        return max;
    }

    private void parseExpression(String expression, List<Long> numbers, List<Character> ops) {
        int n = expression.length();
        int start = 0;

        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                // 숫자 추출
                numbers.add(Long.parseLong(expression.substring(start, i)));
                ops.add(c); // 연산자 저장
                start = i + 1; // 다음 숫자 시작점
            }
        }
        // 마지막 숫자 추가
        numbers.add(Long.parseLong(expression.substring(start)));
    }

    private List<String[]> generatePermutations(String[] operators) {
        List<String[]> result = new ArrayList<>();
        permute(operators, 0, result);
        return result;
    }

    private void permute(String[] operators, int depth, List<String[]> result) {
        if (depth == operators.length) {
            result.add(operators.clone());
            return;
        }

        for (int i = depth; i < operators.length; i++) {
            swap(operators, i, depth);
            permute(operators, depth + 1, result);
            swap(operators, i, depth);
        }
    }

    private void swap(String[] operators, int i, int j) {
        String temp = operators[i];
        operators[i] = operators[j];
        operators[j] = temp;
    }

    private long calculate(List<Long> numbers, List<Character> ops, String[] priority) {
        for (String op : priority) {
            char operator = op.charAt(0);
            int i = 0;

            while (i < ops.size()) {
                if (ops.get(i) == operator) {
                    // 좌우 피연산자 계산
                    long left = numbers.get(i);
                    long right = numbers.get(i + 1);
                    long result = applyOperation(left, right, operator);

                    // 리스트 갱신
                    numbers.set(i, result); // 결과 저장
                    numbers.remove(i + 1); // 우측 피연산자 제거
                    ops.remove(i); // 연산자 제거
                } else {
                    i++;
                }
            }
        }

        return numbers.get(0);
    }

    private long applyOperation(long a, long b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
        }
        return 0;
    }
}
