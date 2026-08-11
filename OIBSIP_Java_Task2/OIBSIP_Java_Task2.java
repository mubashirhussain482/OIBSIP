import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
import java.util.ArrayList;
public class OIBSIP_Java_Task2 {
    public static void main(String[] args) {
        Random randomGenerator=new Random();
        Scanner scanner=new Scanner(System.in);  
        ArrayList<String> roundHistory=new ArrayList<>();
        String playAgainChoice=""; 
        String gameDifficulty="";
        int remainingAttempts=0;  
        int maxAttempts=remainingAttempts;
        int attemptsUsed=0;
        int round=1;
        int targetNumber=0;
        int userGuess=0;
        boolean isValidInput=false;       
        do{
            boolean validDifficulty = false;
            while (!validDifficulty) {
                System.out.println("-----Number Guessing Game-----");
                System.out.print("Choose difficulty (easy, medium, hard): ");
                gameDifficulty = scanner.next().toLowerCase();
                switch (gameDifficulty) {
                    case "easy":
                        validDifficulty = true;
                        remainingAttempts=10;  
                        maxAttempts=remainingAttempts;
                        targetNumber=randomGenerator.nextInt(50)+1;
                        userGuess=0;
                        isValidInput=false;
                        System.out.println("Easy mode selected.");
                        System.out.println(remainingAttempts+" attempts available");
                        System.out.print("Guess the number(1-50):");
                        break;
                    case "medium":
                        validDifficulty = true;
                        remainingAttempts=7;   
                        maxAttempts=remainingAttempts;
                        targetNumber=randomGenerator.nextInt(100)+1;
                        userGuess=0;
                        isValidInput=false;
                        System.out.println("Medium mode selected.");
                        System.out.println(remainingAttempts+" attempts available");
                        System.out.print("Guess the number(1-100):");
                        break;
                   case "hard":
                        validDifficulty = true;
                        remainingAttempts=5;
                        maxAttempts=remainingAttempts;
                        targetNumber=randomGenerator.nextInt(200)+1;
                        userGuess=0;
                        isValidInput=false;
                        System.out.println("Hard mode selected.");
                        System.out.println(remainingAttempts+" attempts available");
                        System.out.print("Guess the number(1-200):");
                        break;
                    default:
                        System.out.println("Invalid difficulty. Try again.");
                }
            }           
            while(!isValidInput){
                try{                    
                    userGuess=scanner.nextInt();
                    scanner.nextLine();
                    isValidInput=true;
                }catch(InputMismatchException e){
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                }
            }
            while(targetNumber!=userGuess){                
                if(targetNumber>userGuess){
                    System.out.println("Your number is low");
                }
                else if(targetNumber<userGuess){
                    System.out.println("Your number is high");
                }
                remainingAttempts-=1;
                if(remainingAttempts==0){                
                    break;
                }           
                System.out.println(remainingAttempts+" attempts left");
                isValidInput=false;
                while(!isValidInput){
                    try{
                        System.out.print("Guess the number:");
                        userGuess=scanner.nextInt();
                        scanner.nextLine();
                        isValidInput=true;
                    }catch(InputMismatchException e){
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.nextLine();
                    }
                }
            }
            if(targetNumber==userGuess){
                attemptsUsed=maxAttempts-remainingAttempts+1;
                System.out.println("You win the game.");
                System.out.println("The number is "+targetNumber);
                roundHistory.add("Round "+round+" - Guessed in "+attemptsUsed+" attempts"+" out of "+maxAttempts);
                round++;
            }
            else if(remainingAttempts==0){
                System.out.println("You lose. Out of moves");
                System.out.println("The number was "+targetNumber);     
                roundHistory.add("Round "+round+" - Lost");
                round++;
            }
            do{
                System.out.print("Do you want to play again (yes/no):");
                playAgainChoice=scanner.next().toLowerCase();
                if(!playAgainChoice.equals("yes") && !playAgainChoice.equals("no")){
                    System.out.println("Invalid input. Please type yes or no.");
                }
            }while(!playAgainChoice.equals("yes")&&!playAgainChoice.equals("no"));          
        }while(playAgainChoice.equals("yes"));
        System.out.println("Game Ended.");
        System.out.println("\n----- Round Summary -----");
        for (String result:roundHistory){
            System.out.println(result);
        }
        scanner.close();
    }
}
