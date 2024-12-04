package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_5241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 역 개수
        int K = Integer.parseInt(st.nextToken()); // 하이퍼튜브 역 연결 개수
        int M = Integer.parseInt(st.nextToken()); // 하이퍼튜브 개수

        List<Integer>[] adj = new ArrayList[N+M+1];
        for (int i = 0; i <= N+M; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int tube = N+1+i; // 하이퍼튜브 번호
            for (int j = 0; j < K; j++) {
                // 하이퍼튜브 연결 역 번호
                int station = Integer.parseInt(st.nextToken());
                adj[station].add(tube); // 현재 역에 하이퍼튜브 번호 연결
                adj[tube].add(station); // 현재 하이퍼튜브에 역 연결
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+M+1]; // 방문 처리
        q.offer(new int[] {1, 1}); // 현재 역, 방문 역 수
        visited[1] = true;
        int min = Integer.MAX_VALUE;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int cur = now[0]; // 현재 역
            int visit = now[1]; // 현재 역 방문 횟수

            if(visit > min) continue; // 최솟값보다 크다면 다음
            if(cur == N) { // 역에 도착했다면 최솟값 갱신
                min = visit;
                continue;
            }

            for (int next : adj[cur]) {
                if(!visited[next]) {
                    visited[next] = true;
                    if(cur > N) { // 하이퍼튜브(환승) visit+1
                        q.offer(new int[] {next, visit+1});
                    }else {
                        q.offer(new int[] {next, visit});
                    }
                }
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
