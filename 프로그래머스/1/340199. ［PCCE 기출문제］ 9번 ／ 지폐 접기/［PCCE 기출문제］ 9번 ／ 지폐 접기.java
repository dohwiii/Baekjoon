class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while(true) {
            if(check(wallet, bill)) {
                break;
            }
            if(bill[0] > bill[1]) {
                bill[0] /= 2;
                answer++;
            }
            else if(bill[0] < bill[1]) {
                bill[1] /= 2;
                answer++;
            }
        }
        
        return answer;
    }
    public boolean check(int[] wallet, int[] bill) {
        int rBill = bill[0];
        int cBill = bill[1];
        
        if(wallet[0] >= rBill && wallet[1] >= cBill) {
            return true;
        }
        if(wallet[1] >= rBill && wallet[0] >= cBill) {  //90도 회전
            return true;
        }
        return false;
    }
} 