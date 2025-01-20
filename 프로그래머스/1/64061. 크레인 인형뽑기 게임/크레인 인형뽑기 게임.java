import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        Stack<Integer> bucket = new Stack<>();  //뽑은 인형 담을 바구니
        

        for(int m : moves) {
            int now = m - 1;    //움직일 열
            for(int i=0; i<N; i++) {   //행
                if(board[i][now] != 0) { //뽑기
                    bucket.add(board[i][now]);  //바구니에 담기
                    board[i][now] = 0;
                    break;
                }
            }
            
            if(bucket.size() >= 2) {
                int second = bucket.pop();
                int first = bucket.pop();
                if(first != second) {
                    bucket.add(first);
                    bucket.add(second);
                }
                else {  //터트려 없앰
                    answer += 2;
                }
            }
            
            
            
        }
        
        
        return answer;
    }
    
}