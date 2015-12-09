import java.util.ArrayList;
import java.util.Random;

//Loot class - stores lists of loot and returns random loot to the player
public class Loot{
   private ArrayList<Item> epicItems; //stores epic items
   private ArrayList<Item> advancedItems; //stored advanced items
   private ArrayList<Item> basicItems; //store basic items
   private Random rand; //random number generator
   
   //constructor
   public Loot(){
      //set up lists
      epicItems = new ArrayList<Item>();
      advancedItems = new ArrayList<Item>();
      basicItems = new ArrayList<Item>();
      rand = new Random();
     
   //LEVEL 1 - 5
   	//Weapons
   		//basic
      addBranch();
      addDagger();
   		//advanced
      addLongSword();
      //addIronSword();
   		//epic
      addClayMore();
      addFlamingSword();
   	//Armor
   		//basic
      addLeatherArmor();
   		//advanced
      addIronArmor();
   		//epic
      //addSteal();
      //Misc
   		//basic
   		
   		//advanced
   		
   		//epic
         
/*   //Level 5 - 10
   //Weapons
   	//basic
      addSabre();
      addFalchion();
   	//advanced
      addSmallMace();
      addLargeMace();
   	//epic
      addWarHammer();
   //Armor
   	//basic
      addGoldFlex();
   	//advanced
      addChainMail();
   	//epic
      addKevlar();
   //Misc
   	//basic
   	
   	//advanced
   	
   	//epic
      
   //Level 10 - 15
   	//Weapons
   		//basic
      addDualDagger();
   		//advanced
      addShortSword();
      addDualShortSword();
   		//epic
      addDualLongSword();
   	//Armor
   		//basic
      addDendraPanoply();
   		//advanced
      addDragonSkin();
   		//epic
      addScaleArmor();
   	//Misc
   		//basic
   		
   		//advanced
   		
   		//epic
         */
   }

   public Item getItem(int uniqueID){
      for(Item i: basicItems){
         if(i.uniqueID == uniqueID){
            return i;
         }
      }
      for(Item i: advancedItems){
         if(i.uniqueID == uniqueID){
            return i;
         }
      }
      for(Item i: epicItems){
         if(i.uniqueID == uniqueID){
            return i;
         }
      }
      return getItem(uniqueID);
   }
    
   public Item getEpic(Player p){
      boolean validLoot = false;
      int i = 0;
      
      while(!validLoot){
         i = rand.nextInt(epicItems.size());
         if(epicItems.get(i).findLevel <= p.level){
            validLoot = true;
         }
      }
      return epicItems.get(i);
   }
   public Item getAdvanced(Player p){
      boolean validLoot = false;
      int i = 0;
      
      while(!validLoot){
         i = rand.nextInt(advancedItems.size());
         if(advancedItems.get(i).findLevel <= p.level){
            validLoot = true;
         }
      }
      return advancedItems.get(i);
   }
   public Item getBasic(Player p){
      boolean validLoot = false;
      int i = 0;
      
      while(!validLoot){
         i = rand.nextInt(basicItems.size());
         if(basicItems.get(i).findLevel <= p.level){
            validLoot = true;
         }
      }
      return basicItems.get(i);
   }
   
//LEVEL 1 - 5
   //****Weapons****
      //---basic---
         public void addBranch(){
            String name = "Branch          "; // ends in 8... helps inventory
            String desc = "An old decaying branch";
            int uniqueID = 1;
            int price = 4;
            boolean useable = false;
               //equiping stats
            String type = "Weapon  ";
            int level = 1;
            int findLevel = 1;
            int hands = 1;
               //life status
            int health = 0;
            int stamina = 0;
               //attack stats
            int attack = 1;
            int strength = 1;
            int defense = 0;
            int protection = 0;
               //speed stats
            int speed = 0;
               
            Item tempItem = new Item(name, desc, uniqueID, price, type, level, findLevel, hands, health, stamina, attack, strength, defense, protection, speed);
            basicItems.add(tempItem);
         }//end Branch
            
         public void addDagger(){
            String name = "Dagger          "; // ends in 8... helps inventory
            String desc = "A rusty dagger that is reasonably sharp and might be more useful than your fist";
            int uniqueID = 2;
            int price = 10;
            boolean useable = false;
               //equiping stats
            String type = "Weapon  ";
            int level = 1;
            int findLevel = 2;
            int hands = 1;
               //life status
            int health = 0;
            int stamina = 0;
               //attack stats
            int attack = 2;
            int strength = 2;
            int defense = 0;
            int protection = 0;
               //speed stats
            int speed = 0;
               
            Item tempItem = new Item(name, desc, uniqueID, price, type, level, findLevel, hands, health, stamina, attack, strength, defense, protection, speed);
            basicItems.add(tempItem);
         }//end Dagger
         
