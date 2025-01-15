class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int wMax = 0, hMax = 0;
        
        for(int[] size : sizes) {
            int w = size[0];    //가로
            int h = size[1];    //세로
            
            wMax = Math.max(wMax, w);
            hMax = Math.max(hMax, h);
        }
        int ww = 0, hh = 0;
        
        if(wMax < hMax) {
            for(int[] size : sizes) {
                int w = size[0];    //가로
                int h = size[1];    //세로

                if(w > h) {
                    size[0] = h;
                    size[1] = w;
                }
            }
        }
        else {
            for(int[] size : sizes) {
                int w = size[0];    //가로
                int h = size[1];    //세로

                if(w < h) {
                    size[0] = h;
                    size[1] = w;
                }
            }
        }
        for(int[] size : sizes) {
            int w = size[0];    //가로
            int h = size[1];    //세로

            ww = Math.max(ww, w);
            hh = Math.max(hh, h);
        }
        answer = ww * hh;
        return answer;
    }
}