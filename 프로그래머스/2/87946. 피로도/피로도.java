class Solution {
    static int maxDungeon = Integer.MIN_VALUE;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        solve(k, dungeons, 0);
        return maxDungeon;
    }
    public void solve(int fatigue, int[][] dungeons, int dungeon) {
        maxDungeon = Math.max(maxDungeon, dungeon);
        
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= fatigue) {
                visited[i] = true;
                solve(fatigue - dungeons[i][1], dungeons, dungeon + 1);
                visited[i] = false;
            }
        }
    }
}