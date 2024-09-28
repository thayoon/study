package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759 {
    static int L, C;
    static char[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ch = br.readLine().replace(" ", "").toCharArray();
        Arrays.sort(ch);    // 사전 순 정렬
        combi(0, 0, "");
    }

    /**
     * 조합으로 L 자리의 암호 만드는 함수
     * @param cnt: 현재 인덱스
     * @param start: 선택 시작 인덱스
     * @param cur: 현재 암호 문자열
     */
    private static void combi(int cnt, int start, String cur) {
        // bc
        if(cnt == L) {
            if(isCode(cur)) {
                System.out.println(cur);
            }
            return;
        }
        for (int i = start; i < C; i++) {
                combi(cnt + 1, i+1,cur + ch[i]);
        }
    }

    /**
     * 암호가 최소 한 개의 모음과 최소 두 개의 자음으로 구성되어 있는지 판별하는 함수
     * @param cur: 암호
     * @return 가능성 있는 암호인 경우 true, 없는 경우 false
     */
    private static boolean isCode(String cur) {
        int v = 0;  // 모음 개수
        int c = 0;  // 자음 개수
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) == 'a' || cur.charAt(i) == 'e' || cur.charAt(i) == 'i' || cur.charAt(i) == 'o' || cur.charAt(i) == 'u') {
                v++;
            } else {
                c++;
            }
        }
        return v>=1 && c>=2;
    }
}
