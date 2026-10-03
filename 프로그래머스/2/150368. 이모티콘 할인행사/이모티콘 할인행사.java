import java.util.*;

// 이모티콘 할인율 설정
// 유저의 지출액 계산
// 이모티콘 플러스 가입 수 계산
// 1. 가입자 수 -> 2. 판매액
class Solution {
    static int[] discounts = {10, 20, 30, 40};
    static int[] maxAnswer;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        maxAnswer = new int[2];
        int[] money = new int[users.length];
        
        combi( 0, new int[emoticons.length], users, emoticons);

        
        
        // 이모티콘 플러스 가입 수 & 이모티콘 매출액
        return maxAnswer;
    }
    private static void calc(int[] emoticonDiscounts, int[][] users, int[] emoticons) {
        int[] sumMoney = new int[users.length];
        int[] discountMoney = new int[emoticons.length];    // 이모티콘별 할인 금액
        int signup = 0;
        int total = 0;
        
        for(int i=0; i<emoticons.length; i++) {
            int sale = (int) ((double) emoticons[i] * (100 - emoticonDiscounts[i]) * 0.01);
            discountMoney[i] = sale;
        }
        
        for(int i=0; i<users.length; i++) {
            int sellDiscount = users[i][0];
            
            for(int j=0; j<emoticons.length; j++) {
                if(sellDiscount <= emoticonDiscounts[j]) { // 산다
                    sumMoney[i] += discountMoney[j];
                }
                if(sumMoney[i] >= users[i][1]) {    // 이모티콘 플러스 가입 조건 금액
                    signup++;   // 가입 완료
                    sumMoney[i] = 0;
                    break;
                }
            }
            total += sumMoney[i];      
        }
        if(signup > maxAnswer[0]) {
            maxAnswer[0] = signup;
            maxAnswer[1] = total;
        }
        else if(maxAnswer[0] == signup) {   // 가입자 수 같다면 -> 최대 매출액 비교
            maxAnswer[1] = Math.max(maxAnswer[1], total);
            return;
        }
        
        
    }
    private static void combi(int depth, int[] arr, int[][] users, int[] emoticons) {
        if(depth == arr.length) {   // 이모티콘 할인율 다 뽑았다면
            calc(arr, users, emoticons);
            return;
        }
        
        for(int i=0; i<4; i++) {
            arr[depth] = discounts[i];
            combi(depth+1, arr, users, emoticons);
        }
    } 
}