      //---advanced---
         public void addLongSword(){
            String name = "Long Sword      ";
            String desc = "A finely polished steel longsword. It gleans in the tourchlight and is razor sharp.";
            int uniqueID = 101;
            int price = 100;
            boolean useable = true;
               //equiping stats
            String type = "Weapon  ";
            int level = 1;
            int findLevel = 2;
            int hands = 1;
               //life status
            int health = 0;
            int stamina = 0;
               //attack stats
            int attack = 3;
            int strength = 10;
            int defense = 2;
            int protection = 0;
               //speed stats
            int speed = 0;
               
            Item tempItem = new Item(name, desc, uniqueID, price, type, level, findLevel, hands, health, stamina, attack, strength, defense, protection, speed);
            advancedItems.add(tempItem);
         }//end long sword
         
      //---epic---
         public void addClayMore(){
            String name = "Clay More       "; // ends in 8... helps inventory
            String desc = "A brite SHINY new sword";
            int uniqueID = 201;
            int price = 600;
            boolean useable = false;
               //equiping stats
            String type = "Weapon  "; //ends in 8... helps inventory
            int level = 1;// what level the item is..
            int findLevel = 4;// what level you can find it on
            int hands = 1;
               //life status
            int health = 0;
            int stamina = 1;
               //attack stats
            int attack = 3;
            int strength = 10;
            int defense = 3;
            int protection = 0;
               //speed stats
            int speed = 0;
               
            Item tempItem = new Item(name, desc, uniqueID, price, type, level, findLevel, hands, health, stamina, attack, strength, defense, protection, speed);
            epicItems.add(tempItem);
         }//end ClayMore
         
         public void addFlamingSword(){
            String name = "Flaming Sword   ";
            String desc = "You pick up this sword and it bursts to flames like a furnace. Inside your head, you hear a voice syaing, " + 
                  "Hello, my name is BURNINAOR. Would you like to toast some enemies?";
            int uniqueID = 202;
            int price = 800;
            boolean useable = true;
               //equiping stats
            String type = "Weapon  ";
            int level = 1;
            int findLevel = 5;
            int hands = 1;
               //life status
            int health = 0;
            int stamina = 2;
               //attack stats
            int attack = 5;
            int strength = 20;
            int defense = 5;
            int protection = 0;
               //speed stats
            int speed = 0;
               
            Item tempItem = new Item(name, desc, uniqueID, price, type, level, findLevel, hands, health, stamina, attack, strength, defense, protection, speed);
            epicItems.add(tempItem);
         }//end flaming sword
         
   //****Armor****
      //---basic---
         public void addLeatherArmor(){
            String name = "Leather Armor   "; // ends in 8... helps inventory
            String desc = "A dirty leather shirt with iron rivets sewn into. It will stop a blade better than your skin.";
            int uniqueID = 51;
            int price = 20;
            boolean useable = false;
               //equiping stats
            String type = "body    ";
            int level = 1;
            int findLevel = 1;
            int hands = 0;
               //life status
            int health = 0;
            int stamina = 0;
               //attack stats
            int attack = 0;
            int strength = 0;
            int defense = 1;
            int protection = 2;
               //speed stats
            int speed = 0;
               
            Item tempItem = new Item(name, desc, uniqueID, price, type, level, findLevel, hands, health, stamina, attack, strength, defense, protection, speed);
            basicItems.add(tempItem);
         }//end leather armor
      //---advanced---
         public void addIronArmor(){
            String name = "Iron Armor      "; // ends in 8... helps inventory
            String desc = "An old rusty iron chestplate that is still intact slightly.";
            int uniqueID = 52;
            int price = 30;
            boolean useable = false;
               //equiping stats
            String type = "Armor   ";
            int level = 1;
            int findLevel = 3;
            int hands = 0;
               //life status
            int health = 0;
            int stamina = 0;
               //attack stats
            int attack = 0;
            int strength = 0;
            int defense = 4;
            int protection = 8;
               //speed stats
            int speed = 0;
               
            Item tempItem = new Item(name, desc, uniqueID, price, type, level, findLevel, hands, health, stamina, attack, strength, defense, protection, speed);
            basicItems.add(tempItem);
         }//end Iron Armor
      //---epic---
      
      //addSteal();
      
      //****Misc****
         //---basic---
         
         //---advanced---
         
         //---epic---
}