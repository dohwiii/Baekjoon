class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int n = wallpaper.length; 
        int m = wallpaper[0].length();
        int lux = 51, luy  = 51, rdx = -1, rdy = -1;
        
        for(int i=0; i<wallpaper.length; i++) {
            if(wallpaper[i].contains("#")) {
                for(int j=0; j<wallpaper[i].length(); j++) {
                    if(wallpaper[i].charAt(j) == '#') {
                        lux = Math.min(lux, i); //시작 행
                        luy = Math.min(luy, j); //시작 열
                        rdx = Math.max(rdx, i); //끝 행
                        rdy = Math.max(rdy, j);   //끝 열
                    }
                }
            }
            
        }
        return new int[]{lux, luy, rdx+1, rdy+1};
    }
}