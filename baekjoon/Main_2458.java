package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 비교한 횟수
        boolean[][] adj = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // a < b
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            adj[a][b] = true;
        }

        for (int k = 0; k < N; k++) { // 경유지
            for (int i = 0; i < N; i++) { // 출발지
                if(i==k) continue;
                for (int j = 0; j < N; j++) { // 도착지
                    if(j==k || j==i || adj[i][j]) continue;
                    if(adj[i][k] && adj[k][j]) { // 경유지와 연결되어 있다면 i->j 경로 존재
                        adj[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                // 정방향 역방향 모두 연결되어 있는지 확인
                if(adj[i][j] || adj[j][i]) cnt++;
            }
            // 연결된 수가 자신 제외한 값이라면 순서를 알 수 있는 학생
            if(cnt == N-1) answer++;
        }

        System.out.println(answer);
    }
}
