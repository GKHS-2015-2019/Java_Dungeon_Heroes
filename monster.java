import java.util.Scanner;
import java.util.Random;


public class DungeonHeroes {
   //constants
   //chances of getting different variety of rooms
   //0-70 monster
   //71-81 store
   //82-90 1d4 basic treasures
   //91-92 1d2 advanced treasures
   //93 1 epic treasure (unguarded)
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
   public static Random rand; //handles random numbers
   public static MonsterList monsters; //stores the types of monsters
   public static Dice dice; //stores a new dice roller
   
   public static void main(String[] args) {
      System.out.println("Welcome to Dungeon Heroes!");
      System.out.println();
      
      //setup global variables
      input = new Scanner(System.in);
      rand = new Random();
      monsters = new MonsterList();
      dice = new Dice();
   
      createCharacter(input); //player chooses their player class
      g_player.status(); //tests player & shows status
      
      //main loop
      boolean playGame = true;
       //starting room
      if(startRoom(input).equals("L")){
         playGame = false;
      }      
      while(playGame) {
         playGame = enterRoom(input); //Keep playing until the user quits
      }
            
   }// end main
   
   //create Character --> Creates a new character giving the player choice
   public static void createCharacter(Scanner input) {
      //name
      System.out.print("What name would you like to be know by hero?");
      //Scanner input = new Scanner(System.in);
      String name = input.nextLine();
      System.out.println("Welcome " + name + "!");
      
      //check for class
      boolean validClass = false;
      while (!validClass) {
         System.out.print("Do you want to play a mighty (W)arrior or cunning (T)hief?");
         String response = input.nextLine().toUpperCase();
         if(response.substring(0,1).equals("W")) {
            //warrior
            validClass = true;
            g_player = new Player(name, "WARRIOR");
         } 
         else if(response.substring(0,1).equals("T")) {
            //thief
            validClass = true;
            g_player = new Player(name, "THIEF");
         } 
         else {
            System.out.println("Invalid Class. Please choose (W)arrior or(T)hief!");
         }
      }      
   }// end chooseClass
   
   //startRoom the starting room
   //return String (the first character of the players response)
   public static String startRoom(Scanner input) {
      System.out.println("Three months ago, you set out from your village looking for glory and riches.");
      System.out.println("After a long journey into the mountains, you come across a cave.");
      System.out.print("You hear horrible noises coming from inside. Do you want to (E)nter or (L)eave?");
      
      boolean validInput = false; //keep asking them until they give us good input
      String response = "";
      while(!validInput) {
         response = input.nextLine().toUpperCase();
         if(response.length() ==0 || (response.charAt(0) != 'E' && response.charAt(0)!='L')) {
            System.out.print("Invalid response. Options are (E)nter or (L)eave.");
         } 
         else {
            validInput = true;//they have a valid response
         }
      }      
      return response.substring(0,1);
   }
   
   //enterRoom: enters a new room where the player will battle a monster etc
   //@param --> input A scanner to console input
   //@return --> false -stop playing the game, true - keep playing the game (enter a new room)
   public static boolean enterRoom (Scanner input) {
      System.out.println();
      System.out.println("You have entered a new room");
      int treasure = fightMonster(input);
      if(treasure == -1){
         return false; //they died game over
      }
      //getTreasure(treasure)
      //handle resting
      return rest(input);
      
   }
   
