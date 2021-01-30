package src.main;

public class Main {

    public static void main(String[] args) {

        System.out.println(" ----- MAIN MENU ----- \n");
        System.out.println("1. Cast Votes");
        System.out.println("2. View Votes on Blockchain");
        System.out.println("3. Count Votes");
        System.out.println("0. Exit\n");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your choice: ");
        int ch = scanner.nextInt();

    }
