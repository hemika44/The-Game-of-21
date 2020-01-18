/*
 * The Game of 21
 * November, 2019
 */

/**
 * @author Hemika Roy
 */
import java.util.Scanner;
import java.util.Random;
public class TheGameof21 {
    public static void main (String[]args) throws InterruptedException {
        System.out.println ("Welcome to the Game of 21. Here are the rules:");
        int finalPoints = 0;
        GameRules (finalPoints);    
    }
    
    // GameRules(finalPoints) states all of the rules to The Game of 21 for the user and asks
    //  if they want to proceed to the game.
    public static void GameRules(int finalPoints) throws InterruptedException {
        Scanner input=new Scanner(System.in);
        String begin;
        Thread.sleep (2000);
        System.out.println ("****************************************************************");
        System.out.println ("                    RULES: THE GAME OF 21                       ");
        System.out.println ("****************************************************************");
        System.out.println ("1. All numbers 1-13 represent a playing card. 1 is ");
        System.out.println ("   the Ace, 2-10 are the cards 2-10, and 11-13     ");
        System.out.println ("   are Jack, Queen and King respectively.          ");
        System.out.println ();
        Thread.sleep (5000);
        System.out.println ("2. All cards have the value of their number, except ");
        System.out.println ("   Ace has a value of either 1 or 11, and Jack,     ");
        System.out.println ("   Queen and King all have a value of 10.           ");
        System.out.println();
        Thread.sleep (5000);
        System.out.println ("3. You will be dealt 2 cards to begin with, and  will be");
        System.out.println ("   given the choice of recieving a third card or not.");
        System.out.println();
        Thread.sleep (5000);
        System.out.println ("4. The computer will experience the same procedure.  ");
        System.out.println ();
        Thread.sleep (3000);
        System.out.println ("5. The player whose sum of points is closest to 21   ");
        System.out.println ("   without going over 21, is declared the winner.    ");
        System.out.println();
        Thread.sleep (4000);
        System.out.println();
        System.out.print ("Are you ready to begin? Enter Y/N: ");
        begin = input.next ();
        if ("Y".equals(begin)||"y".equals(begin)||"Yes".equals(begin)||"yes".equals(begin)||"YES".equals(begin)) {
            System.out.println();
            Deal2Cards(finalPoints);
        }
        else if ("N".equals(begin)||"n".equals(begin)||"No".equals(begin)||"no".equals(begin)||"NO".equals(begin)){
            System.out.println();
            GameRules (finalPoints);
        }
        else {
            InvalidStart(finalPoints);
        }
    }
    
    // Deal2Cards(finalPoints) presents the user with 2 random cards and sums their current points.
    public static void Deal2Cards(int finalPoints) throws InterruptedException {
        Random rn = new Random();
        int range = 13;
        int card1 =  rn.nextInt(range) + 1; 
        int card2 = rn.nextInt(range) + 1;
        int currentPoints = card1 + card2;
        System.out.println ("Your 1st card is: " + card1);
        System.out.println ("Your 2nd card is: " + card2);
        System.out.println ("Your current points are:  " + currentPoints);
        ThirdCard (currentPoints, range, finalPoints); 
                  
    }
    
    // InvalidStart(finalPoints) is called if an invalid answer is inputted in GameRules.
    //  The user is asked to try again to input a valid answer.
    public static void InvalidStart(int finalPoints) throws InterruptedException {
        Scanner input = new Scanner (System.in);
        String tryAgain;
        System.out.print ("Invalid entry. Please try again: ");
        tryAgain= input.next ();
        if ("Y".equals(tryAgain)||"y".equals(tryAgain)||"Yes".equals(tryAgain)||"yes".equals(tryAgain)||"YES".equals(tryAgain)) {
            System.out.println();
            Deal2Cards(finalPoints);
        }
        else if ("N".equals(tryAgain)||"n".equals(tryAgain)||"No".equals(tryAgain)||"no".equals(tryAgain)||"NO".equals(tryAgain)){
            System.out.println();
            GameRules(finalPoints);
        }
        else {
            InvalidStart(finalPoints) ;
        }               
    }
    
    // ThirdCard(currentPoints, range, finalPoints) asks if the user would like a third card. 
    //  If not, it displays the user's final sum of points.
    public static void ThirdCard (int currentPoints, int range, int finalPoints) throws InterruptedException {
        Scanner input = new Scanner (System.in);
        String newCard;
        Thread.sleep (2000);
        System.out.println();
        System.out.print ("Would you like a third card? Enter Y/N: ");
        newCard = input.next ();
        if ("Y".equals(newCard)||"y".equals(newCard)||"Yes".equals(newCard)||"yes".equals(newCard)||"YES".equals(newCard)) {
            System.out.println();
            Deal3rdCard(currentPoints, range, finalPoints);
        }
        else if ("N".equals(newCard)||"n".equals(newCard)||"No".equals(newCard)||"no".equals(newCard)||"NO".equals(newCard)){
            finalPoints = currentPoints;
            System.out.println ("You did not pick a third card. ");
            System.out.println ("Your total points are: " + finalPoints);
            System.out.println();
            ComputerPoints (range, finalPoints);
        }
        else {
            InvalidThirdCard (currentPoints, range, finalPoints) ;
        }               
    }
    
