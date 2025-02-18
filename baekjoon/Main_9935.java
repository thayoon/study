package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();
        String boom = br.readLine();
        int size = boom.length();
        StringBuilder ans = new StringBuilder();

        for (char ch : str) {
            ans.append(ch);

            if(ans.length() >= size) {
                if(ans.substring(ans.length()-size).equals(boom)) {
                    ans.delete(ans.length()-size, ans.length());
                }
            }
        }

        System.out.println(ans.length() == 0 ? "FRULA" : ans.toString());
    }
}
