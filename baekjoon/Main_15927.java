package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();
        int mid = len/2;
        boolean same = true; // 같은 문자열 여부

        for (int i = 0; i < mid; i++) {
            if(str.charAt(i) != str.charAt(len-1-i)) {
                // 팰린드롬이 아닌 경우
                System.out.println(len);
                return;
            }
            if(str.charAt(i) != str.charAt(i+1)) {
                same = false;
            }
        }

        if(same) System.out.println(-1); // 팰린드롬 && 같은 문자열
        else System.out.println(len-1); // 팰린드롬
    }
}
