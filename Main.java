import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        //VARIABLES
        int roll1 = 0, roll2 = 0;
        int score = 0;
        String response = "y";
        boolean gameStatus = true;

        //INTRO
        System.out.println("Welcome! Let's Play Roll Dice!");

        //GAME
        while (gameStatus && (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("yes"))) {

            //ROLL the Dice - generate two random numbers 1-6
            roll1 = 1 + rand.nextInt(6);
            roll2 = 1 + rand.nextInt(6);
            System.out.printf("%nYour rolls: %d & %d%n", roll1, roll2);


            //SCORE - exceptions if you roll one/two "1"s
            if (roll1 == 1 && roll2 == 1) {
                score += 25;
                System.out.println("Score: " + score);

            } else if (roll1 == 1 || roll2 == 1) {
                System.out.println("Sorry, you rolled a single 1 -- GAME OVER");
                //END GAME
                gameStatus = false;

            } else {
                score += (roll1 + roll2);
                System.out.println("Score: " + score);
            }


            //Scoring over 100 points
            if (score >= 100) {
                System.out.println("\nYou have scored 100\n"
                        + "Thank you for playing!");
                //END GAME
                gameStatus = false;
            }


            //Play again?
            if (gameStatus){
                System.out.print("Roll again? (Y/N): ");
                response = input.next();

            }

            //User inputs "No" or invalid response
            if(response.equalsIgnoreCase("N") || response.equalsIgnoreCase("no")) {
                System.out.println("Thank you for playing!");
            } else if(!(response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("yes"))) {
                System.out.println("Invalid input, Thanks for playing!");
            }


        }


    }
}
