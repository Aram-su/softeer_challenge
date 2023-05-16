import java.io.*;
import java.util.StringTokenizer;

public class SecretMenu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int M = Integer.parseInt(st.nextToken()); // 비밀 조작 길이
        final int N = Integer.parseInt(st.nextToken()); // 사용자 조작 길이
        final int K = Integer.parseInt(st.nextToken());

        if ( M > N ){
            bw.write("normal");
            bw.close();
            br.close();
            return;
        }

        String sc = br.readLine();
        String nm = br.readLine();

        if (nm.contains(sc) ) bw.write("secret");
        else bw.write("normal");

        br.close();
        bw.close();
    }
}
