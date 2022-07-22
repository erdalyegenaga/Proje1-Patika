import java.util.Scanner;

public class MineSweeper {
    Scanner input = new Scanner(System.in);
    int rowMax, columnMax;
    int row, column;
    int mineNumber;
    String[][] gameMap;
    String[][] mineMap;
    boolean check = true;
    int count;
    public MineSweeper(int row, int column){
        this.rowMax = row;
        this.columnMax = column;
        this.mineNumber = ((row * column) / 4);
        this.gameMap = new String[row][column];
        this.mineMap = new String[row][column];
    }
    public void setupMap(){
        for (int i=0; i<this.rowMax; i++){
            for (int j=0; j<this.columnMax; j++) {
                gameMap[i][j] = "-";
                mineMap[i][j] = "-";
                System.out.println(gameMap[i][j] + " ");
            }
            System.out.println("");
            }
        for (int i = 0; i < mineNumber; i++) {
            int a = (int) (Math.random() * this.rowMax);
            int b = (int) (Math.random() * this.columnMax);
            if (mineMap[a][b].equals("*")) {
                i--;
            }
            mineMap[a][b] = "*";
        }
    }

    public void scanMine() {
        check = false;
        System.out.println("=============");
        System.out.print("Satir Giriniz : ");
        row = input.nextInt();
        System.out.print("\bSutun Giriniz : ");
        column = input.nextInt();

        while (!check) {
            if (0 <= row && 0 <= column && row < this.rowMax && column < this.columnMax) {
                check = true;
            } else {
                System.out.println("Harita disinda bir nokta sectiniz! Tekrar Satir ve Sutun giriniz.");
                System.out.print("Satir Giriniz : ");
                row = input.nextInt();
                System.out.print("\bSutun Giriniz : ");
                column = input.nextInt();
            }
        }
    }

    public void mineCount() {
        count = 0;
        for (int i = (row - 1); i <= (row + 1); i++) {
            for (int j = (column - 1); j <= (column + 1); j++) {

                if ((i < 0 || j < 0 || i >= this.rowMax || j >= this.columnMax)) {
                    continue;
                } else {
                    if (mineMap[i][j].equals("*")) {
                        count++;
                    }
                }
            }
        }

        gameMap[row][column] = String.valueOf(count);
        mineMap[row][column] = String.valueOf(count);
        for (int i = 0; i < this.rowMax; i++) {
            for (int j = 0; j < this.columnMax; j++) {
                System.out.print(gameMap[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void writeMineMap() {
        for (int i = 0; i < this.rowMax; i++) {
            for (int j = 0; j < this.columnMax; j++) {
                System.out.print(mineMap[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public boolean finishCheck() {
        for (int i = 0; i < this.rowMax; i++) {
            for (int j = 0; j < this.columnMax; j++) {
                if (mineMap[i][j].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void run() {
        setupMap();

        while (check) {
            scanMine();
            if (mineMap[row][column].equals("*")) {
                System.out.println(" ! GAME OVER ! ");
                writeMineMap();
                check = false;
                //break;
            } else {
                mineCount();
                if (finishCheck()) {
                    System.out.println("Tebrikler kazandiniz !!! ");
                    writeMineMap();
                    check = false;
                }
            }
        }
    }
}
