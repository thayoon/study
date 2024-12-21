package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_22352 {
    static int N, M;
    static int[][] before, after;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        before = new int[N][M];
        after = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                before[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                after[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean vaccine = false; // 백신 투약 여부
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && before[i][j] != after[i][j]) {
                    if(vaccine) { // 이미 백신 투약한 경우
                        System.out.println("NO");
                        return;
                    }
                    vaccine = true;
                    dfs(i, j, before[i][j], after[i][j]); // 백신 업데이트
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (before[i][j] != after[i][j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");

    }

    public static void dfs(int x, int y, int origin, int anti) {
        visited[x][y] = true;
        before[x][y] = anti;

        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && before[nx][ny] == origin) {
                dfs(nx, ny, origin, anti);
            }
        }
    }
}
