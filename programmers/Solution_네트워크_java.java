class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i, visited, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dfs(int v, boolean[] visited, int n, int[][] computers) {
        visited[v] = true;
        
        for(int i=0; i<n; i++) {
            if(computers[v][i] == 1 && !visited[i]) {
                dfs(i, visited, n, computers);
            }
        }
    }
}