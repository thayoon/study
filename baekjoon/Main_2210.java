package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2210 {
    static String[][] map;
    static Set<String> ans = new HashSet<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        map = new String[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = st.nextToken();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(1, i, j, map[i][j]);
            }
        }

        System.out.println(ans.size());
    }

    public static void dfs(int cnt, int x, int y, String num) {
        if(cnt == 6) {
            ans.add(num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<5 && ny>=0 && ny<5) {
                dfs(cnt+1, nx, ny, num+map[nx][ny]);
            }
        }
    }
}