import java.util.Scanner;
import java.util.Random;

class Game{
    int systemInput;
    int userInput;
    int noOfGuesses = 0;

    Game(){
        Random random=new Random();
        this.systemInput=random.nextInt(100)+1;

    }
    public boolean takenUserInput(){
        if(noOfGuesses<10){
            System.out.print("Guess the number : ");
            this.userInput=NumberGuessingGame.takeIntegerInput(100);
            noOfGuesses++;
            return false;
        }
        else{
            System.out.println("No attempts left.\n");
            System.out.println("Better luck next time\n");
            return true;
        }
    }

    public boolean isCorrectGuess(){
        if(systemInput==userInput){
            System.out.println("Congratulations,you got the number "+systemInput+" in "+noOfGuesses+" guesses.");
            switch (noOfGuesses) {
                case 1 -> System.out.println("Your score is 100. ");
                case 2 -> System.out.println("Your score is 90. ");
                case 3 -> System.out.println("Your score is 80. ");
                case 4 -> System.out.println("Your score is 70. ");
                case 5 -> System.out.println("Your score is 60. ");
                case 6 -> System.out.println("Your score is 50. ");
                case 7 -> System.out.println("Your score is 40. ");
                case 8 -> System.out.println("Your score is 30. ");
                case 9 -> System.out.println("Your score is 20. ");
                case 10 -> System.out.println("Your score is 10. ");
            }
            System.out.println();
            return true;

        }
        else if(noOfGuesses<10 && userInput>systemInput) {
            if(userInput-systemInput>10){
                System.out.println("Too High");
            }
            else{
                System.out.println("little bit High");
            }
        }

        else if(noOfGuesses<10){
            if(systemInput-userInput>10){
                System.out.println("Too Low");
            }
            else{
                System.out.println("little bit Low");

            }
        }
        return false;
    }
}

public class NumberGuessingGame {
    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if (input > limit || input < 1) {
                    System.out.println("Choose the number between 1 to " + limit+ " .");
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value. ");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("1.Start the game \n2.Exit ");
        System.out.println("Enter your choice : ");
        int choice = takeIntegerInput(2);
        int nextRound;
        int noOfRound = 0;

        if (choice == 1) while (true) {
            Game game = new Game();
            boolean isMatched = false;
            boolean isLimitCross = false;
            System.out.println("\n Round " + ++noOfRound + " starts...!");
            while (!isMatched && !isLimitCross) {
                isLimitCross = game.takenUserInput();
                isMatched = game.isCorrectGuess();
            }
            System.out.println("1.Next Round \n2. Exit");
            System.out.println("Enter your choice: ");
            nextRound = takeIntegerInput(2);
            if (nextRound != 1) {
                System.exit(0);
            }

        }
        else {
            System.exit(0);
        }
    }
}