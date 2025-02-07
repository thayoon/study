package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2529 {
    static int k;
    static String min, max;
    static char[] sign;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        sign = br.readLine().replace(" ", "").toCharArray();
        visited = new boolean[10];

        min = "9999999999";
        max = "0000000000";

        maxNum(0);
        minNum(0);

        System.out.println(max);
        System.out.println(min);
    }

    public static void maxNum(int cnt) {
        if(cnt == k+1) {
            String num = sb.toString();
            if(max.compareTo(num) < 0) max = num;
            return;
        }

        for (int i = 9; i >= 0; i--) {
            if(!visited[i]) {
                if(cnt == 0 || isTrue(sb.charAt(cnt-1)-'0', sign[cnt-1], i)) {
                    visited[i] = true;
                    sb.append(i);
                    maxNum(cnt+1);
                    sb.deleteCharAt(sb.length()-1);
                    visited[i] = false;
                }
            }
        }
    }
    public static void minNum(int cnt) {
        if(cnt == k+1) {
            String num = sb.toString();
            if(min.compareTo(num) > 0) min = num;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(!visited[i]) {
                if(cnt == 0 || isTrue(sb.charAt(cnt-1)-'0', sign[cnt-1], i)) {
                    visited[i] = true;
                    sb.append(i);
                    minNum(cnt+1);
                    sb.deleteCharAt(sb.length()-1);
                    visited[i] = false;
                }
            }
        }
    }
    public static boolean isTrue(int prev, char op, int next) {
        return op == '<' ? prev < next : prev > next;
    }
}
