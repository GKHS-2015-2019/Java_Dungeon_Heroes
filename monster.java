public class Monster{
   //fields
   public String name; //the monster's name
   public String desc; //The monster's description
   public String attackDesc; //Description of the attack
   
   //basic fields
   public int level;// what is the minimum level the monster can spawn on 
   public int health; //hp
   public int curHealth; //Monsters current health
   public int attack; //monster attack value
   public int damage; //damage monster does
   public int defense; //monsters dodge value
   public int protection; //the monster's armor
   public int speed; //Can the monster catch the player?
   
   //treasure fields
   public int xp; //the amount of xp the monster gives
   public int gold; //the amount of gold they can drop (max)
   public int food; //how many food maximum the monster drops  (0 - food) food
   public int basic; //how many basic treasures the monster drops
   public int advanced; //how many advanced treasures the monster drops
   public int epic; //how many epic treasures the monster drops

   //constructor
   public Monster(String name, String desc, String attackDesc, int level,
      int health, int attack, int damage, int defense, int protection, int speed,
      int xp, int gold, int food, int basic, int advanced, int epic){
      this.name = name;
      this.desc = desc;
      this.attackDesc = attackDesc;
      
      this.level = level;
      this.health = health;
      this.curHealth = health;  //give monster max health
      this.attack = attack;
      this.damage = damage;
      this.defense = defense;
      this.protection = protection;
      this.speed = speed;
      
      this.xp = xp;
      this.gold = gold;
      this.food = food;
      this.basic = basic;
      this.advanced = advanced;
      this.epic = epic;
   }
   
   //singleAttack (Handles a single attack 
   //@param Dice dice --> a pointer to our dice
   //       Player p --> a pointer to the player
   //       String response --> the players response
   //@return --> true if player ran successfully, false if not
   public boolean singleAttack(Dice dice, Player p, String response){
      //is the player trying to flee?
      if(response.equals("F")){
         //did the player run successfully? (Monster + Player will have roll off)
         if(p.speed + dice.roll() > this.speed + dice.roll()){
            return true; //the player ran away
         } else {
            System.out.println();
            System.out.println("You could not run Away...");
            System.out.println();
            }
      } 
      else {
            //player is fighting
         int attack = p.attack; //copy the attack
         int strength = p.strength; //copy the players damage
            //is the player doing a strong attack?
         if(response.equals("S")){
               //does the player have enough stamina to make a strong attack?
            if(p.stamina > 25){
               p.stamina = p.stamina - 25;
               attack = attack + 5;
               strength = strength + 5;
            } 
            else {
               System.out.println();
               System.out.println("You are too tired to make a Strong attack");
               System.out.println();
            }
         } //end strong attack block
         
         //generate the player's attack
         //check to see if the player misses
         if(attack + dice.roll() < this.defense + dice.roll()){
            System.out.println("You swing and miss!");
         } else {
            int damage = strength + dice.roll() - this.protection - dice.roll();  //calculate damage
            if(damage <= 0){  //deflected off armor
               System.out.println("You hit but cause no damage :(");
            } else {
               //decrease monsters hit-points
               this.curHealth = this.curHealth - damage;
               //celebrate the hit!
               System.out.println("You attack the " + this.name + " and score a hit of " + damage + " damage. Monster's Health: ("
                  + this.curHealth + "/" + this.health + ")" );
            } //end damage calculation
         } //ends the hit / miss block
         
      } //closes running block
      
      //Monsters Attack
      int monsterAttack = this.attack + dice.roll() - p.defense - dice.roll();
      int monsterDamage = this.damage + dice.roll() - p.protection - dice.roll();
      //did the monster miss?
      if(monsterAttack < 0){
         System.out.println("The " + this.name + " " + this.attackDesc + " but misses.");
      } else {
         //did they do damage
         if(monsterDamage < 0){
            System.out.println("The " + this.name + " " + this.attackDesc + " but does no damage.");
         } else {
            //they did damage
            p.health = p.health - monsterDamage;
            System.out.println("The " + this.name + " " + this.attackDesc + " and does " + monsterDamage + " damage! Health Left: ("
               + p.health + "/" + p.maxHealth + ")");
         } //end the damage block
      } // end the hit block
                 
      return false;
   }
   
   //give gold --> returns the amount of gold the monster drops
   public int giveGold(){
      return (int)(Math.random()*this.gold);
   }
   
   //give food --> returns the amount of food the monster drops
   public int giveFood(){
      return (int) (Math.random()*this.food);
   }
   
   //returns the treasure randomly
   public int getTreasure(){
      int basic = (int) Math.round(Math.random()*this.basic);
      int advanced = (int)(Math.round(Math.random()*this.advanced)*10);
      int epic = (int) (Math.round(Math.random()*this.epic)*100);
      
      int treasure = basic + advanced + epic;
      return basic + advanced + epic;
   }

}