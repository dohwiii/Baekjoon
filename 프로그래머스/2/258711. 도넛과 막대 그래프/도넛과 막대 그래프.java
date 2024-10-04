import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Integer>[] list;
    static int dognutCount = 0;
    static int stickCount = 0;
    static int eightCount = 0;
    static int maxVertex;   //정점의 개수
    static int verticesCount, edgesCount;
    static int connectionPoint = -1; // 생성된 정점으로 사용할 정점 번호
    
    public int[] solution(int[][] edges) {
        int[] answer = {};
        for(int[] edge : edges) {
            maxVertex = Math.max(maxVertex, Math.max(edge[0], edge[1]));
        }
        int[] inDegree = new int[maxVertex + 1]; // 각 정점의 진입 차수를 저장할 배열
        int[] outDegree = new int[maxVertex + 1];
        visited = new boolean[maxVertex + 1];
        list = new List[maxVertex + 1];
        for(int i=0; i <= maxVertex; i++) {
            list[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            inDegree[edge[1]]++;    //들어오는 간선
            outDegree[edge[0]]++;   //나가는 간선
        }
        
        for(int i=1; i <= maxVertex; i++) {
            if(outDegree[i] >= 2 && inDegree[i] == 0) {
                connectionPoint = i;
            }
            else if(outDegree[i] == 0 && inDegree[i] > 0) { //나가는 간선 없고, 들어오는 간선만 있음
                stickCount++;
            }
            else if(outDegree[i] >= 2 && inDegree[i] >= 2) {
                eightCount++;
            }

        }
        
        
        return new int[] {connectionPoint, list[connectionPoint].size() - stickCount - eightCount, stickCount, eightCount};
    }

}