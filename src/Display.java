import java.io.*;
import java.util.StringTokenizer;

public class Display {

    final static boolean ON = true;
    final static boolean OFF = false;

    static class Num{
        boolean[] lights;

        public Num(boolean[] arr){
            this.lights = arr;
        }

        public int compareLight(Num num){
            int cnt = 0;
            for ( int i = 0 ; i < lights.length ; i++){
                if ( this.lights[i] != num.lights[i] ) cnt++;
            }
            return cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int CASE_SIZE = Integer.parseInt(br.readLine());

        Num[] numbers = new Num[10];
        numbers[0] = new Num(new boolean[]{ON,ON,ON,OFF,ON,ON,ON});
        numbers[1] = new Num(new boolean[]{OFF,OFF,ON,OFF,OFF,ON,OFF});
        numbers[2] = new Num(new boolean[]{ON,OFF,ON,ON,ON,OFF,ON});
        numbers[3] = new Num(new boolean[]{ON,OFF,ON,ON,OFF,ON,ON});
        numbers[4] = new Num(new boolean[]{OFF,ON,ON,ON,OFF,ON,OFF});
        numbers[5] = new Num(new boolean[]{ON,ON,OFF,ON,OFF,ON,ON});
        numbers[6] = new Num(new boolean[]{ON,ON,OFF,ON,ON,ON,ON});
        numbers[7] = new Num(new boolean[]{ON,ON,ON,OFF,OFF,ON,OFF});
        numbers[8] = new Num(new boolean[]{ON,ON,ON,ON,ON,ON,ON});
        numbers[9] = new Num(new boolean[]{ON,ON,ON,ON,OFF,ON,ON});

        for ( int i = 0 ; i < CASE_SIZE ; i++){
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String num1 = st.nextToken();
            String num2 = st.nextToken();

            while ( num1.length() < 5 ) num1 = "a"+num1;
            while ( num2.length() < 5 ) num2 = "a"+num2;

            for ( int j = 0 ; j < 5 ;j++){
                String tmp1 = num1.substring(j,j+1);
                String tmp2 = num2.substring(j,j+1);

                if ( !tmp1.equals("a") && !tmp2.equals("a") ){
                    int a = Integer.parseInt(tmp1);
                    int b = Integer.parseInt(tmp2);
                    if ( a == b ) continue;
                    cnt += numbers[a].compareLight(numbers[b]);
                } else if ( !tmp1.equals("a") ){
                    int a = Integer.parseInt(tmp1);
                    cnt += numbers[a].compareLight(new Num(new boolean[]{OFF,OFF,OFF,OFF,OFF,OFF,OFF}));
                } else if ( !tmp2.equals("a") ){
                    int b = Integer.parseInt(tmp2);
                    cnt += numbers[b].compareLight(new Num(new boolean[]{OFF,OFF,OFF,OFF,OFF,OFF,OFF}));
                }
            }
            System.out.println(cnt);
        }
    }
}
