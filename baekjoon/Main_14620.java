package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14620 {
    static int N, min;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        dfs(0, 0);

        System.out.println(min);
    }

    public static void dfs(int cnt, int sum) {
        if(sum >= min) return;

        if(cnt == 3) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i < N-1; i++) {
            for (int j = 1; j < N-1; j++) {
                if(isSeed(i, j)) {
                    int now = getSum(i, j);
                    dfs(cnt+1, sum+now);
                    backVisited(i, j);
                }
            }
        }
    }

    public static boolean isSeed(int x, int y) {
        for (int k = 0; k < 5; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];

            if(visited[nx][ny]) {
                return false;
            }
        }

        return true;
    }

    public static int getSum(int x, int y) {
        int sum = 0;
        for (int k = 0; k < 5; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];

            visited[nx][ny] = true;
            sum += map[nx][ny];
        }

        return sum;
    }

    public static void backVisited(int x, int y) {
        for (int k = 0; k < 5; k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];

            visited[nx][ny] = false;
        }
    }
}
