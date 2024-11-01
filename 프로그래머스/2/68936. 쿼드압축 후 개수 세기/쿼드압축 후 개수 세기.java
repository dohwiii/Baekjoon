import java.util.*;
class Solution {
    static int n;
    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        n = arr.length;
        boolean isPossible = true;
        //맨 처음 -> 전체 같은지 검사
        
        solve(0, 0, n, arr);
            
        return answer;
    }
    public void solve(int startX, int startY, int size, int[][] arr) {
        if(size == 1) { //더이상 쪼갤 수 없음
            if(arr[startX][startY] == 0) {
                answer[0]++;
            }
            else {
                answer[1]++;
            }
            return;
        }
        boolean isPossible = true;
        int temp = arr[startX][startY];
        
        for(int i = startX; i < startX + size; i++) {
            for(int j = startY; j < startY + size; j++) {
                if(temp != arr[i][j]) {
                    isPossible = false;
                    break;
                }
            }
            if(!isPossible) {
                break;
            }
        }
        if(isPossible) {
            if(arr[startX][startY] == 0) {
                answer[0]++;
            }
            else {
                answer[1]++;
            }
        }
        else {
            size = size / 2;
            solve(startX, startY, size, arr);
            solve(startX + size, startY, size, arr);
            solve(startX, startY + size, size, arr);
            solve(startX + size, startY + size, size, arr);
        }
        
    }
} 