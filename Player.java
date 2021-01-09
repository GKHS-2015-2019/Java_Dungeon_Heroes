public class Player{
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
   public int level;
   public boolean levelUp;
   public int xp;
   
   //life attributes
   public int health;  //If this goes to 0, game over
   public int maxHealth;
   public int stamina; //used for special attacks
   public int maxStamina;
   public int food; //used to rest and regain health + stamina
   public int maxFood;
   public int gold; //amount of gold the player has
   
   //attack attributes
   public int attack;  //used to hit things
   public int strength; //added to weapon damage to do damage
   
   //defense attributes
   public int defense; //used to dodge
   public int protection; //used to soak damage
   
   //speed
   public int speed; //used to run away
   public int hands; //the number of hands the player has left to equip items
   
   //Inventory
   public Inventory inventory; //We will do this later

   
   //constructor (Creates a new player)
   public Player(String name, String characterClass){
      //basic stats
      this.name = name;
      this.characterClass = characterClass;
      this.level = 1;
      this.xp = 0;
      
      //life stats
      this.health = STARTING_HEALTH;
      this.maxHealth = this.health;
      this.stamina = STARTING_STAMINA;
      this.maxStamina = this.stamina;
      this.maxFood = STARTING_FOOD;
      this.food = this.maxFood;
      this.gold = 0;
      
      //attack attributes
      this.attack = STARTING_ATTACK;
      this.strength = STARTING_STRENGTH;
      
      //defense attributes
      this.defense = STARTING_DEFENSE;
      this.protection = STARTING_PROTECTION;
      
      //speed
      this.speed = STARTING_SPEED;
      
      //WARRIOR
      if(this.characterClass.equals("WARRIOR")){
         this.health += WARRIOR_HEALTH;
         this.maxHealth += WARRIOR_HEALTH;
         this.strength += WARRIOR_STRENGTH;
         this.protection += WARRIOR_PROTECTION;
      }
      
      //THIEF
      if(this.characterClass.equals("THIEF")){
         this.attack += THIEF_ATTACK;
         this.defense += THIEF_DEFENSE;
         this.speed += THIEF_SPEED;
      }
      
      this.hands = 2;
      this.inventory = new Inventory();
      
   }

   //status --> prints the status of the player
   public void status(){
      System.out.println();
      System.out.println("Name: " + this.name);
      System.out.println("Class: " + this.characterClass);
      System.out.println("Level: " + this.level);
      System.out.println("Experience: " + this.xp);
      System.out.println("Experience needed: " + (level * 10));
      System.out.println();
      System.out.println("Health: " + this.health + "/" + this.maxHealth);
      System.out.println("Stamina: " + this.stamina + "/" +this.maxStamina);
      System.out.println("Food: " + this.food + "/" + this.maxFood);
      System.out.println();
      System.out.println("Attack: " + this.attack);
      System.out.println("Strength: " + this.strength);
      System.out.println("Defense: " + this.defense);
      System.out.println("Armor: " + this.protection);
      System.out.println("Speed: " + this.speed);
      System.out.println();
   }
   
   //giveFood --> gives food to the player
   public void giveFood(int food){
      this.food = this.food + food;
      System.out.println("Food Looted: " + food + "! Total: " + this.food);
   }
   
   //giveGold --> gives gold to the player
   public void giveGold(int gold){
      this.gold = this.gold + gold;
      System.out.println("Gold Looted: " + gold + "! Total: " + this.gold);
   }
   
   //giveXP --> gives xp to the player
   public void giveXP(int xp){
      this.xp += xp;
      System.out.println("XP Gained: " + xp + "! Total: " + this.xp + " of " + level * 10);
      levelUp();
   }
   
   //levelUp -->levels up the player
   public void levelUp(){
      //do they have enough xp to level?
      if(this.xp >= level*10){         //level them up
         this.level++; //add one to level
         System.out.println("You become Level " + level + "!");
         this.xp = 0;  //set xp to zero
         this.attack++; //add one to attack
         this.defense++; //add one to defense
         this.speed--; //the player gets slower
         this.maxHealth = this.maxHealth + 2; //add 2 to max health
         this.health = this.maxHealth;// set health to max health
         this.levelUp = this.levelUp;//activates level up perks
      } //end level up block
   } //end level up function
   
   //rest --> handles resting (if enough food)
   public void rest(){
      //heal stamina first
      //do they have enough food?
      if(this.food >= (this.maxStamina - this.stamina)){
         this.food = this.food - (this.maxStamina - this.stamina);  //enough food to completely fill stamina
         this.stamina = this.maxStamina;
         System.out.println();
         System.out.println("You completely regain your stamina. STAMINA: " + this.stamina);  
      } else if(this.food > 0){
         this.stamina = this.stamina + this.food;
         this.food = 0;  //partially fill stamina
         System.out.println();
         System.out.println("You only have enough food to partially regain your stamina. STAMINA: " + this.stamina);
      } else {
         System.out.println();
         System.out.println("You are out of food and cannot regain stamina. STAMINA: " + this.stamina);
      }
      
      //heal health
      if(this.food >= (this.maxHealth - this.health) * 10){
        this.food = this.food - (this.maxHealth - this.health) * 10;  //enough food to completely heal
        this.health = this.maxHealth;
        System.out.println();
        System.out.println("You completely heal up! HEALTH: " + this.health);
      } else if(this.food > 0){
        this.health = this.health + this.food / 10;
        this.food = 0;
        System.out.println();
        System.out.println("You only have enough food to partially restore your health. HEALTH: " + this.health);
      } else {
        System.out.println();
        System.out.println("You are out of food and cannot regain health. HEALTH: " + this.health);
      }
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
      System.out.println("Food remaining: " + this.food);
   }

} // end class