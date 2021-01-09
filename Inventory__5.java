import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory{
   Map<Integer, Item> itemList;
   
   //constructor
   public Inventory(){
      itemList = new TreeMap<Integer,Item>();
      
   }
   
   //add an item
   //returns the cost / 10 if they already have it
   public int add(Item item){
      if(itemList.containsKey(item.uniqueID)){
          //if they already have the item... refund it
         return item.price / 10;
      } 
      else{
         //add the item
         itemList.put(item.uniqueID, item);
      }
      return 0;
   }
   
   
   

   
   //checkInventory --> Allows the user to check inventory and handle items
   public void handleInventory(Scanner input, Player p){
      String response = "";
      while(!response.equals("C")){   
         System.out.println();         
         System.out.print("Choose One: (L)ist your items, E(x)amine an item, (S)ell an Item, (E)quip an item,"
            + "\n (U)nequip an item, or (C)lose backpack) ");
         response = getResponse(input);
         //list items
         if(response.equals("L")){
            list();   
         }
         if(response.equals("X")){
            examine(input);
         }
         if(response.equals("S")){
            p.gold += remove(input);
         }
         if(response.equals("E")){
            equip(input, p);
         }
         if(response.equals("U")){
            unequip(input, p);
         }
      }
   }
   
   //list --> Lists the items in the inventory
   public void list(){
      System.out.println();
      //loop through inventory items
      System.out.println("Item Num\tName");
      System.out.println("************************");
      for(Map.Entry<Integer, Item> entry : itemList.entrySet()){
         //print the item number and value
         System.out.print(entry.getKey() + "\t " + entry.getValue().name);
         //print if the item is equipped or not
         if(entry.getValue().equipped){
            System.out.print(" (Equipped)");
         }
         System.out.println();
      }
   }   
   
   //examines an item (prints the description)
   public void examine(int uniqueID){
      if(itemList.containsKey(uniqueID)){
         System.out.println();
         itemList.get(uniqueID).description();
      } 
      else {
         System.out.println("Unable to find object " + uniqueID);
      }
   }
   //prompts the user for an item to examine then examines it
   public void examine(Scanner input){
      System.out.print("Which item would you like to examine (Enter the item number): ");
      String response = input.next();
      //parse the number (and catch)
      try {
         int id = Integer.parseInt(response);
         examine(id);
      } 
      catch(NumberFormatException nfe){
         System.out.println("You must enter a valid number");
      }
   }
   
   //removes an item from the list based on its unique id and returns sell price / 10
   public int remove(int uniqueID){
      
      if(itemList.containsKey(uniqueID)){
         int sellPrice = itemList.get(uniqueID).price / 10;
         System.out.println("You sell the " + itemList.get(uniqueID).name + " for " + sellPrice + " gold.");
         itemList.remove(uniqueID);
         return sellPrice;
      } 
      else {
         System.out.println("Unable to find object " + uniqueID);
         return 0;
      }      
   }
   
   //Prompts the user for an item to remove then removes it
   public int remove(Scanner input){
      System.out.print("Which item would you like to remove (Enter the item number): ");
      String response = input.next();
      //parse the number (and catch)
      try {
         int id = Integer.parseInt(response);
         return remove(id);
      } 
      catch(NumberFormatException nfe){
         System.out.println("You must enter a valid number");
         return 0;
      }
   }
   
   
   //equips an item from the list based on its unique id
   public void equip(int uniqueID, Player p){
       //the item exists
      if(itemList.containsKey(uniqueID)){
         Item i = itemList.get(uniqueID);
         //if the item is equipped yell at user
         boolean equippable = true;
         if(i.equipped){
            System.out.println("The item is already equipped");
            equippable = false;
         } 
         else {
           //if another item of the same type is equipped yell at user
            for(Map.Entry<Integer, Item> entry : itemList.entrySet()){   
               if(entry.getValue().type.equals(i.type) && entry.getValue().equipped){
                  System.out.println("You alreay have an item of type " + i.type + ". Remove one first.");
                  equippable = false;
               }
            }
           //if the user doesn't have enough hands... yell at user
            if(i.hands > p.hands){
               System.out.println("You don't have enough hands remaining to use that object");
               equippable = false;
            }
           //equip the item
            if(equippable){
               System.out.println("You equip the " + i.name);
               i.equipped = true;
               p.hands -= i.hands;
               p.maxHealth += i.health;
               p.maxStamina += i.stamina;
               p.attack += i.attack;
               p.strength += i.strength;
               p.defense += i.defense;
               p.protection += i.protection;
               p.speed += i.speed;
            }
         }
      } 
      else {
         System.out.println("Unable to find object " + uniqueID);
      }         
   }
   
   //Prompts the user for an item to equip
   public void equip(Scanner input, Player p){
      System.out.print("Which item would you like to equip (Enter the item number): ");
      String response = input.next();
      //parse the number (and catch)
      try {
         int id = Integer.parseInt(response);
         equip(id, p);
      } 
      catch(NumberFormatException nfe){
         System.out.println("You must enter a valid number");
      }
   }
   
   //unequips an item from the list based on its unique id
   public void unequip(int uniqueID, Player p){
       //the item exists
      if(itemList.containsKey(uniqueID)){
         Item i = itemList.get(uniqueID);
         //if the item is not equipped yell at user
         boolean unequippable = true;
         if(!i.equipped){
            System.out.println("The item is already unequipped");         } 
         else {
           //unequip the item
               System.out.println("You remove the " + i.name);
               i.equipped = false;
               p.hands += i.hands;
               p.maxHealth -= i.health;
               p.health = Math.min(p.health, p.maxHealth);
               p.maxStamina -= i.stamina;
               p.stamina = Math.min(p.stamina, p.maxStamina);
               p.attack -= i.attack;
               p.strength -= i.strength;
               p.defense -= i.defense;
               p.protection -= i.protection;
               p.speed -= i.speed;
            
         }
      } 
      else {
         System.out.println("Unable to find object " + uniqueID);
      }         
   
   }
   
   //Prompts the user for an item to unequip
   public void unequip(Scanner input, Player p){
      System.out.print("Which item would you like to unequip (Enter the item number): ");
      String response = input.next();
      //parse the number (and catch)
      try {
         int id = Integer.parseInt(response);
         unequip(id, p);
      } 
      catch(NumberFormatException nfe){
         System.out.println("You must enter a valid number");
      }
   }


   //gets user input and returns a single capital character
   public static String getResponse(Scanner input){
      boolean validInput = false;
      String response = "";
      while(!validInput){
         response =input.nextLine().toUpperCase();
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