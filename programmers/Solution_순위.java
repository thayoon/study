class Solution {
    static int winner, loser;
    static int[][] adj;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        adj = new int[n][n];
        
        for(int[] player : results) { // 인접 행렬 초기화
            adj[player[0]-1][player[1]-1] = 1;
        }
        
        for(int i=0; i<n; i++) {
            winner = 0;
            loser = 0;
            win(i, new boolean[n]); // 이긴 사람 수 찾기
            lose(i, new boolean[n]); // 진 사람 수 찾기
            
            // 두 수의 합이 n-1이라면 순위를 알 수 있음
            if(winner + loser == n-1) answer++;
        }
        return answer;
    }
    
    public static void win(int v, boolean[] visited) {
        visited[v] = true; // 방문 처리
        for(int i=0; i<visited.length; i++) {
            if(!visited[i] && adj[v][i] == 1) { // 인접 정보라면 이긴 것
                win(i, visited);
                winner++;
            }
        }
    }
    
    public static void lose(int v, boolean[] visited) {
        visited[v] = true; // 방문 처리
        for(int i=0; i<visited.length; i++) {
            if(!visited[i] && adj[i][v] == 1) { // 인접 정보라면 진 것
                lose(i, visited);
                loser++;
            }
        }
    }
}