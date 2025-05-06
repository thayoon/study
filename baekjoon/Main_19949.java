package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19949 {
    static int[] arr = new int[10];
    static int[] exam = new int[10];
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(cnt);
    }

    public static void dfs(int depth) {
        if(depth == 10) {
            int score = 0;
            for (int i = 0; i < 10; i++) {
                if(arr[i] == exam[i]) score++;

                if(score >= 5) {
                    cnt++;
                    break;
                }
            }

            return;
        }

        for (int i = 1; i <= 5; i++) {
            if(depth > 1) {
                if(exam[depth-1] == i && exam[depth-2] == i) continue;
            }
            exam[depth] = i;
            dfs(depth+1);
        }
    }
}
