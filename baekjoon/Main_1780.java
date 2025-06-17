package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780 {
    static int m, z, p;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        m = 0;
        z = 0;
        p = 0;
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        div(0, 0, N);

        System.out.println(m);
        System.out.println(z);
        System.out.println(p);
    }

    public static void div(int x, int y, int size) {
        if(cut(x, y, size)) {
            if(paper[x][y] == -1) m++;
            else if(paper[x][y] == 0) z++;
            else p++;
            return;
        }
        int nsize = size/3;
        div(x, y, nsize);
        div(x, y+nsize, nsize);
        div(x, y+2*nsize, nsize);

        div(x+nsize, y, nsize);
        div(x+nsize, y+nsize, nsize);
        div(x+nsize, y+2*nsize, nsize);

        div(x+2*nsize, y, nsize);
        div(x+2*nsize, y+nsize, nsize);
        div(x+2*nsize, y+2*nsize, nsize);
    }

    public static boolean cut(int x, int y, int size) {
        int num = paper[x][y];

        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if(paper[i][j] != num) return false;
            }
        }

        return true;
    }
}
