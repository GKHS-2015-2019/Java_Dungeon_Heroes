public class monster {
   //fileds
   public String name; //monster's name
   public String desc; //the monster's description
   public String attackDesc; //Description of the attack
   
   //basic fields
   public int health; //hp
   public int attack; //monster attack value
   public int damage; // damage monster does
   public int defense; //monsters dodge value
   public int protection; //the monster's armor
   public int speed; //Can the monster cathch the player?
   
   //treasure fields
   public int xp; //the amount of xp the monster gives
   public int gold; //the amount of gold they can drop (max)
   public int food; //how many food maximum the monster drops (0 - food) food
   public int basic; // how many basic treasures the monster drops
   public int advanced; //how many advanced treasures the monster drops
   public int epic; //how many epic treasures the monster drops

   //constructor
   public monster(String name,String desc, String attackDesc,
      int health, int attack, int damage, int defense, int protection, int speed,
      int xp, int gold, int food, int basic, int advanced, int epic) {
      this.name = name;
      this.desc = desc;
      this.attackDesc = attackDesc;
      
      this.health = health;
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
   
}