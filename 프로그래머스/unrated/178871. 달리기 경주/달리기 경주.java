import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int pN = players.length;
        int cN = callings.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<pN;i++)
        {
            map.put(players[i], i);
        }
        
        for(String nowPlayer : callings)
        {
            int playerIndex = map.get(nowPlayer); //3
            String beforePlayer = players[playerIndex - 1];
            
            players[playerIndex] = beforePlayer;
            players[playerIndex - 1] = nowPlayer;
            
            map.put(beforePlayer, playerIndex);
            map.put(nowPlayer, playerIndex - 1);
        }
        
        return players;
    }
}