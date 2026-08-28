package string.class_problems;

import java.util.Random;

public class RockPaperScissorsGame {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        switch (playerMove.toLowerCase()) {
            case "rock":
                return computerMove.equalsIgnoreCase("scissors") ? "Player Wins" : "Computer Wins";
            case "paper":
                return computerMove.equalsIgnoreCase("rock") ? "Player Wins" : "Computer Wins";
            case "scissors":
                return computerMove.equalsIgnoreCase("paper") ? "Player Wins" : "Computer Wins";
            default:
                throw new IllegalArgumentException("Invalid move: " + playerMove);
        }
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        Random random = new Random();

        int wins = 0, losses = 0, draws = 0;
        int rounds = playerMoves.length;

        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("--------------------------------------------");

        for (int i = 0; i < rounds; i++) {
            String computerMove = moves[random.nextInt(moves.length)];
            String result = playRound(playerMoves[i], computerMove);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.printf("%5d | %-11s | %-13s | %s%n",
                    (i + 1), playerMoves[i], computerMove, result);
        }

        double winPercentage = (wins * 100.0) / rounds;
        System.out.println("--------------------------------------------");
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
    }
}
