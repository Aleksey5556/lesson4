package lesson4;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.XMLFormatter;

public class thegamecrosses {
    private static Scanner scanner;
    public static Random random = new Random();
    private static char[][] map;
    private static final int MAP_ELEMENT = 3;
    private static final int SIZE = 3;


    private static final char DOT_EMPTY = '•';
    private static final char MAP_ELEMENT_X = 'X';
    private static final char MAP_ELEMENT_O = 'O';

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        initMap();
        printMap();
        while (true) {
            ptayerTurn();
            printMap();
            if (checkingthecard()) {
                System.out.println("Игра окончина не чья");
                break;
            }


            aiTurn();
            printMap();
            if (checkingthecard()) {
                System.out.println("Игра окончина не чья");
                break;
            }


        }
        map = new char[][]{
                {'*','*','*'},
                {'*','*','*'},
                {'*','*','*'},
        };
        for (int i = 0; i < SIZE; i++ ){
            for (int j = 0; j < SIZE; j++ ){
                if (cnekWin(i , j ,0,1, 'X')){
                    System.out.println("WIN");
                    return;
                }
                if (cnekWin(i, j , 1, 1,'X')){
                    System.out.println("WIN");
                    return;
                }
                if (cnekWin(i, j, 1, 1 , 'X')) {
                    System.out.println("WIN");
                    return;
                }
            }
        }
    }

    public static boolean cnekWin(int startX, int startY, int vX, int vY, char dot) {
        if (startX + (MAP_ELEMENT - 1) + vX < 0 || startY + (MAP_ELEMENT - 1) * vY < 0
                || startX + (MAP_ELEMENT - 1) * vX > SIZE || startY + (MAP_ELEMENT - 1) * vY > SIZE) {
            return false;
        }
        for (int i = 0; i < MAP_ELEMENT; i++) {
            if (map[startX + i * vX][startY + i * vY] != dot) {
                return false;
            }
        }
        return true;
    }



    public static boolean checkingthecard(){
     for (int i = 0; i < SIZE; i++){
         for (int j = 0; i < SIZE; i++){
             if (map[i][j] == DOT_EMPTY ){
                 return false;
             }
         }
     }
     return true;
    }
    public static void aiTurn(){
        int X, Y;
        do {

            X = random.nextInt(SIZE);
            Y = random.nextInt(SIZE);
        }while (!checkingmoves (X ,Y));
        map[X][Y] = MAP_ELEMENT_O;//ход робот
        System.out.println(" 2 игрок походил [" + (X + 1)+ "," + (Y + 1) + "]");
    }

    public static void ptayerTurn(){
       int X, Y;
     do {
    System.out.println("Ведите кординату ('X Y')");
       X = scanner.nextInt()-1;
       Y = scanner.nextInt()-1;
       }while (!checkingmoves (X ,Y));
           map[X][Y] = MAP_ELEMENT_X;//ход человека
    }
    public static  boolean checkingmoves (int x,int y){
        if(x < 0 || y < 0 || x >= SIZE || y >= SIZE){
            return false;
        }
        if (map [x] [y] != DOT_EMPTY) {
            return false;
        }
        return true;
    }

    public static void printMap() {

        for (int i = 0; i <= SIZE; i++){
            System.out.print(i + " ");
        }
         System.out.println();
       for (int i = 0; i < SIZE; i++){
           System.out.print((i + 1) + " ");
           for (int j = 0; j < SIZE; j++) {
               System.out.print(map[j][i] + " ");
           }
           System.out.println();
       }
       System.out.println();
    }
    public static void initMap() {
        map = new char [SIZE] [SIZE];
        for(int i = 0; i < SIZE ; i++ ) {
            for (int j = 0; j < SIZE; j++) {
                map[i] [j] = DOT_EMPTY;
            }
        }

    }

}
