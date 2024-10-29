class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            answer[i] = findClosest(numbers[i]);
        }
   
        return answer;
    }
    private long findClosest(long num) {
        if(num % 2 == 0) {  //짝수라면
            return num + 1;
        }
        else {  //홀수
            long lowestZero = (~num) & (num + 1);   //가장 오른쪽 0이 있는 자리를 1로 변환
            return (num | lowestZero) & ~(lowestZero >> 1);
        }
    }
}