package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        String str = br.readLine(); // 문자열
        int q = Integer.parseInt(br.readLine()); // 질문 수

        int[][] sum = new int[26][str.length()]; // 문자열 길이마다 특정 알파벳 등장 수
        sum[str.charAt(0)-'a'][0] = 1;

        for (int i = 1; i < str.length(); i++) {
            int now = str.charAt(i)-'a';    // 현재 알파벳
            for (int j = 0; j < 26; j++) {
                sum[j][i] = sum[j][i-1]; // 이전 값 복사
            }
            sum[now][i]++; // 현재 알파벳 카운트 증가
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a'; // 특정 문자
            int l = Integer.parseInt(st.nextToken()); // 구간 l
            int r = Integer.parseInt(st.nextToken()); // 구간 r

            if (l == 0) {
                sb.append(sum[a][r]).append("\n");
            } else {
                sb.append(sum[a][r] - sum[a][l-1]).append("\n");
            }
        }

        System.out.println(sb);

    }
}
