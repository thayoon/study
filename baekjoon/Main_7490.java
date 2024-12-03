package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_7490 {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine()); // tc 개수

        for (int i = 0; i < tc; i++) {
            N = Integer.parseInt(br.readLine()); // 수열
            sb.setLength(0);
            dfs(1, 1, 0, 1, "1"); // 1부터
            System.out.println(sb.toString());
        }
    }

    /**
     * 0 만들기
     * @param cnt: 현재 수 (1부터 N번까지 증가)
     * @param prev: 이전 연산에 사용한 값
     * @param sum: 현재까지 총합
     * @param oper: 현재 연산자
     * @param exp: 현재까지 만든 수식
     */
    public static void dfs(int cnt, int prev, int sum, int oper, String exp) {
        if(cnt == N) {
            sum += prev*oper; // 마지막 숫자 반영
            if(sum == 0) {
                sb.append(exp).append("\n");
            }
            return;
        }

        dfs(cnt+1, prev*10+(cnt+1), sum, oper, exp+" "+(cnt+1)); // ' '
        dfs(cnt+1, cnt+1, sum+(prev*oper), 1, exp+"+"+(cnt+1)); // '+'
        dfs(cnt+1, cnt+1, sum+(prev*oper), -1, exp+"-"+(cnt+1)); // '-'
    }
}
