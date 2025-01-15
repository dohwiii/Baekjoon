class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        int cnt = 1;
        long needMoney = 0;
        
        while(cnt <= count) {
            needMoney += price * cnt;
            cnt++;
        }
        
        return Math.max(needMoney - money, 0);
    }
}