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
     
      //Level 1 Items
         //basic Items
         
            //weapons
      addDagger(); //#1 lev : 1
      addBranch(); //#2 lev : 1
            //armor
      addLeatherArmor(); //#51 lev : 1
      addIronArmor(); //#52 lev : 4
            //potions/useables
               
         //advanced Items
         
            //weapons
      addLongSword(); //#101 lev : 3
            //armor
               
            //potions/useables
            
         //epic Items
         
            //weapons
      addFlamingSword(); //#201 lev : 8
            //armor
               
            //potions/useables   
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
   
//basic items
   //WEAPON
      //dagger #1
   public void addDagger(){
      String name = "Dagger          ";
      String desc = "A rusty dagger that is reasonably sharp and might be more useful than your fist";
      int uniqueID = 1;
      int price = 10;
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
      int attack = 2;
      int strength = 2;
      int defense = 0;
      int protection = 0;
         //speed stats
      int speed = 0;
         
      Item tempItem = new Item(name, desc, uniqueID, price, type, level, findLevel, hands, health, stamina, attack, strength, defense, protection, speed);
      basicItems.add(tempItem);
   }//end dagger
      
      //wooden branch #3
   public void addBranch(){
      String name = "Branch          ";
      String desc = "Am old decaying branch";
      int uniqueID = 2;
      int price = 6;
      boolean useable = true;
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
      
   //ARMOR
      //leatherArmor #51
   public void addLeatherArmor(){
      String name = "Leather Armor   ";
      String desc = "A dirty leather shirt with iron rivets sewn into. It will stop a blade better than your skin.";
      int uniqueID = 51;
      int price = 20;
      boolean useable = true;
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
      
      //Iron Armor #52
   public void addIronArmor(){
      String name = "Iron Armor      ";
      String desc = "An old rusty iron chestplate that is mostly still intact.";
      int uniqueID = 52;
      int price = 15;
      boolean useable = true;
         //equiping stats
      String type = "Armor   ";
      int level = 1;
      int findLevel = 4;
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
      
//advanced items
   //WEAPON
      //longSword #101
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
      basicItems.add(tempItem);
   }//end long sword
      
      //Iron Sword #102
   public void addIronSowrd(){
      String name = "Iron Sword      ";
      String desc = "A rusty old Sword that is bloody sharp, It will defenitaly be more useful than your fist";
      int uniqueID = 102;
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
      int attack = 6;
      int strength = 8;
      int defense = 0;
      int protection = 0;
         //speed stats
      int speed = 0;
         
      Item tempItem = new Item(name, desc, uniqueID, price, type, level, findLevel, hands, health, stamina, attack, strength, defense, protection, speed);
      basicItems.add(tempItem);
   }//end Iron Dagger
         
   //ARMOR
     
//epiic items
   //WEAPON 
      //flaming Sword #201
   public void addFlamingSword(){
      String name = "Flaming Sword   ";
      String desc = "You pick up this sword and it bursts to flames like a furnace. Inside your head, you hear a voice syaing, " + 
            "Hello, my name is BURNINAOR. Would you like to toast some enemies?";
      int uniqueID = 201;
      int price = 1000;
      boolean useable = true;
         //equiping stats
      String type = "Weapon  ";
      int level = 1;
      int findLevel = 8;
      int hands = 1;
         //life status
      int health = 0;
      int stamina = 10;
         //attack stats
      int attack = 5;
      int strength = 20;
      int defense = 5;
      int protection = 0;
         //speed stats
      int speed = 0;
         
      Item tempItem = new Item(name, desc, uniqueID, price, type, level, findLevel, hands, health, stamina, attack, strength, defense, protection, speed);
      basicItems.add(tempItem);
   }//end flaming sword
      
   //ARMOR
   
}