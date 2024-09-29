import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(int[] queue1, int[] queue2) {
        // 두 큐의 총 합을 구함
        long sum1 = 0, sum2 = 0;
        for (int num : queue1) sum1 += num;
        for (int num : queue2) sum2 += num;
        
        // 두 큐의 합의 총합이 홀수면 절대 맞출 수 없음
        if ((sum1 + sum2) % 2 != 0) return -1;
        
        long target = (sum1 + sum2) / 2;  // 각 큐가 같아야 하는 목표 합
        int n = queue1.length;
        
        // 두 큐를 하나로 연결한 배열로 취급
        int[] combined = new int[n * 2];
        System.arraycopy(queue1, 0, combined, 0, n);
        System.arraycopy(queue2, 0, combined, n, n);
        
        int left = 0, right = n;  // 투 포인터: left는 queue1의 시작, right는 queue2의 시작
        long currentSum = sum1;   // 초기에는 queue1의 합
        
        int moves = 0;  // 작업 횟수

        while (left < n * 2 && right < n * 2) {
            // 현재 큐의 합이 목표와 같으면 작업 횟수를 반환
            if (currentSum == target) return moves;

            // 현재 합이 목표보다 크면 왼쪽에서 pop
            if (currentSum > target) {
                currentSum -= combined[left++];
            } 
            // 현재 합이 목표보다 작으면 오른쪽에서 pop하고 왼쪽에 insert
            else {
                currentSum += combined[right++];
            }
            
            moves++;
        }
        
        // 조건을 만족하지 못하면 -1 반환
        return -1;
    }
}