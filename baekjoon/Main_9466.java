package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9466 {
    static int n, cnt;
    static int[] arr;
    static boolean[] visited, team;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1]; // 방문 여부
            team = new boolean[n+1]; // 현재 dfs 경로 여부
            cnt = 0; // 싸이클에 포함된 팀원 수

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if(!visited[i]) dfs(i);
            }

            sb.append(n-cnt).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int cur) {
        if(visited[cur]) return; // 이미 방문한 팀원이라면 종료
        visited[cur] = true; // 방문 처리

        if(!visited[arr[cur]]) { // 다음 팀원이 방문되지 않았다면 dfs 탐색
            dfs(arr[cur]);
        } else if(!team[arr[cur]]) {
            // 다음 팀원이 현재 dfs 경로에서 처음 방문된 경우
            for (int i = arr[cur]; i != cur; i = arr[i]) {
                cnt++; // 싸이클 형성
            }
            cnt++; // 마지막 팀원
        }

        team[cur] = true; // 싸이클 여부 확정 후 dfs 경로에서 제거
    }
}
