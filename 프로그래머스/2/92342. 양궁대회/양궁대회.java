import java.util.*;;

class Solution {
    static int bestDiff = 0;
    static int[] best = new int[11];
    static List<int[]> list = new ArrayList<>();
    
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        
        game(0, new int[11], n, n, info);
        int minIndex = 0;
        boolean isAllZero = true;
        
        for(int i=0; i<11; i++) {
            if(best[i] != 0) {
                isAllZero = false;
                break;
            }
        }
        
        if(isAllZero) {
            return new int[]{-1};
        }

        return best;
        
        
    }
    private static void game(int index, int[] ryan, int leftArrow, int n, int[] info) {
        if(index == 11) {   // 종료조건
            ryan[10] += leftArrow;
            calc(ryan, info);
            ryan[10] -= leftArrow;
            return;
        }
        
        // 어피치보다 화살 개수 + 1 쏘기
        if(leftArrow > info[index]) {
            int left = leftArrow - info[index] - 1;
            ryan[index] = info[index] + 1;  // 어피치가 쏜 화살보다 1개 더 쏘기
            game(index + 1, ryan, left, n, info);
        }
        
        //  안쏘기
        ryan[index] = 0;
        game(index + 1, ryan, leftArrow, n, info);
    }
    private static void calc(int[] ryan, int[] apeach) {
        int rTotal = 0;
        int aTotal = 0;
        
        for(int i=0; i<11; i++) {
            int r = ryan[i];
            int a = apeach[i];
            if(r == 0 && a == 0) {
                continue;
            }
            
            if(r > a) {
                rTotal += (10 - i);    // 라이언 승
            }
            else {
                aTotal += (10 - i);     // 어피치 승
            }
        }
        if(rTotal <= aTotal) {
            return;
        }
        if(rTotal == 0) {
            return;
        }
        int diff = rTotal - aTotal;
        
        if(diff > bestDiff) {
            best = ryan.clone();
            bestDiff = diff;
        }
        else if(diff == bestDiff) {
            for(int i=10; i>=0; i--) {
                if(best[i] < ryan[i]) {
                    best = ryan.clone();
                    break;
                }
                else if(best[i] > ryan[i]) {
                    break;
                }
            }
            
        }
    }

}