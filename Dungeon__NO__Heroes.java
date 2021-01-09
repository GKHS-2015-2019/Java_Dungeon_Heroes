import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class DungeonHeroes{
   //constants
   //chances of getting different rooms
   //0-70  monster
   //71-81 store
   //82-90 1d4 basic treasures
   //91-92 1d2 advanced treasures
   //93  1 epic treausre (unguarded)
   //94-99 exit
   public static final int MONSTER_CHANCE = 0;//60% chance of fighting a monster
   //public static final int DARK_ROOM_CHANCE = 60; //(10% chance) we come to a dark room..
   public static final int STORE_CHANCE = 70;//(10% chance)we come to the store
   //public static final int TRAP_ROOM_CHANCE = 80; //(5% chance) we come to a dark room..
   public static final int BASIC_TREASURE_CHANCE = 85; //(5% chance) 1-2 basic items
   public static final int ADVANCED_TREASURE_CHANCE = 90; //(3% chance) 1-2 advanced items
   public static final int EPIC_TREASURE_CHANCE = 93;//(6% chance)1-2 epic treasure chest
   public static final int EXIT_CHANCE = 99;// 1 percent of the time we reach exit
   
   //global variables
   public static Store g_store;
   public static Player g_player; //all information for the player.
   public static Scanner g_input; //handles player input
   public static Random g_rand; //handes random numbers
   public static MonsterList g_monsters; //stores the types of monsters
   public static Dice g_dice; //stores a new dice roller
   public static Loot g_loot; //the loot tables

   public static void main(String[] args){
      System.out.println("******----******----******");
      System.out.println("Welcome to Dungeon Heroes!");
      System.out.println("******----******----******");
      System.out.println();
      System.out.println("\\^~~~~\\   )  (   /~~~~^/ ");
      System.out.println(" ) *** \\  {**}  / *** ( ");
      System.out.println("  ) *** \\_ ^^ _/ *** ( ");
      System.out.println("  ) ****   vv   **** ( ");
      System.out.println("  )_****      ****_( ");
      System.out.println("    )*** m  m ***( ");
      System.out.println();
      
      //setup global variables
      g_input = new Scanner(System.in);
      g_rand = new Random();
      g_monsters = new MonsterList();
      g_dice = new Dice();
      g_loot = new Loot();
      g_store = new Store();
      System.out.println("Select (N)ew game or (C)ontinue");
      String response = getResponse();
      if(response.equals("C")){
         try{
            g_player = SaveGame.load("saveGame.txt");
            System.out.println("File Loaded");
         }
         catch(FileNotFoundException e){
            System.out.println("SaveGame not found");
            createCharacter(g_input);
         }
      }
      else {
         createCharacter(g_input); //player chooses their player class
      }
      //g_player.status(); //tests player and shows us status
      System.out.println();
      
      //main loop
      boolean playGame = true;
      //starting room
      if(startRoom(g_input).equals("L")){
         playGame = false;
      }
      while(playGame){
         playGame = enterRoom(g_input); //Keep playing until the user quits 
      }
      
   }
   
   //createCharacter --> Creates a new character giving the player choice
   public static void createCharacter(Scanner g_input){
      //name
      System.out.print("What name would you like to be known by hero? ");
      String name = g_input.nextLine();
      System.out.println("Welcome " + name + "!");
      
      //check for class
      boolean validClass = false;
      while(!validClass){
         System.out.print("Do you want to play a mighty (W)arrior or cunning (T)hief? ");
         String response = g_input.nextLine().toUpperCase(); 
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
   public static String startRoom(Scanner g_input){
      System.out.println("Three months ago, you set out from your village looking for glory and riches.");
      System.out.println("After a long journey into the mountains, you came across a cave.");
      System.out.print("You hear horrible noises coming from inside.  Do you want to (E)nter or (L)eave?");
      
      boolean validInput = false; //keep asking them until they give us good input
      String response = "";
      while(!validInput){
         response = g_input.nextLine().toUpperCase();
         if(response.length() == 0 || (response.charAt(0) != 'E' && response.charAt(0) !='L')){
            System.out.print("Invalid response. Options are (E)nter or (L)eave.");
         } 
         else {
            validInput = true;  //they have a valid response
         }
      }
      
      return response.substring(0,1);
   }  ///verify line 87, line 89, line 90 (those are the ones I changed after I typed them)

   //enterRoom: enters a new room where the player will battle a monster etc
   //@param --> input A scanner to console input
   //@return --> false - stop playing the game, true - keep playing the game (enter a new room
   public static boolean enterRoom(Scanner g_input){
      System.out.println();
      System.out.println("***************************");
      System.out.println("You have entered a new room");
      int treasure = 0;
      
      boolean levelUp = false;
      
      if(g_player.level == 2 || g_player.level == 5){
         if(levelUp){
            System.out.println();
            treasure = (int)(Math.floor(Math.random()*2) + 1) * 1; //1 or 2
            getlevelUp(treasure);
            levelUp = false;
         }
      }
      
      //get our random room
      double roomType = Math.random()*100;// 0.0 --> 99.9999
      //are we at the end of the dungeon?
      if(roomType >= EXIT_CHANCE){
         return exitRoom(g_input);
      }
      /*
      if(roomType >= DARK_ROOM_CHANCE){
         return darkRoom(g_input);
      }
      if(roomType >= TRAP_ROOM_CHANCE){
         return trapRoom(g_input);
      }
      */
      //is this an epic chest
      if(roomType >= EPIC_TREASURE_CHANCE){
         System.out.println("$$$EPIC TREASURE ROOM$$$");
         System.out.println();
         System.out.println("         __________  ");
         System.out.println("        /\\____;;___\\  ");
         System.out.println("       | /         /  ");
         System.out.println("       `. ()()vv() .  ");
         System.out.println("        |\\()()^^() \\  ");
         System.out.println("        | |---------|  ");
         System.out.println("        \\ |    ))   |  ");
         System.out.println("         \\|_________|  ");
         System.out.println();
         treasure = (int)(Math.floor(Math.random()*2) + 1) * 100; //100 or 200
      }
      //is this an advanced treasure room?
      else if(roomType >= ADVANCED_TREASURE_CHANCE){
         System.out.println("$$$Advanced Treasure Room$$");
         System.out.println();
         System.out.println("         __________  ");
         System.out.println("        /\\____;;___\\  ");
         System.out.println("       | /         /  ");
         System.out.println("       `. ()()vv() .  ");
         System.out.println("        |\\()()^^() \\  ");
         System.out.println("        | |---------|  ");
         System.out.println("        \\ |    ))   |  ");
         System.out.println("         \\|_________|  ");
         System.out.println();
         treasure = (int)(Math.floor(Math.random()*2) + 1) * 10; //10 or 20
      }
      //is this a basic treasure room?
      else if(roomType >= BASIC_TREASURE_CHANCE){
         System.out.println("Basic Treasure Room!");
         System.out.println();
         System.out.println("         __________  ");
         System.out.println("        /\\____;;___\\  ");
         System.out.println("       | /         /  ");
         System.out.println("       `. ()()vv() .  ");
         System.out.println("        |\\()()^^() \\  ");
         System.out.println("        | |---------|  ");
         System.out.println("        \\ |    ))   |  ");
         System.out.println("         \\|_________|  ");
         System.out.println();
         treasure = (int)(Math.floor(Math.random()*2) + 1) * 1; //1 or 2
      }
      //is this a store?
      else if(roomType >= STORE_CHANCE){
         treasure = g_store.enterStore(g_input, g_player);
      }
      //otherwise we fight a monster.
      else{
         treasure = fightMonster(g_input);
         if(treasure == -1){
            return false;  //they have died... game over
         }
      }
      
      //gives the player randomly rolled treasure
      getTreasure(treasure);
      
      //handle resteing
      return rest(g_input);  
   }
   
   //rest: allows the user to (E)nter next room, (R)est, (S)tatus or open (I)nventory, (Q)uit game
   //@param --> input A scanner to console input
   //@return --> true when they hit enter... false to leave the game
   public static boolean rest(Scanner g_input){
      //prompt user
      System.out.println();
      System.out.println("The room is now safe");
      String response = "";
      while(!response.equals("E")){
         System.out.print("Do you want to check your(S)tatus, (R)est to recover stamina and health, open (I)nventory, " +
            " \n(E)nter the next room, save and (Q)uit the game.");
         System.out.print("");
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
            try{
               SaveGame.save(g_player,"saveGame.txt");
               return false;
            }
            catch(FileNotFoundException e){
               System.out.println("Problem Saving file not found");
               return false;
            }
         
         }
         //open inventory
         if(response.equals("I")){
            g_player.inventory.handleInventory(g_input, g_player);
         }
      return true;
   }
   
   //fightMonster - rolls a random monster and simulates fight
   //@param --> input - a scanner console input
   //@return --> int (epic treasures in 100s column, Advanced treasures in 10s column, basic treasures in the 1s column, -1 player dead)  
   public static int fightMonster(Scanner g_input){
      Monster curMonster = g_monsters.getMonster(g_player);
      curMonster.curHealth = curMonster.health;  //copy the monsters health
      System.out.println("You come face to face with a " + curMonster.name);
      System.out.println(curMonster.desc);
      System.out.println("The " + curMonster.name + " is poised, ready to attack!");
      if(g_player.level >= curMonster.level){
         System.out.println();
         System.out.println("***********************");
         System.out.println("Good Monster: "  + curMonster.name);
      } 
      else {
         System.out.println();
         System.out.println("***********************");
         System.out.println("Bad Monster: " + curMonster.name);
      }
      System.out.println("player level: " + g_player.level);
      System.out.println("Monster level: " + curMonster.level);
      System.out.println("***********************");
      System.out.println();
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
            } 
            else {
               System.out.println("Invalid input!");
            } //end else
         } //end validInput while
         
         //generate an attack
         boolean flee = curMonster.singleAttack(g_dice, g_player, response); //handles one attack 
         //did the player flee?
         if(flee){
            System.out.println();
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
            System.out.println();
            System.out.println("*************************************");
            System.out.println("You vanquish the " + curMonster.name);
            System.out.println("Your Health: " + g_player.health);
            
            //reward with food, gold and xp
            System.out.println("                            .-'''''-.   ");
            System.out.println("                            |'-----'|   ");
            System.out.println("                            |-.....-|   ");
            System.out.println("                            |       |   ");
            System.out.println("                            |       |   ");
            System.out.println("        _,._                |       |   ");
            System.out.println("    __.o`   o`\"-.           |       |   ");
            System.out.println("   .-O o `\"-.o   O )_,._    |       |   ");
            System.out.println("  ( o   O  o )--.-\"`O   o\"-.`'-----'`   ");
            System.out.println("   '--------'  (   o  O    o)           ");
            System.out.println("                `----------`            "); 
            g_player.giveFood(curMonster.giveFood());
            System.out.println("      \\`\\/\\/\\/`/  ");
            System.out.println("       )======(   ");
            System.out.println("     .'        '.   ");
            System.out.println("    /    _||__   \\   ");
            System.out.println("   /    (_||_     \\   ");
            System.out.println("  |     __||_)     |   ");
            System.out.println("  |       ||       |   ");
            System.out.println("  '.              .'   ");
            System.out.println("    '------------'   ");
            g_player.giveGold(curMonster.giveGold());
            g_player.giveXP(curMonster.xp);
            return curMonster.getTreasure();
         }
         
      }//end keepFight while
      
      return -1;
   }
   
   //gets user input and returns a single capital character
   public static String getResponse(){
      boolean validInput = false;
      String response = "";
      while(!validInput){
         response = g_input.nextLine().toUpperCase();
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
   
   //getTreasure - rolls random treasure and allows the user to take it (or convert to money)
   //@param int treasure (1s are basic, 10s are advanced, 100s are epic treasure)
   public static void getTreasure(int treasure){
      //build a list of items that dropped
      ArrayList<Item> lootItems = new ArrayList<Item>();
      //number of basic items
      int basic = treasure % 10;
      //advanced items
      int advanced = treasure / 10 % 10;
      //epic items
      int epic = treasure / 100 % 10;
      //setup the basic items
      for(int i = 0; i < basic; i++){
         lootItems.add(g_loot.getBasic(g_player));
      }
      //setup the advanced items
      for(int i = 0; i < advanced; i++){
         lootItems.add(g_loot.getAdvanced(g_player));
      }
      //setup the epic items
      for(int i = 0; i < epic; i++){
         lootItems.add(g_loot.getEpic(g_player));
      } 
            
      if(lootItems.size() > 0){ 
         //print a list of the items
         System.out.println();
         System.out.println("***************");
         System.out.println("Treasure Items");
         System.out.println("**************");
         for(Item i : lootItems){
            System.out.println(i.uniqueID + " " + i.name);
         }
         System.out.println();
         //ask the user whether they want to (S)ell items or (K)eep items
         boolean validResponse = false;
         String response = "";
         while(!response.equals("S") && !response.equals("K")){
            System.out.println("Do you want to (S)ell or (K)eep the items (duplicates will be added to your current weapons): ");
            response = getResponse();
         }
         //sell
         if(response.equals("S")){
            for(Item i: lootItems){
               g_player.gold += i.price / 10;
            }
            System.out.println("You wisely sell the items");
         } 
         else {
            //put items in inventory (upgrade if duplicate)
            for(Item i: lootItems){
               g_player.gold +=  g_player.inventory.add(i);
            }
            System.out.println("      ____   ");
            System.out.println("  .--[[__]]---.   ");
            System.out.println(" ;-----------.|   ");
            System.out.println(" |           ||   ");
            System.out.println(" |           ||   ");
            System.out.println(" |___________|/   ");
            System.out.println("You wisely put the items in your backpack.");
         }
         
      }            
   }
   
   //getlevelUp - rolls random treasure and allows the user to take it (or convert to money)
   //@param int levelUp (1s are basic, 10s are advanced, 100s are epic treasure)
   public static void getlevelUp(int treasure){
      //build a list of items that dropped
      ArrayList<Item> lootItems = new ArrayList<Item>();
      //number of basic items
      int basic = treasure % 10;
      //advanced items
      int advanced = treasure / 10 % 10;
      //epic items
      int epic = treasure / 100 % 10;
      //setup the basic items
      for(int i = 0; i < basic; i++){
         lootItems.add(g_loot.getBasic(g_player));
      }
      //setup the advanced items
      for(int i = 0; i < advanced; i++){
         lootItems.add(g_loot.getAdvanced(g_player));
      }
      //setup the epic items
      for(int i = 0; i < epic; i++){
         lootItems.add(g_loot.getEpic(g_player));
      } 
            
      if(lootItems.size() > 0){ 
         //print a list of the items
         System.out.println("***************");
         System.out.println("!$!Level " + g_player.level + " Rewards!$!");
         System.out.println("LEVEL UP Items");
         System.out.println("**************");
         for(Item i : lootItems){
            System.out.println(i.uniqueID + " " + i.name);
         }
         System.out.println();
         //ask the user whether they want to (S)ell items or (K)eep items
         boolean validResponse = false;
         String response = "";
         while(!response.equals("S") && !response.equals("K")){
            System.out.println("Do you want to (S)ell or (K)eep the items (duplicates will be added to better your current weapons.): ");
            response = getResponse();
         }
         //sell
         if(response.equals("S")){
            for(Item i: lootItems){
               g_player.gold += i.price / 10;
            }
            System.out.println("You wisely sell the items");
         } 
         else {
            //put items in inventory (sell if duplicate)q
            for(Item i: lootItems){
               g_player.gold +=  g_player.inventory.add(i);
            }
            System.out.println("      ____   ");
            System.out.println("  .--[[__]]---.   ");
            System.out.println(" ;-----------.|   ");
            System.out.println(" |           ||   ");
            System.out.println(" |           ||   ");
            System.out.println(" |___________|/   ");
            System.out.println("You wisely put the items in your backpack.");            
         }
         
      }            
   }
   
   /*
   public static boolean darkRoom(Scanner input){
      System.out.println("You have reached a room that is pitch black.");
      System.out.prinln("          .----------.          ");
      System.out.prinln("          |   ~ON~   |          ");
      System.out.prinln("          |   ____   |          ");
      System.out.prinln("          |  |.--.|  |          ");
      System.out.prinln("          |  ||  ||  |          ");
      System.out.prinln("          |  ||__||  |          ");
      System.out.prinln("          |  ||\ \|  |          ");
      System.out.prinln("          |  |\ \_\  |          ");
      System.out.prinln("          |  |_\[_]  |          ");
      System.out.prinln("          |          |          ");
      System.out.prinln("          |  ~OFF~   |          ");
      System.out.prinln("          '----------'          ");
      String response = "";
      do{
         System.out.print("Do you want to turn on the (L)ight, or (F)lee?");
         response = getResponse();
         if(response.equals("L")){
            return false;
         }
      }while(!response.equals("F"));
         return true;      
   }//close Dark Room
   */
   
   //exit room --> asks the user wether or not they want to exit the dungeon. if they say No... keep going... otherwise exit game
   //    prints total money collected and congratulates whnen they exit
   //@param --> input .. scaner to player input
   //@return --> false = quit game, true = keep going
   public static boolean exitRoom(Scanner input){
      System.out.println("                    [] ");
      System.out.println("   _______________  []         _______________  ");
      System.out.println("   _______________) []        (_______________  ");
      System.out.println("    !     !     !   []       ,!  !     !     !  ");
      System.out.println("    !     !     !   []      ! !  !     !     !  ");
      System.out.println("    !_____!_____!___[]_____'!_!__!_____!_____!  ");
      System.out.println("                    []__,_!_!_!  ");
      System.out.println("                    []_!__!_!|  ");
      System.out.println("                   ,[]_!__!_!  ");
      System.out.println("                 ,! []_!__!|  ");
      System.out.println("               ,! ! []_!__!  ");
      System.out.println("              ! ! ! []_!|  ");
      System.out.println("             !! ! !|[]_|  ");
      System.out.println("             !!!._|_[]  ");
      System.out.println("             !!!|!_.[]  ");
      System.out.println("             !|!_!__[]!.  ");
      System.out.println("             !_!_!__[]! !.  ");
      System.out.println("             !_!_!__[]! ! `.  ");
      System.out.println("              |!_!__|]! ! ! `.  ");
      System.out.println("               |_!__|]! ! ! ! `.  ");
      System.out.println("                 |____|_! ! ! !  `  ");
      System.out.println("                   |____|_! ! ! !  ");
      System.out.println("                    []____|_! ! !  ");
      System.out.println("                    []______|_! !  ");
      System.out.println("                    []________|_!  ");
      System.out.println("__________________[]__________|_____________  ");
      System.out.println();
      System.out.println();
      System.out.println("You have reached a room with a staircase that seems to leave the dungeon.");
      String response = "";
      do{
         System.out.print("Do you want to (L)eave with your treasure or (S)tay and keep adventuring?");
         response = getResponse();
         if(response.equals("L")){
            return false;
         }
      }while(!response.equals("S"));
         return true;      
   }//close exit room

  
} //end class
