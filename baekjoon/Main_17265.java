package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17265 {
    static int N, min, max;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().replace(" ", "").toCharArray();
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        visited[0][0] = true;
        // ' ' -> 숫자인 경우로 다음은 연산자가 나와야함
        dfs(0, 0, map[0][0] - '0', ' ');

        System.out.println(max+" "+min);
    }

    public static void dfs(int x, int y, int num, char oper) {
        if(x == N-1 && y == N-1) {
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
                if(oper == ' ' && (map[nx][ny] - '0' < 0 || map[nx][ny] - '0' > 5)) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, num, map[nx][ny]);
                    visited[nx][ny] = false;
                } else {
                    visited[nx][ny] = true;
                    int now = map[nx][ny] - '0';
                    if(oper == '+') {
                        dfs(nx, ny, num+now, ' ');
                    } else if (oper == '-') {
                        dfs(nx, ny, num-now, ' ');
                    } else {
                        dfs(nx, ny, num*now, ' ');
                    }
                    visited[nx][ny] = false;
                }
            }
        }
    }
}
