import java.util.Scanner;
import java.util.Random;
public class Week1Class1 {
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) || (playerMove.equals("Paper") && computerMove.equals("Rock")) || (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};
        int wins = 0;
        int losses = 0;
        int draws = 0;
        System.out.print("Enter number of rounds: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println();
        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter Rock, Paper or Scissors: ");
            String playerMove = sc.nextLine();
            playerMove = playerMove.substring(0, 1).toUpperCase() + playerMove.substring(1).toLowerCase();
            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);
            System.out.println(i + "     | " + playerMove + " | " + computerMove + " | " + result);
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }
        double winPercentage = (double) wins / n * 100;
        System.out.println("\nFinal Summary");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win %: " + winPercentage + "%");
        sc.close();
    }
}