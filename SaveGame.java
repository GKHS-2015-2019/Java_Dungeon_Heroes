import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.util.TreeMap;
import java.util.Map;

public class SaveGame{
      
   //saves a player
   public static void save(Player p, String fileName) throws FileNotFoundException{
      try{
         File file = new File(fileName);
         PrintStream stream = new PrintStream(file);
         //save the player name
         stream.println(p.name);
         //save the playerClass
         stream.println(p.characterClass);
         //save the level
         stream.println(p.level);
         //save the experience
         stream.println(p.xp);
         //save the food
         stream.println(p.food);
         //save the gold
         stream.println(p.gold);
         //save a list of the items
         for(Map.Entry<Integer, Item> entry : p.inventory.itemList.entrySet()){
            stream.print(entry.getKey() + " ");
         }
         stream.println();
          //save a list of the equipped items
         for(Map.Entry<Integer, Item> entry : p.inventory.itemList.entrySet()){
            if(entry.getValue().equipped ){
               stream.print(entry.getKey() + " ");
            }
         
         }
      } 
      catch (FileNotFoundException e){
         throw new FileNotFoundException();
      }        
   }
   
   public static Player load(String fileName) throws FileNotFoundException{
      try{
         File file = new File(fileName);
         Scanner input = new Scanner(file);
         //read the player name
         String name = input.nextLine();
         //read the player class
         String characterClass = input.nextLine();
         //make the player
         Player p = new Player(name, characterClass);
         //Load  the level
         int level = input.nextInt();
         for(int i = 1; i < level; i++){
            p.giveXP(100000000);
         }
         //load the current xp
         int xp = input.nextInt();
         p.giveXP(xp);
         //load the food
         int food = input.nextInt();
         p.giveFood(food);
         //load the gold
         int gold = input.nextInt();
         p.giveGold(gold);
         
         //Initialize a loot list
         Loot L = new Loot();
         
         //Get a list of items add them to the player's inventory
         String itemString = "";
         input.nextLine();
         if(input.hasNextLine()){
            itemString = input.nextLine();
         }
         Scanner items = new Scanner(itemString);
         while(items.hasNextInt()){
            int uniqueID = items.nextInt();
            p.inventory.add(L.getItem(uniqueID));
         }
         //equip items
         String equippedString = "";
         if(input.hasNextLine()){
            equippedString = input.nextLine();
         }
         Scanner equipped = new Scanner(equippedString);
         while(equipped.hasNextInt()){
            int uniqueID = equipped.nextInt();
            p.inventory.equip(uniqueID, p);
         }
         p.inventory.list();
      
         return p;
      } 
      catch (FileNotFoundException e){
         throw new FileNotFoundException();
      }   
          
       
   }

}