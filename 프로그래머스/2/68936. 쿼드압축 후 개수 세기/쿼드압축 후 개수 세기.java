import java.util.*;
class Solution {
    static int n;
    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        n = arr.length;
        boolean isPossible = true;
        //맨 처음 -> 전체 같은지 검사
        int temp = arr[0][0];
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
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
            if(temp == 0) {
                answer[0]++;
            }
            else {
                answer[1]++;
            }
        }
        else {
            solve(0, 0, n/2, arr);
            solve(0, n/2, n/2, arr);
            solve(n/2, 0, n/2, arr);
            solve(n/2, n/2, n/2, arr);
        }
            
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
            return;
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