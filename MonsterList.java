import java.util.ArrayList;
import java.util.Random;


//MonsterList: Defines monsters and randomlu selects them



public class MonsterList {
   private ArrayList<monster> monsters; //the list of all possible monster in the game
   
   //getMonster ==> returns a random monster from our list
   public monster getMonster() {
      //get a random number between 0 & the size of the list
      Random rand = new Random();
      int result = rand.nextInt(monsters.size());
      
      //return the monster
      return monsters.get(result);
    
   } 
   
   //constructor (constructs the list of monsters)
   public MonsterList(){
      monsters = new ArrayList();
      addGiantRat();
      addCyclops();
      addUnicorn();
      addDragon();
      addBigFoot();
      addIt();
      addBabyGodzilla();
   }
   
   //adds a Giant Rat Monster
   private void addGiantRat(){
      String name = "Giant Rat";
      String desc = "A foul rat rears up before. It is as big as a small child. It looks at you with hunger in its eyes.";
      String attackDesc = "bites";
      
      int health = 5;
      int attack = 8;
      int damage = 2;
      int defense = 10;
      int protection = 1;
      int speed = 12;
      
      int xp = 10;
      int gold = 5;
      int food = 50;
      int basic = 1;
      int advanced = 0;
      int epic = 0;
      
      monster temp = new monster(name, desc, attackDesc,
         health, attack, damage, defense, protection, speed,
         xp, gold, food, basic, advanced, epic);
         
      monsters.add(temp);
   }
   
   //adds a Cyclops
   private void addCyclops(){
      String name = "Cyclops";
      String desc = "A twenty foot tall giant peers mecingly at you with his single large eye.";
      String attackDesc = "swings his hammer at";
      
      int health = 20;
      int attack = 6;
      int damage = 7;
      int defense = 6;
      int protection = 10;
      int speed = -5;
      
      int xp = 300;
      int gold = 2000;
      int food = 1000;
      int basic = 0;
      int advanced = 1;
      int epic = 1;
      
      monster temp = new monster(name, desc, attackDesc,
         health, attack, damage, defense, protection, speed,
         xp, gold, food, basic, advanced, epic);
         
      //adds to the list   
      monsters.add(temp);
   }

      //adds a Unicorn
   private void addUnicorn(){
      String name = "Unicorn";
      String desc = "You see something sparkling and beautiful. It nuzzles up to you and you start to trust it, but it's deadly.";
      String attackDesc = "stabs you with its horn";
      
      int health = 10;
      int attack = 9;
      int damage = 10;
      int defense = 5;
      int protection = 10;
      int speed = 7;
      
      int xp = 400;
      int gold = 5000;
      int food = 200;
      int basic = 1;
      int advanced = 0;
      int epic = 2;
      
      monster temp = new monster(name, desc, attackDesc,
         health, attack, damage, defense, protection, speed,
         xp, gold, food, basic, advanced, epic);
         
      monsters.add(temp);
   }
      
         //adds a Dragon
   private void addDragon(){
      String name = "Dragon";
      String desc = "A huge flame barely misses your face! You feel the heat of the fire and realize how deadly the beast is.";
      String attackDesc = "burns you";
      
      int health = 35;
      int attack = 9;
      int damage = 20;
      int defense = 40;
      int protection = 4;
      int speed = -2;
      
      int xp = 100;
      int gold = 3000;
      int food = 200;
      int basic = 1;
      int advanced = 1;
      int epic = 1;
      
      monster temp = new monster(name, desc, attackDesc,
         health, attack, damage, defense, protection, speed,
         xp, gold, food, basic, advanced, epic);
         
      monsters.add(temp);
   }
         //adds a Big Foot Monster
   private void addBigFoot(){
      String name = "Big Foot";
      String desc = "A giant, fuzzy, 8 foot man-looking beast stomps its way up to you. It looks giant.";
      String attackDesc = "jumps and tackles you";
      
      int health = 5;
      int attack = 15;
      int damage = 5;
      int defense = 4;
      int protection = 10;
      int speed = 9;
      
      int xp =  4000;
      int gold = 200;
      int food = 50;
      int basic = 1;
      int advanced = 1;
      int epic = 0;
      
      monster temp = new monster(name, desc, attackDesc,
         health, attack, damage, defense, protection, speed,
         xp, gold, food, basic, advanced, epic);
         
      monsters.add(temp);
   }
      //adds an It Monster
   private void addIt(){
      String name = "It";
      String desc = "You hear circus music, and the room is foggy. All you can see is big clown shoes, a big clown nose, and a white painted face with bulging eyes.";
      String attackDesc = "kidnaps you";
      
      int health = 30;
      int attack = 8;
      int damage = 10;
      int defense = 10;
      int protection = 2;
      int speed = 12;
      
      int xp = 50;
      int gold = 500;
      int food = 5000;
      int basic = 4;
      int advanced = 0;
      int epic = 0;
      
      monster temp = new monster(name, desc, attackDesc,
         health, attack, damage, defense, protection, speed,
         xp, gold, food, basic, advanced, epic);
         
      monsters.add(temp);
   }
      //adds a Baby Godzilla Monster
   private void addBabyGodzilla(){
      String name = "Baby Godzilla";
      String desc = "A cute looking lizard baby comes up to you. It's as big as you, and its roar is as loud as a plane engine, but yet you still like it.";
      String attackDesc = "scratches";
      
      int health = 5;
      int attack = 15;
      int damage = 4;
      int defense = 50;
      int protection = 8;
      int speed = 2;
      
      int xp = 1000;
      int gold = 400;
      int food = 50;
      int basic = 1;
      int advanced = 0;
      int epic = 2;
      
      monster temp = new monster(name, desc, attackDesc,
         health, attack, damage, defense, protection, speed,
         xp, gold, food, basic, advanced, epic);
         
      monsters.add(temp);
   }

}