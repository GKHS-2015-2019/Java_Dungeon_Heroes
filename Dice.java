import java.util.Random;
//Dice --> Simulates open ended 6 sided dice rolls


public class Dice {
   private Random rand; //dice roller
   
   //constructor
   public Dice() {
      rand = new Random();
   }
   
   //roll
   //returns an open ended 6 sided dice roll
   public int roll() {
      int curRoll = rand.nextInt(6)+1;  //number between 1 & 6
      int total = curRoll;
      //keep rolling until we roll something that isn't a 6
      while(curRoll == 6) {
         total = total - 1; //make total 5
         curRoll = rand.nextInt(6) +1; //new num between 1 & 6
         total = total + curRoll;
      }
      
      return total;
   }
   
}
   