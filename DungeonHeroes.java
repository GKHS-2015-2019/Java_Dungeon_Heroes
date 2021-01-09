import java.util.Scanner;
import java.util.Random;

public class DungeonHeroes{
   //constants
   //chances of getting different rooms
   //0-70  monster
   //71-81 store
   //82-90 1d4 basic treasures
   //91-92 1d2 advanced treasures
   //93  1 epic treausre (unguarded)
   //94-99 exit
   public static final int MONSTER_CHANCE = 70;
   public static final int STORE_CHANCE = 81;
   public static final int BASIC_TREASURE_CHANCE = 90;
   public static final int ADVANCED_TREASURE_CHANCE = 92;
   public static final int EPIC_TREASURE_CHANCE = 93;
   public static final int EXIT_CHANCE = 99;
   
   //global variables
   public static Player g_player; //all information for the player.
   public static Scanner input; //handles player input
   public static Random rand; //handes random numbers
   public static MonsterList monsters; //stores the types of monsters
   public static Dice dice; //stores a new dice roller

   public static void main(String[] args){
      System.out.println("Welcome to Dungeon Heroes!");
      System.out.println();
      
      //setup global variables
      input = new Scanner(System.in);
      rand = new Random();
      monsters = new MonsterList();
      dice = new Dice();
      
      createCharacter(input); //player chooses their player class
      g_player.status(); //tests player and shows us status
      
      //main loop
      boolean playGame = true;
      //starting room
      if(startRoom(input).equals("L")){
        playGame = false;
      }
      while(playGame){
         playGame = enterRoom(input); //Keep playing until the user quits 
      }
      
   }
   
   //createCharacter --> Creates a new character giving the player choice
   public static void createCharacter(Scanner input){
      //name
      System.out.print("What name would you like to be known by hero? ");
      //Scanner input = new Scanner(System.in);
      String name = input.nextLine();
      System.out.println("Welcome " + name + "!");
      
      //check for class
      boolean validClass = false;
      while(!validClass){
         System.out.print("Do you want to play a mighty (W)arrior or cunning (T)hief? ");
         String response = input.nextLine().toUpperCase(); 
         if(response.substring(0,1).equals("W")){
           //warrior
            validClass = true;
            g_player = new Player(name,"WARRIOR");
         } 
         else if(response.substring(0,1).equals("T")){
            //thief
            validClass = true;
            g_player = new Player(name,"THIEF");
         } 
         else {
            System.out.println("Invalid Class.  Please choose (W)arrior or (T)hief!");
         }  
      }
   }
   
   //startRoom the starting room
   //return String (the first character of the players repsonse)
   public static String startRoom(Scanner input){
      System.out.println("Three months ago, you set out from your village looking for glory and riches.");
      System.out.println("After a long journey into the mountains, you came across a cave.");
      System.out.print("You hear horrible noises coming from inside.  Do you want to (E)nter or (L)eave?");
      
      boolean validInput = false; //keep asking them until they give us good input
      String response = "";
      while(!validInput){
         response = input.nextLine().toUpperCase();
         if(response.length() == 0 || (response.charAt(0) != 'E' && response.charAt(0) !='L')){
            System.out.print("Invalid response. Options are (E)nter or (L)eave.");
         } else {
            validInput = true;  //they have a valid response
         }
      }
      
      return response.substring(0,1);
   }  ///verify line 87, line 89, line 90 (those are the ones I changed after I typed them)

   //enterRoom: enters a new room where the player will battle a monster etc
   //@param --> input A scanner to console input
   //@return --> false - stop playing the game, true - keep playing the game (enter a new room
   public static boolean enterRoom(Scanner input){
      System.out.println();
      System.out.println("You have entered a new room");
      int treasure = fightMonster(input);
      if(treasure == -1){
            return false;  //they have died... game over
      }
      //getTreasure(treasure)
      //handle resting
      return rest(input);  
   }
   
   //rest: allows the user to (E)nter next room, (R)est, (S)tatus or open (I)nventory, (Q)uit game
   //@param --> input A scanner to console input
   //@return --> true when they hit enter... false to leave the game
   public static boolean rest(Scanner input){
      //prompt user
      System.out.println();
      System.out.println("The room is now safe");
      String response = "";
      while(!response.equals("E")){
         System.out.println("Do you want to check your(S)tatus, (R)est to recover stamina and health, open (I)nventory, " +
            " (E)nter the next room, or (Q)uit the game.");
         response = getResponse();
         //resting
         if(response.equals("R")){
            g_player.rest();
         }
         //status
         if(response.equals("S")){
            g_player.status();
         }
         //quit game
         if(response.equals("Q")){
            return false;
         }
         
      }
      return true;
   }
   
   //fightMonster - rolls a random monster and simulates fight
   //@param --> input - a scanner console input
   //@return --> int (epic treasures in 100s column, Advanced treasures in 10s column, basic treasures in the 1s column, -1 player dead)
   public static int fightMonster(Scanner input){
      Monster curMonster = monsters.getMonster();
      int monsterHealth = curMonster.health;  //copy the monsters health
      //System.out.println("You come face to face with a " + curMonster.name);
      System.out.println(curMonster.desc);
      System.out.println("The " + curMonster.name + " is poised, ready to attack!");
      //calcululate potential treasure
      int treasure = curMonster.epic * 100 + curMonster.advanced * 10 + curMonster.basic;
      
      //main fighting loop
      boolean keepFighting = true; //should we keep fighting
      while(keepFighting){
         //get their input
         boolean validInput = false;
         String response = "";
         while(!validInput){
            System.out.print("Do you want to (F)lee, make a (S)trong attack, or make a (W)eak attack?");
            response = getResponse();
            if(response.equals("F") || response.equals("S") || response.equals("W")){
               //it is a valid response
               validInput = true;
            } else {
               System.out.println("Invalid input!");
            } //end else
         } //end validInput while
         
         //generate an attack
         boolean flee = curMonster.singleAttack(dice, g_player, response); //handles one attack 
         //did the player flee?
         if(flee){
            System.out.println("You manage to flee!");
            System.out.println();
            return 0;  //no treasure
         }
         
         //did the player die?
         if(g_player.health <= 0){
           //the player died
           System.out.println();
           System.out.println("You have been slain by a " + curMonster.name);
           System.out.println("Total Gold: " + g_player.gold + ", Total Level " + g_player.level);
           System.out.println("Better luck next time!");
           System.out.println();
           return -1;
         }
         
         //did the player win?
         if(curMonster.curHealth <= 0){
            System.out.println("You vanquish the " + curMonster.name);
            
            //reward with food, gold and xp
            System.out.println();
            System.out.println("Time to Loot!");
            g_player.giveFood(curMonster.giveFood());
            g_player.giveGold(curMonster.giveGold());
            g_player.giveXP(curMonster.xp);
            return treasure;
         }
         
      }//end keepFight while
      
      return -1;
   }
   
   //gets user input and returns a single capital character
   public static String getResponse(){
      boolean validInput = false;
      String response = "";
      while(!validInput){
         response = input.nextLine().toUpperCase();
         //if they didn't type anything make them choose an answer
         if(response.length() == 0){
            System.out.print("You must select a choice!");
         } else {
           validInput = true;
         }
      }
      //return the firstCharacter
      return response.substring(0,1);
   }   
   


  
} //end class