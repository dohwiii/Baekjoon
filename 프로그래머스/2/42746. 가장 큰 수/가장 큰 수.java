import java.util.*;

class Solution {
    public String solution(int[] primitive) {
        String answer = "";
        boolean isZero = true;
        Integer[] numbers = new Integer[primitive.length];  // 같은 크기의 Integer 배열 생성
        for (int i = 0; i < primitive.length; i++) {
            numbers[i] = primitive[i];  // int -> Integer 자동 변환(오토박싱)
            if(primitive[i] != 0) {
                isZero = false;
            }
        }
        if(isZero) {
            return "0";
        }
        Arrays.sort(numbers, new Comparator<Integer>() {
           @Override
            public int compare(Integer x, Integer y) {
                String a = x + "";
                String b = y + "";
                String ab = a + b;
                String ba = b + a;
                
                return (b + a).compareTo(a + b);
            }
        });
        for(int i=0; i<numbers.length; i++) {
            answer += numbers[i] + "";
        }
        return answer;
    }
}