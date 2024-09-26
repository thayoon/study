package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_java {
    static int N, seq[], operator[], max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());    // 수 개수
        seq = new int[N];   // 수열
        operator = new int[4];  // N-1 연산자 개수 배열
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        perm(1, seq[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void perm(int depth, int num) {
        if(depth == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);

            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        perm(depth+1, num+seq[depth]);
                        break;
                    case 1:
                        perm(depth+1, num-seq[depth]);
                        break;
                    case 2:
                        perm(depth+1, num*seq[depth]);
                        break;
                    case 3:
                        perm(depth+1, num/seq[depth]);
                        break;
                }

                operator[i]++;
            }
        }
    }
}
