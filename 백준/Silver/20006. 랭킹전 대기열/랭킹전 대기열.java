package BOJ.Section08.P20006;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int p, m;
    static ArrayList<Player> players;

    public static void main(String[] args) throws IOException {
         System.setIn(new FileInputStream("src/BOJ/Section08/P20006/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        players = new ArrayList<>();
        for(int i = 0; i < p; i++){
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nick = st.nextToken();

            players.add(new Player(level, nick));
        }
        
        ArrayList<Room> roomList = new ArrayList<>();

        for(int i = 0; i < p; i++){
            Player player = players.get(i);
            boolean isPossibleEnter = false;

            for(Room room : roomList){
                if(room.firstPlayerLevel - 10 <= player.level && player.level <= room.firstPlayerLevel + 10
                    && room.players.size() < m){

                    room.players.add(player);
                    isPossibleEnter = true;
                    break;
                }
            }

            if(!isPossibleEnter){
                Room newRoom = new Room(player.level);
                roomList.add(newRoom);
                newRoom.players.add(player);
            }
        }

        for(int i = 0; i < roomList.size(); i++){
            Room room = roomList.get(i);
            if(room.players.size() == m){
                System.out.println("Started!");
            }else{
                System.out.println("Waiting!");
            }

            room.sortPlayers();

            for(int j = 0; j < room.players.size(); j++){
                Player player = room.players.get(j);
                System.out.println(player.level + " " + player.nick);
            }
        }
    }

}

class Player implements Comparable<Player>{
    int level;
    String nick;

    public Player(int level, String nick) {
        this.level = level;
        this.nick = nick;
    }

    @Override
    public int compareTo(Player o) {
        if(nick.compareTo(o.nick) > 0){
            return 1;
        }else{
            return -1;
        }
    }
}

class Room{
    int firstPlayerLevel;
    ArrayList<Player> players = new ArrayList<>();

    public Room(int firstPlayerLevel) {
        this.firstPlayerLevel = firstPlayerLevel;
    }

    void sortPlayers(){
        Collections.sort(players);
    }
}
