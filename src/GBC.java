import java.io.*;
import java.util.*;

public class GBC {

    static class Section {
        int start;
        int end;
        int speed;

        public Section(int start, int end, int spd){
            this.start = start;
            this.end = end;
            this.speed = spd;
        }
        public Section(int end, int spd) {
            this.start = 0;
            this.end = end;
            this.speed = spd;
        }

        public boolean contain(Section s ){
            if ( start < s.start && s.start <= end ) return true;
            if ( start < s.end && s.end <= end ) return true;

            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        Section[] limits = new Section[N];
        Section[] tests = new Section[M];

        int maxOverSpeed = 0;

        for ( int i = 0 ; i < N ; i++ ){
            st = new StringTokenizer(br.readLine(), " ");
            int len = Integer.parseInt(st.nextToken());
            int spd = Integer.parseInt(st.nextToken());

            if ( i == 0 )
                limits[i] = new Section(len, spd);
            else
                limits[i] = new Section(limits[i - 1].end, limits[i - 1].end + len, spd);
        }
        for ( int i = 0 ; i < M ; i++ ){
            st = new StringTokenizer(br.readLine(), " ");
            int len = Integer.parseInt(st.nextToken());
            int spd = Integer.parseInt(st.nextToken());

            if ( i == 0 )
                tests[i] = new Section(len, spd);
            else
                tests[i] = new Section(tests[i - 1].end+1, tests[i - 1].end + len, spd);
        }

        for( int i = 0 ; i < M ;i++){ //모든 속도값을
            for(int j = 0 ; j < N ; j++){ //제한구간에 대해 검사
                if ( limits[j].contain(tests[i]) ){
                    int over = tests[i].speed - limits[j].speed;
                    maxOverSpeed = Math.max(maxOverSpeed, over);
                }
            }
        }
        bw.write(String.valueOf(maxOverSpeed));

        br.close();
        bw.close();
    }
}
