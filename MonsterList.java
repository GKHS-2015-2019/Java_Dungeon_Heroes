import java.util.ArrayList;
import java.util.Random;
//MonsterList: defines monsters and randomly sleects them

public class MonsterList{
   private ArrayList<Monster> monsters;//the list of all possible monsters in the game
   public static Player g_player;
   
   //getmonster --> returns a random monster form are list
   public Monster getMonster(Player p){
      
      boolean validMonster = false;
      int result  = 0;
      Random rand = new Random();
      
      while(!validMonster){
           result = rand.nextInt(monsters.size());
           if(monsters.get(result).level <= p.level){
             validMonster = true;
           }
      }
      
      //return the monster
      return monsters.get(result);
   }

   //constructor (cunstructs the  list of monsters)
   public MonsterList(){
      monsters = new ArrayList();
      addGiantRat();
      addCyclops();
      addAngry_Zombie();
      addFast_Zombie();
      addZombie();
      addDragon();
      addBaby_Dragon();
      addUnicorn();
      addTinyBat();
      addGiantSpider();
         
   }
   
   //adds a Giant Rat monster
   private void addGiantRat(){
      String name = "Giant Rat";
      String desc = "A foul rat, as big as a small child reares up before you. it looks at you with hunger in it eyes." +
      "\n    __       __  "+
      "\n   /  \\_____/  \\  "+
      "\n   | o       o |  "+
      "\n    \\ (o) (o) /  "+
      "\n     _| ___ |_  "+
      "\n    / | ___ | \\  "+
      "\n    | \\     / |  "+
      "\n  ===== () =====  "+
      "\n / ||        || \\  "+
      "\n/   \\\\      //   \\  "+
      "\n|    ^^    ^^    |  "+
      "\n\\                /  "+
      "\n \\  _________   /==============-----  "+
      "\n ///         \\\\\\  ";
      String attackDesc = "bites You";
      
      int level = 1;
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
      
      Monster temp = new Monster(name, desc, attackDesc, level,
         health, attack, damage, defense, protection, speed,
         xp, gold, food, basic, advanced, epic);
     
     //adds to list    
      monsters.add(temp);
   }
   
   //adds a MicroScopic Bat monster
   private void addTinyBat(){
      String name = "Tiny Bat";
      String desc = "A microscopic bat, as small as a grain of salt reares down befor you. it looks at you with hunger in it eyes." +
      "\n   /(    )\\   " +
      "\n  |  -^^-  |  " +
      "\n   \\_ `' _/   " +
      "\n     \\  )     " +
      "\n      )/      " +
      "\n     ('       ";
      String attackDesc = "bites You";
      
      int level = 1;
      int health = 5;
      int attack = 5;
      int damage = 1;
      int defense = 8;
      int protection = 1;
      int speed = 16;
      
      int xp = 10;
      int gold = 5;
      int food = 50;
      int basic = 1;
      int advanced = 0;
      int epic = 0;
      
      Monster temp = new Monster(name, desc, attackDesc, level,
         health, attack, damage, defense, protection, speed,
         xp, gold, food, basic, advanced, epic);
     
     //adds to list    
      monsters.add(temp);
   }
   
   //adds a Gaint Spider monster
   private void addGiantSpider(){
      String name = "Giant Spider";
      String desc = "A hidious Spider, as big as a small child reares up befor you. it looks at you with hunger in it eyes.";
      String attackDesc = "bites You";
      
      int level = 1;
      int health = 10;
      int attack = 10;
      int damage = 5;
      int defense = 8;
      int protection = 4;
      int speed = 8;
      
      int xp = 30;
      int gold = 15;
      int food = 100;
      int basic = 2;
      int advanced = 0;
      int epic = 0;
      
      Monster temp = new Monster(name, desc, attackDesc, level,
         health, attack, damage, defense, protection, speed,
         xp, gold, food, basic, advanced, epic);
     
     //adds to list    
      monsters.add(temp);
   }
   
