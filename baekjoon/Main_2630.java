package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630 {
    static int w, b;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        div(0, 0, N);

        System.out.println(w);
        System.out.println(b);
    }

    public static void div( int r, int c, int size) {
        if(cut(r, c, size)) {
            if(paper[r][c] == 0) w++;
            else b++;
            return;
        }
        int nsize = size/2;
        div(r, c, nsize);
        div(r, c+nsize, nsize);
        div(r+nsize, c, nsize);
        div(r+nsize, c+nsize, nsize);
    }

    public static boolean cut(int r, int c, int size) {
        int color = paper[r][c];

        for (int i = r; i < r+size; i++) {
            for (int j = c; j < c+size; j++) {
                if(paper[i][j] != color) return false;
            }
        }

        return true;
    }
}
