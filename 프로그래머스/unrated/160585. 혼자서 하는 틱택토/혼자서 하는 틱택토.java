class Solution {
    static char[][] map;
    public int solution(String[] board) {
        int answer = 1;
        int oCnt = 0;
        int xCnt = 0;
        map = new char[3][3];
        
        for(int i=0; i<board.length; i++) {
            
            for(int j=0; j<board[i].length(); j++)
            {
                if(board[i].charAt(j) == 'O')
                {
                    oCnt++;
                }
                if(board[i].charAt(j) == 'X')
                {
                    xCnt++;
                }
                map[i][j] = board[i].charAt(j);
            }
        }
        if(oCnt < xCnt || oCnt - xCnt > 1)
        {
            answer = 0;
        }
        if(win('O') > 0 && win('X') > 0)
        {
            answer = 0;
        }
        if(win('O') > 0)
        {
            if(oCnt == xCnt)
            {
                answer = 0;
            }
        }
        if(win('X') > 0)
        {
            if(oCnt > xCnt)
            {
                answer = 0;
            }
        }
        return answer;
    }
    public int win(char type)
    {
        int game = 0;
        for(int i=0; i<3; i++)
        {
            if(map[i][0]==type && map[i][0]==map[i][1] && map[i][1] == map[i][2])
            {
                game++;
            }
            if(map[0][i]==type && map[0][i]==map[1][i] && map[1][i] == map[2][i])
            {
                game++;
            }
        }
        if(map[0][0] == type && map[0][0] == map[1][1] && map[1][1] == map[2][2])
            game++;
        if(map[0][2] == type && map[0][2] == map[1][1] && map[1][1] == map[2][0])
            game++;
        
        return game;
    }
}