    // InvalidThirdCard(currentPoints, range, finalPoints) is called if the user inputs an invalid answer
    //  in ThirdCard. The user is asked to try again to input a valid answer.
    public static void InvalidThirdCard (int currentPoints, int range, int finalPoints) throws InterruptedException {
        System.out.print ("Invalid entry. Please try again. ");
        ThirdCard (currentPoints, range, finalPoints);      
    }
    
    // Deal2rdCard(currentPoints, range, finalPoints) presents the user a third card if they chose 'yes' in 
    // ThirdCard. It sums the new total points of the user.
    public static void Deal3rdCard (int currentPoints, int range, int finalPoints) throws InterruptedException {
        Random rn = new Random();
        int card3 =  rn.nextInt(range) + 1; 
        finalPoints = currentPoints + card3;
        System.out.println ("Your 3rd card is: " + card3);
        ComputerPoints (range, finalPoints);
    }
    
    // ComputerPoints(range, finalPoints) randomly presents 2 cards for the computer and sums its points.
    public static void ComputerPoints (int range, int finalPoints) throws InterruptedException {
        Random rn = new Random ();
        int compCard1 =  rn.nextInt(range) + 1; 
        int compCard2 = rn.nextInt(range) + 1;
        int compCurrentPoints = compCard1 + compCard2;
        Thread.sleep (3000);
        System.out.println();
        System.out.println ("The Computer's 1st card is: " + compCard1);
        System.out.println ("The Computer's 2nd card is: " + compCard2);
        System.out.println ("The Computer's current points are:  " + compCurrentPoints);
        Computer3rdCard(range, compCurrentPoints, finalPoints);
    }
    
    // Computer3rdCard randomly decides if the computer will receive a third card. If so, it will present a third card.
    //  The computer's final points are displayed.
    public static void Computer3rdCard (int range, int compCurrentPoints, int finalPoints) throws InterruptedException {
        Random rn = new Random();
        int decisionRange = 2;
        int decision =  rn.nextInt(decisionRange) + 1; 
        int compFinalPoints;
        Thread.sleep (3000);
        if (1 == decision){
            int compCard3 =  rn.nextInt(range) + 1;
            System.out.println ("The Computer would like a third card. ");
            System.out.println ("The Computer's 3rd card is: " + compCard3);  
            System.out.println();
            Thread.sleep (3000);
            compFinalPoints = compCurrentPoints + compCard3;
            System.out.println ("The Computer's total points are: " + compFinalPoints);
            Winner (finalPoints, compFinalPoints);
        }
        else {
            System.out.println ("The Computer does not want a third card. ");
            System.out.println();
            Thread.sleep (3000);
            compFinalPoints = compCurrentPoints;
            System.out.println ("The Computer's total points are: " + compFinalPoints);
            Winner(finalPoints, compFinalPoints);
        }  
    }
    
    // Winner(finalPoints, compFinalPoints) displays the final points of user and computer and a winner is announced.
    //  The user is asked to play again.
    public static void Winner (int finalPoints, int compFinalPoints) throws InterruptedException {
        Scanner input = new Scanner (System.in);
        String again;
        int userDifference = 21 - finalPoints;
        int compDifference = 21 - compFinalPoints;
        System.out.println();
        Thread.sleep (2000);
        System.out.println ("GAME SUMMARY:");
        System.out.println ("Your total points are: " + finalPoints);
        System.out.println ("The Computer's total points are: " + compFinalPoints);
        Thread.sleep (3000);
        if (finalPoints > 21 && compFinalPoints > 21) {
            System.out.println ("Both players exceed 21 points. There is no winner. ");
        }
        else if (finalPoints > 21) {
            System.out.println ("Your points exceed 21. The Computer wins! ");
        }
        else if (compFinalPoints > 21) {
            System.out.println ("The Computer's points exceed 21. ");
            System.out.println ("Congratulations, you win! ");
        }
        else if (userDifference < compDifference) {
            System.out.println ("Your points are closest to 21. ");
            System.out.println ("Congratulations, you win!");
        }
        else {
            System.out.println ("The Computer's points are closest to 21. ");
            System.out.println ("The Computer wins! ");
        } 
        System.out.print ("Would you like to play again? Enter Y/N: ");
        again = input.next ();
        if ("Y".equals(again)||"y".equals(again)||"Yes".equals(again)||"yes".equals(again)||"YES".equals(again)) {
            System.out.println();
            GameRules (finalPoints);
        }
        else if ("N".equals(again)||"n".equals(again)||"No".equals(again)||"no".equals(again)||"NO".equals(again)){
            System.out.println("Thanks for playing!");

        }
        else {
            InvalidWinner(finalPoints);
        }               
    }
    
    // InvalidWinner(finalPoints) is called if an invalid answer is given in Winner(finalPoints, compFinalPoints. 
    //  The user is asked to try again to input a valid answer.
    public static void InvalidWinner (int finalPoints) throws InterruptedException {
        Scanner input = new Scanner (System.in);
        String tryAgain;
        System.out.print ("Invalid entry. Please try again: ");
        tryAgain= input.next ();
        if ("Y".equals(tryAgain)||"y".equals(tryAgain)||"Yes".equals(tryAgain)||"yes".equals(tryAgain)||"YES".equals(tryAgain)) {
            System.out.println();
            GameRules(finalPoints);
        }
        else if ("N".equals(tryAgain)||"n".equals(tryAgain)||"No".equals(tryAgain)||"no".equals(tryAgain)||"NO".equals(tryAgain)){
            System.out.println("Thanks for playing!");
        }
        else {
            InvalidWinner(finalPoints);
        }               
    }   
}