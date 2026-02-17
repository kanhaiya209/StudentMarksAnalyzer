package NumberGuessingGame;
import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int guess;

        int number = rand.nextInt(100)+1;

        do{
            System.out.print("Guess The Number: ");
            guess = sc.nextInt();
            count++;
            if(guess < number){
                System.out.println("Your Number is too low.");
            }else if(guess > number){
                System.out.println("Your Number is too higher");
            }else{
                System.out.println("Congrats!!!You Found The Number.");
                System.out.println("The Number is: "+guess);
                System.out.println("You guessed in "+ count+" Attempts");
                break;
            }
        }while(true);
    }
}
