import java.util.Scanner;


//adds a store to the game
public class Store{
   public static final int BASIC_PRICE = 50;
   public static final int ADVANCED_PRICE = 200;
   public static final int EPIC_PRICE = 500;
   
   //constructor
   public Store(){
   
   }
   
   
   //enters a store and asks user if they want to buy an item
   //returns the treasure
   public int enterStore(Scanner input, Player p){
      System.out.println("A strange guy stands in the middle of this room with a backpack bulging with treasure.");
      System.out.println("He says, \n************\nYOU CAN BUY\n************");
      System.out.println("A (B)asic item for !!!" + BASIC_PRICE + "!!! gold coins,");
      System.out.println("An (A)dvanced item for !!!" + ADVANCED_PRICE + "!!! gold coins,");
      System.out.println("An (E)pic item for !!!" + EPIC_PRICE + "!!! gold coins,");
      System.out.println("or you can (L)eave my shop.\"");
      System.out.println();
      System.out.println("You have !" + p.gold + "! gold.");
      
      int totalGold = p.gold;
      int treasure = 0;
      
      String response = getResponse(input);
      if(response.equals("B")){ 
        totalGold -= BASIC_PRICE;
        treasure = 1;
      } else if(response.equals("A")){
        totalGold -= ADVANCED_PRICE;
        treasure = 10;
      } else if(response.equals("E")){
        totalGold -= EPIC_PRICE;
        treasure = 100;
      } else{
        System.out.println("You leave the room without buying anything.");
        return 0;
      }
      
      //if they have enough money... give them the item
      if(totalGold > 0){
        p.gold = totalGold;
        System.out.println("The merchant throws an item on the floor and leaves the room.");
      } else {
        System.out.println("You don't have enough money.  The tinker leaves in disgust.");
        treasure = 0;
      }
           
      return treasure;
   
   }
   
    //gets user input and returns a single capital character
   public static String getResponse(Scanner input){
      boolean validInput = false;
      String response = "";
      while(!validInput){
         response = input.nextLine().toUpperCase();
         //if they didn't type anything make them choose an answer
         if(response.length() == 0){
            System.out.print("You must select a choice!");
         } 
         else {
            validInput = true;
         }
      }
      //return the firstCharacter
      return response.substring(0,1);
   }

}