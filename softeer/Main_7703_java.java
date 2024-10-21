import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            String T = st.nextToken();

            int index = S.indexOf("x");
            if(index == -1) index = S.indexOf("X");
            sb.append(T.charAt(index));
        }

        System.out.println(sb.toString().toUpperCase());
    }
}
