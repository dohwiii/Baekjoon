class Solution {
    static int[][] map;
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};
    static boolean[][] visited;
    static int answer;
    static int[] arr;
    
    public int solution(int n) {
        map = new int[n][n];
        arr = new int[n];
        visited = new boolean[n][n];
        solve(0, n);
        return answer;
    }
    public void solve(int depth, int n) {
        if(depth == n) {
			answer++;
			return;
		}
		
		for(int i = 0 ; i < n; i++) {
			arr[depth] = i;
			if(isPossible(depth)) {
				solve(depth+1, n);
			}
		}

        
    }
    public boolean isPossible(int col) {
       for(int i = 0 ; i < col ; i++) {
		//행에 일치하는게 있는지 판별
		if(arr[i]==arr[col]) {
			return false;
		}
		//대각선에 일치하는게 있는지 판별
		else if(Math.abs(col-i) == Math.abs(arr[col]-arr[i])) {
			return false;
		}
			
		}
		
		return true;
    }
}