public class Player {
   //constants
   public static final int STARTING_FOOD = 100;
   public static final int STARTING_STAMINA = 100;
   public static final int STARTING_HEALTH = 10;
   public static final int STARTING_ATTACK = 10;
   public static final int STARTING_STRENGTH = 1;
   public static final int STARTING_DEFENSE = 10;
   public static final int STARTING_PROTECTION = 1;
   public static final int STARTING_SPEED = 10;
   
   //warrior constants
   public static final int WARRIOR_HEALTH = 10;
   public static final int WARRIOR_STRENGTH = 2;
   public static final int WARRIOR_PROTECTION = 2;
   
   //thief constants
   public static final int THIEF_ATTACK = 2;
   public static final int THIEF_DEFENSE = 2;
   public static final int THIEF_SPEED = 2;
   

   //Attributes (fields)
   //Main Attributes
   public String name;
   public String characterClass;
   public int xp;
   public int level;
   
   //life attributes
   public int health; //If this goes to 0, game over
   public int maxHealth;
   public int stamina; //used for special attacks
   public int maxStamina;
   public int food; //used to rest and regain health + stamina
   public int maxFood;
   
   //attack attributes
   public int attack; //used to hit things
   public int strength; // added to weapon damage to do damage
   
   //defense attributes
   public int defense; //used to dodge
   public int protection; //used to soak damage
   
   //speed
   public int speed; //used to run away
   
   //Inventory
   //public Inventory inventory; //We will do this later
   
   //constructor (Creates a new player)
   public Player(String name, String characterClass) {
      this.name = name;
      this.characterClass = characterClass;
      this.level = 0;
      this.xp = 0;
      
      //life stats
      this.health = STARTING_HEALTH;
      this.maxHealth = this.health;
      this.stamina = STARTING_STAMINA;
      this.maxStamina = this.stamina;
      this.maxFood = STARTING_FOOD;
      this.food = this.maxFood;
   
      //attack attributes
      this.attack = STARTING_ATTACK;
      this.strength = STARTING_STRENGTH;
      
      //defense attributes
      this.defense = STARTING_DEFENSE;
      this.protection = STARTING_PROTECTION;
      
      //speed
      this.speed = STARTING_SPEED;
      
      //warrior
      if(this.characterClass.equals("WARRIOR")){
         this.health += WARRIOR_HEALTH;
         this.maxHealth += WARRIOR_HEALTH;
         this.strength += WARRIOR_STRENGTH;
         this.protection += WARRIOR_PROTECTION;
      }
      
      //thief
      if(this.characterClass.equals("THIEF")) {
         this.attack += THIEF_ATTACK;
         this.defense += THIEF_DEFENSE;
         this.speed += THIEF_SPEED;
      }
      
   }
   
   //status --> print the status of the player
   public void status() {
      System.out.println("Name: " + this.name);
      System.out.println("Class: " + this.characterClass);
      System.out.println("Level: " + this.level);
      System.out.println("Experience: " + this.xp);
      System.out.println();
      System.out.println("Health: " + this.health + "/" + this.maxHealth);
      System.out.println("Stamina: " + this.stamina + "/" + this.maxStamina);
      System.out.println("Food: " + this.food + "/" + this.maxFood);
      System.out.println();
      System.out.println("Attack: " + this.attack);
      System.out.println("Stength: " + this.strength);
      System.out.println("Defense: " + this.defense);
      System.out.println("Armor: " + this.protection);
      System.out.println("Speed: " + this.speed);
      
      
   }  


}