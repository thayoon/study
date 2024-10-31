import java.io.*;
import java.util.*;

public class Main {
    static int n, m, S, T;
    static List<Integer>[] adj, adjR;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 정점
        m = Integer.parseInt(st.nextToken()); // 간선
        
        adj = new ArrayList[n]; // 정방향 간선
        adjR = new ArrayList[n]; // 역방향 간선
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
            adjR[i] = new ArrayList<>();
        }
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            adj[x].add(y);
            adjR[y].add(x);
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken())-1; // 출발 정점
        T = Integer.parseInt(st.nextToken())-1; // 도착 정점

        // S -> T : T는 한 번만 방문
        boolean[] fromS = new boolean[n];
        fromS[T] = true;
        dfs(S, adj, fromS);

        // T -> S : S는 한 번만 방문
        boolean[] fromT = new boolean[n];
        fromT[S] = true;
        dfs(T, adj, fromT);

        // T -> S
        boolean[] toS = new boolean[n];
        dfs(S, adjR, toS);

        // S -> T
        boolean[] toT = new boolean[n];
        dfs(T, adjR, toT);

        int result = 0;
        for(int i=0; i<n; i++) {
            if(fromS[i] && fromT[i] && toS[i] && toT[i]) result++;
        }
        
        System.out.println(result-2);
    }

    public static void dfs(int v, List<Integer>[] graph, boolean[] visited) {
        if(visited[v]) return;
        visited[v] = true;
        for(int i:graph[v]) {
            dfs(i, graph, visited);
        }
    }
}
