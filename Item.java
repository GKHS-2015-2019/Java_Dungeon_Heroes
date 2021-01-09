//Item class --> keeps track of items
public class Item{
   //item description
   public String name; //name of the item
   public String desc; //description of the item
   public int uniqueID; //unique id of the item
   public int price; //buy price of the item
   //equiping limitations
   public String type; //type of item i.e. armor, weapon, shield etc
   public int level = 1; // what level is the item
   public int findLevel = 1; // what level does it unlock on
   public int hands; //how many hands does this take to use?
   public boolean equipped;
   public boolean useable;
   //stat boosts what stats does the item boost?   
   //life stats
   public int health;
   public int stamina;
   //attack stats
   public int attack;
   public int strength;
   public int defense;
   public int protection;
   //running stats
   public int speed;
   
   
   //Constructor
   public Item(String name, String desc, int uniqueID, int price,
         String type, int level, int findLevel, int hands, int health, int stamina,
         int attack, int strength, int defense, int protection,
         int speed){
      //description stats
      this.name = name;
      this.desc = desc;
      this.uniqueID = uniqueID;
      this.price = price;
      this.useable = useable;
      //equiping stats
      this.type = type;
      this.level = level;
      this.findLevel = findLevel;
      this.hands = hands;
      this.equipped = false;
      //life stats
      this.health = health;
      this.stamina = stamina;
      //attack stats
      this.attack = attack;
      this.strength = strength;
      this.defense = defense;
      this.protection = protection;
      //speed stats
      this.speed = speed;    
      
   }
   //description --> Describes the current item to the user
   public void description(){
      System.out.println("**************** " + this.name + " ****************");
      System.out.println("* Description: " + this.desc);
      System.out.println("* Price: " + this.price);
      System.out.println("* Type: " + this.type);
      System.out.println("* Useable: " + this.useable);
      System.out.println("* level: " + this.level);
      System.out.println("* level unlocked on: " + this.findLevel);
      if(this.hands > 0){
         System.out.println("* Hands: " + this.hands);
      }
      if(this.health != 0){
         System.out.println("* Health: " + this.health);
      }
      if(this.stamina != 0){
         System.out.println("* Stamina: "+ this.stamina);
      }
      if(this.attack != 0){
         System.out.println("* Attack: "+ this.attack);
      }
      if(this.strength != 0){
         System.out.println("* Strength: "+ this.strength);
      }
      if(this.defense != 0){
         System.out.println("* Defense: "+ this.defense);
      }
      if(this.protection != 0){
         System.out.println("* Protection: "+ this.protection);
      }
      if(this.speed != 0){
         System.out.println("* Speeed: "+ this.speed);
      }
      System.out.println("************************************************");
   }

}