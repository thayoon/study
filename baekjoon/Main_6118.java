package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_6118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A_i = Integer.parseInt(st.nextToken());
            int B_i = Integer.parseInt(st.nextToken());
            adj[A_i].add(B_i);
            adj[B_i].add(A_i);
        }
        q.offer(new int[]{1, 0});
        int[] dist = new int[N+1];
        dist[1] = 1; // dist 배열값이 0인 경우 미방문
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int cur = now[0];
            int d = now[1];

            for(int next : adj[cur]) {
                if(dist[next] == 0) {
                    // 방문 전이라면
                    dist[next] = d+1;
                    q.offer(new int[] {next, dist[next]});
                }
            }
        }

        dist[1] = 0; // 방문 처리 끝 -> 다시 거리 0으로
        int idx = 0; // 헛간 번호
        int max = 0; // 최대 거리
        int cnt = 0; // 헛간 개수
        for (int i = 1; i < N+1; i++) {
            if(dist[i]>max) {
                max = dist[i];
                idx = i;
                cnt = 1;
            }else if(max == dist[i]) {
                cnt++;
            }
        }
        System.out.println(idx + " " + max + " " + cnt);
    }
}
