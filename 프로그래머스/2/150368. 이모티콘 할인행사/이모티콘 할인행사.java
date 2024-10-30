import java.util.*;

class Solution {
    static int[] discount = {10, 20, 30, 40};
    static boolean[] visited;
    static List<Sale> list;
    static List<Join> resultList = new ArrayList<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        visited = new boolean[4];
        list = new ArrayList<>(emoticons.length);
        int[] selectedDiscount = new int[emoticons.length]; //이모티콘마다 할인율 담는 배열
        
        permutation(0, emoticons, users, selectedDiscount);
        
        Collections.sort(resultList);
        Join j = resultList.get(0);
        answer[0] = j.member;
        answer[1] = j.sales;
        return answer;
    }
    public void permutation(int depth, int[] emoticons, int[][] users, int[] selectedDiscount) {
        if(depth == emoticons.length) {
            int join = 0;
            int money = 0;
            
            for(int[] user : users) {   //유저마다
                int purchase = 0;
                for(int i=0; i<selectedDiscount.length; i++) {
                    int percent = selectedDiscount[i];
                    if(percent >= user[0]) {  //할인율 이상 구매
                        int discount = (int) (emoticons[i] * (100 - percent) / 100.0);
                        purchase += discount;
                    }
                }
                //모든 구매 끝
                if(purchase >= user[1]) {   //이모티콘 플러스 가입자
                    join++;
                }
                else {
                    money += purchase;
                }
            }
            resultList.add(new Join(join, money));  //가입자, 매출액
                
            return;
        }
        for(int i=0; i<4; i++) {
            selectedDiscount[depth] = discount[i];
            permutation(depth + 1, emoticons, users, selectedDiscount);
        }
    }
    
    static class Sale {
        int item, percent;
        public Sale(int item, int percent) {
            this.item=item;
            this.percent=percent;
        }
    }
    static class Join implements Comparable<Join> {
        int member, sales;
        public Join(int member, int sales) {
            this.member=member;
            this.sales=sales;
        }
        @Override
        public int compareTo(Join j) {
            if(j.member == this.member) {
                return j.sales - this.sales;
            }
            return j.member - this.member;
        }
    }
}