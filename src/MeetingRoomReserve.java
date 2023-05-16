import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeetingRoomReserve {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int INDEX_CAL = 9;

    static class Room implements Comparable<Room> {
        String name;
        boolean[] reserve = new boolean[9];
        int availableCnt = 0;

        @Override
        public int compareTo(Room other){
            return this.name.compareTo(other.name);
        }

        public void fillReserve(int start, int end){
            for ( int i = start ; i < end ; i++)
                reserve[i] = true;
        }

        public void checkAvailable(){
            boolean before = true;
            for (boolean b : reserve) {
                if (before && !b) {
                    before = false;
                    availableCnt++;
                }
                if (!before && b) {
                    before = true;
                }
            }
        }
        public void printAvailable() throws IOException {
            boolean before = true;
            for ( int i = 0 ; i < reserve.length ; i++) {
                if (before && !reserve[i] ) {
                    before = false;
                    bw.write(String.valueOf(String.format("%02d",(i+INDEX_CAL)))+"-");
                }
                if (!before && reserve[i]) {
                    before = true;
                    bw.write(String.valueOf(String.format("%02d",(i+INDEX_CAL)))+"\n");
                }
            }
            if ( !before )
                bw.write(String.valueOf((reserve.length+INDEX_CAL))+"\n");
        }
    }

    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int roomNums = Integer.parseInt(st.nextToken());
        final int reservedRoomNums = Integer.parseInt(st.nextToken());

        Room[] rooms = new Room[roomNums];

        for (int i = 0 ; i < roomNums; i++){
            rooms[i] = new Room();
            rooms[i].name = br.readLine();
        }
        Arrays.sort(rooms);

        for ( int i = 0 ; i < reservedRoomNums ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String reservedRoom = st.nextToken();
            int startTime = Integer.parseInt(st.nextToken()) - INDEX_CAL;
            int endTime = Integer.parseInt(st.nextToken()) - INDEX_CAL;

            for ( int j = 0 ; j < roomNums ; j++){
                if ( rooms[j].name.equals(reservedRoom) ){
                    rooms[j].fillReserve(startTime, endTime);
                    break;
                }
            }
        }

        for ( int i = 0 ; i < roomNums ; i++){
            bw.write("Room "+rooms[i].name+":\n");
            rooms[i].checkAvailable();
            if ( rooms[i].availableCnt == 0 )
                bw.write("Not available\n");
            else{
                bw.write(String.valueOf(rooms[i].availableCnt+" available:\n"));
                rooms[i].printAvailable();
            }
            if ( i != roomNums -1 )
                bw.write("-----\n");
        }

        br.close();
        bw.close();
    }

}
