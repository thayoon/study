package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1368 {
    static int N;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        int[] w = new int[N+1]; // 물을 파는 비용
        for (int i = 1; i <= N; i++) {
            w[i] = Integer.parseInt(br.readLine());
            pq.offer(new int[] {0, i, w[i]}); // 물을 직접 파는 경우
            parent[i] = i;
        }

        int[][] adj = new int[N+1][N+1]; // 논들 사이에 물을 끌어오는 비용
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
                if(j > i) pq.offer(new int[] {i, j, adj[i][j]}); // 간선 연결하는 경우
            }
        }

        int cnt = 0;
        int cost = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            if(union(now[0], now[1])) {
                cost += now[2];
                if(++cnt == N) break;
            }
        }

        System.out.println(cost);
    }
    public static int find(int A) {
        if(parent[A] == A) return parent[A];
        return parent[A] = find(parent[A]);
    }

    public static boolean union(int A, int B) {
        A = find(A);
        B = find(B);

        if(A == B) return false;
        else {
            parent[A] = B;
            return true;
        }
    }
}
