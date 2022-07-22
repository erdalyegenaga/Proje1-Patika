import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Mayin Tarlasi Oyununa Hosgeldiniz !");
        System.out.println("Harita buyuklugunu giriniz ");
        System.out.print("Row : ");
        int row = input.nextInt();
        System.out.print("Column : ");
        int column = input.nextInt();

        MineSweeper mine = new MineSweeper(row,column);
        mine.run();
    }
}
