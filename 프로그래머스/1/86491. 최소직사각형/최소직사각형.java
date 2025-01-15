class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int wMax = 0, hMax = 0;
        
        for(int[] size : sizes) {
            int w = size[0];    //가로
            int h = size[1];    //세로
            
            int maxSide = Math.max(w, h);   //더 긴 쪽
            int minSide = Math.min(w, h);   //더 짧은 쪽
            
            wMax = Math.max(wMax, maxSide);
            hMax = Math.max(hMax, minSide);
        }        
        answer = wMax * hMax;
        return answer;
    }
}