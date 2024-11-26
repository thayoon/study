package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine()); // 참가자 수
        st = new StringTokenizer(br.readLine());
        double[] size = new double[6];
        for (int i = 0; i < 6; i++) {
            size[i] = Double.parseDouble(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        double T = Double.parseDouble(st.nextToken()); // 티셔츠 묶음 수
        int P = Integer.parseInt(st.nextToken()); // 펜 묶음 수

        int tshirt = 0;
        for (int i = 0; i < 6; i++) {
            tshirt += Math.ceil(size[i]/T);
        }

        System.out.println(tshirt);
        System.out.println(N/P+" "+N%P);
    }
}