   //adds a Cyclops monster
   private void addCyclops(){
      String name = "Cyclops";
      String desc = "A twenty foot tall gaint peers menacingly at you with his single large eye.";
      String attackDesc = "swings his hammer at you";
      
      int level = 10;
      int health = 50;
      int attack = 18;
      int damage = 20;
      int defense = 8;
      int protection = 15;
      int speed = -5;
      
      int xp = 300;
      int gold = 2000;
      int food = 1000;
      int basic = 0;
      int advanced = 1;
      int epic = 1;
      
      Monster temp = new Monster(name, desc, attackDesc, level,
         health, attack, damage, defense, protection, speed,
         xp, gold, food, basic, advanced, epic);
     
     //add list    
      monsters.add(temp);
   }
   //adds an Angry_Zombie monster
   private void addAngry_Zombie(){
      String name = "Angry Zombie";
      String desc = "A Once Living person got lost in this dungeon with firends that anggered him and he has been wondering around looking for BRAINS!!";
      String attackDesc = "Swings Branch at you";
      
      int level = 4;
      int health = 35;
      int attack = 20;
      int damage = 12;
      int defense = 10;
      int protection = 2;
      int speed = 5;
      
      int xp = 150;
      int gold = 150;
      int food = 10;
      int basic = 2;
      int advanced = 2;
      int epic = 0;
      
      Monster temp = new Monster(name, desc, attackDesc, level,
         health, attack, damage, defense, protection, speed,
         xp, gold, food, basic, advanced, epic);
     
     //add list    
      monsters.add(temp);
   }
   //adds a Zombie monster
   private void addZombie(){
      String name = "Zombie";
      String desc = "A Once Living person got lost in this dungeon and has been wondering around looking for BRAINS!!";
      String attackDesc = "swings his arms at you";
      
      int level = 2;
      int health = 20;
      int attack = 10;
      int damage = 5;
      int defense = 5;
      int protection = 2;
      int speed = 5;
      
      int xp = 150;
      int gold = 100;
      int food = 10;
      int basic = 3;
      int advanced = 1;
      int epic = 0;
      
      Monster temp = new Monster(name, desc, attackDesc,level,
         health, attack, damage, defense, protection, speed,
         xp, gold, food, basic, advanced, epic);
     
     //add list    
      monsters.add(temp);
   }
   //adds a Fast_Zombie monster
   private void addFast_Zombie(){
      String name = "Fast Zombie";
      String desc = "A Once Living athlete got lost in this dungeon and has been wondering around looking for BRAINS!!";
      String attackDesc = "swings his arms at you";
      
      int level = 3;
      int health = 20;
      int attack = 5;
      int damage = 5;
      int defense = 5;
      int protection = 5;
      int speed = 20;
      
      int xp = 50;
      int gold = 100;
      int food = 10;
      int basic = 3;
      int advanced = 1;
      int epic = 0;
      
      Monster temp = new Monster(name, desc, attackDesc, level,
         health, attack, damage, defense, protection, speed,
         xp, gold, food, basic, advanced, epic);
     
     //add list    
      monsters.add(temp);
   }
   //adds a Dragon monster
   private void addDragon(){
      String name = "Dragon";
      String desc = "This mystical creature is asleep... it awakens will you be burnt to a crisp!!";
      String attackDesc = "Blows Fire at you";
      
      int level = 15;
      int health = 400;
      int attack = 200;
      int damage = 170;
      int defense = 150;
      int protection = 60;
      int speed = 0;
      
      int xp = 3000;
      int gold = 1000;
      int food = 160;
      int basic = 1;
      int advanced = 2;
      int epic = 5;
      
      Monster temp = new Monster(name, desc, attackDesc, level,
         health, attack, damage, defense, protection, speed,
         xp, gold, food, basic, advanced, epic);
     
     //add list    
      monsters.add(temp);
   }
   //adds a Baby_Dragon monster
   private void addBaby_Dragon(){
      String name = "Baby Dragon";
      String desc = "This mystical creature is asleep... it awakens will you be burnt to a crisp.";
      String attackDesc = "Blows Fire at you";
      
      int level = 10;
      int health = 200;
      int attack = 100;
      int damage = 85;
      int defense = 75;
      int protection = 30;
      int speed = 1;
      
      int xp = 1500;
      int gold = 500;
      int food = 80;
      int basic = 0;
      int advanced = 3;
      int epic = 2;
      
      Monster temp = new Monster(name, desc, attackDesc, level,
         health, attack, damage, defense, protection, speed,
         xp, gold, food, basic, advanced, epic);
     
     //add list    
      monsters.add(temp);
   }
    //adds a Unicron monster
   private void addUnicorn(){
      String name = "Unicorn";
      String desc = "This mystical creature has been locked down here for ages and so it is easily anngered buy the slightest movement.";
      String attackDesc = "Stabs You With It's Horn";
      
      int level = 15;
      int health = 200;
      int attack = 100;
      int damage = 85;
      int defense = 75;
      int protection = 15;
      int speed = 8;
      
      int xp = 500;
      int gold = 250;
      int food = 65;
      int basic = 3;
      int advanced = 1;
      int epic = 1;
      
      Monster temp = new Monster(name, desc, attackDesc, level,
         health, attack, damage, defense, protection, speed,
         xp, gold, food, basic, advanced, epic);
     
     //add list    
      monsters.add(temp);
   } 
}