   //rest: allows the user to (E)nter next room, (R)est, (S)tatus or open (I)nventory (Q)uit
   //@param --> input A scanner to console input
   //@return --> true when they hit enter.... false to leave the game
   public static boolean rest(Scanner input) {
      //prompt user
      System.out.println();
      System.out.println("The room is now safe");
      String response = "";
      while(!response.equals("E"));
      System.out.println("Do you want to check your (S)tats, (R)est to recover stamina and health, open (I)nventory, " +
         " (E)nter the next room, or (Q)uit the game.");
      response = getResponse();
      return true;  
      
       
   }
   //fightMonster - rolls a random monster and simulates fight
   //@param --> input - a scanner console input
   //@return --> int (epic treasures in 100s column, advanced treasures in 10s column, basic treasures in the 1s column, -1 player dead)
   public static int fightMonster(Scanner input) {
      Monster curMonster = monsters.getMonster();
      int monsterHealth = curMonster.health; //copy the monster's health
      //System.out.println("You come face to face with a " + curMonster.name);
      System.out.println(curMonster.desc);
      System.out.println("The " + curMonster.name + " is poised, ready to attack!");
      //calcutate potential treasure
      int treasure = curMonster.epic * 100 + curMonster.advanced * 10 + curMonster.basic;
      
      //main fighting loop
      boolean keepFighting = true; //should we keep fighting
      while(keepFighting) {
         //get their input
         boolean validInput = false;
         String response = "";
         while(!validInput) {
            System.out.print("Do you want to (F)lee, make a (S)trong attack, or make a (W)eak attack?");
            response = getResponse();
            if(response.equals("F") || response.equals("S") || response.equals("W")) {
               //it is a valid response
               validInput = true;
            }else{
               System.out.println("Invalid input!");
            }//end else
         }//end validInput while
         
         //generate an attack
         boolean flee = curMonster.singleAttack(dice, g_player, response); //handles one attack        
         //did the player flee?
         if(flee){
            System.out.println("You managed to flee");
            System.out.println();
            return 0; //no treasure
         }   
         
         //did the player die?
         if(g_player.health <= 0){
            //if the player died
            System.out.println();
            System.out.println("You have been slain by a " + curMonster.name);
            System.out.println("Total Gold: " + g_player.gold + ", Total Level: " + g_player.level);
            System.out.println("Better luck next time");
            System.out.println();
            return -1;
         }   
         //did the player win  
         if(curMonster.curHealth <= 0){
            System.out.println("You have vanquished the " + curMonster.name);
            
            //reward with food gold and xp
            System.out.println();
            System.out.println("Time to loot!");
            g_player.giveFood(curMonster.giveFood());
            g_player.giveGold(curMonster.giveGold());
            g_player.giveXP(curMonster.xp);
            return treasure; 
         }
      }//end keepFight while
      
      return -1;
   }
   
   //gets user input and returns a single capital character
   public static String getResponse() {
      boolean validInput = false;
         String response = "";
      while(!validInput) {
         response = input.nextLine().toUpperCase();
         //if they didn't type anything make them choose an answer
         if(response.length() == 0) {
            System.out.print("You must select a choice!");
         } else {
            validInput = true;
         }
      }
      //return the firstCharacter
      return response.substring(0,1);
   }
   
   
   //diceRoll -- rolls a 6 sided open ended dice (if we roll a 6, we roll again and add 5 to our next roll)
   //@return --> dice roll
   public static int diceRoll() {
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

}//end DungeonHeroes/ class


On Wed, Nov 4, 2015 at 12:01 PM, MICHELLE MOLINA <342517@students.bethelsd.org> wrote:
//Monsters Attack
      int monsterAttack = this.attack + dice.roll() - p.defense - dice.roll();
      int monsterDamage = this.damage + dice.roll() - p.protection - dice.roll();
      //did the monster miss?
      if(monsterAttack < 0) {
         System.out.println("The " + this.name + " " + this.attackDesc + " you but misses.");
      } else {
         //did they do damage?
         if(monsterDamage < 0) {
            System.out.println("The " + this.name + " " + this.attackDesc + " you but does no damage.");
         } else {
            //they did damage
            p.health = p.health - monsterDamage;
            System.out.println("The " + this.name + " " + this.attackDesc + " and does " + monsterDamage + " damage! ("
               + p.health + "/" + p.maxHealth);
         }//end damage block
      }//end hit block
    
      return false;
      
   }
   
}