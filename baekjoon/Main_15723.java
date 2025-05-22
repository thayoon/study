package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        boolean[][] res = new boolean[26][26];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int a = str.charAt(0)-'a';
            int b = str.charAt(str.length()-1)-'a';

            res[a][b] = true;
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if(i==k) continue;
                for (int j = 0; j < 26; j++) {
                    if(res[i][k] && res[k][j]) {
                        res[i][j] = true;
                    }
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            int a = str.charAt(0)-'a';
            int b = str.charAt(str.length()-1)-'a';

            if(res[a][b]) {
                sb.append("T").append("\n");
            } else {
                sb.append("F").append("\n");
            }
        }

        System.out.println(sb);
    }
}
