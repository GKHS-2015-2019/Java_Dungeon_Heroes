//WEAPONS
	//Branch #1
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

	//Dagger #2
   public void addDagger(){
      String name = "Dagger          ";
      String desc = "A rusty dagger that is reasonably sharp and might be more useful than your fist";
      int uniqueID = 1;
      int price = 10;
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
      int attack = 2;
      int strength = 2;
      int defense = 0;
      int protection = 0;
         //speed stats
      int speed = 0;
         
      Item tempItem = new Item(name, desc, uniqueID, price, type, level, findLevel, hands, health, stamina, attack, strength, defense, protection, speed);
      basicItems.add(tempItem);
   }//end dagger
   
	//LongSword #101
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
      advancedItems.add(tempItem);
   }//end long sword
   
	//IronSword #102
   public void addIronSowrd(){
      String name = "Iron Sword      ";
      String desc = "A rusty old Sword that is bloody sharp, It will defenitaly be more useful than your fist";
      int uniqueID = 102;
      int price = 100;
      boolean useable = true;
         //equiping stats
      String type = "Weapon  ";
      int level = 1;
      int findLevel = 3;
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
      advancedItems.add(tempItem);
   }//end Iron Sword
   
   //ClayMore #201
   public void addClayMore(){
      String name = "Clay More       "; // ends in 8... helps inventory
      String desc = "A brite SHINY new sword";
      int uniqueID = 201;
      int price = 600;
      boolean useable = false;
         //equiping stats
      String type = "Weapon  "; //ends in 8... helps inventory
      int level = 1;// what level the item is..
      int findLevel = 4;// what level you can find it on
      int hands = 1;
         //life status
      int health = 0;
      int stamina = 1;
         //attack stats
      int attack = 3;
      int strength = 10;
      int defense = 3;
      int protection = 0;
         //speed stats
      int speed = 0;
         
      Item tempItem = new Item(name, desc, uniqueID, price, type, level, findLevel, hands, health, stamina, attack, strength, defense, protection, speed);
      epicItems.add(tempItem);
   }//end ClayMore
   
   //FlamingSword #202
   public void addFlamingSword(){
      String name = "Flaming Sword   ";
      String desc = "You pick up this sword and it bursts to flames like a furnace. Inside your head, you hear a voice syaing, " + 
            "Hello, my name is BURNINAOR. Would you like to toast some enemies?";
      int uniqueID = 202;
      int price = 800;
      boolean useable = true;
         //equiping stats
      String type = "Weapon  ";
      int level = 1;
      int findLevel = 5;
      int hands = 1;
         //life status
      int health = 0;
      int stamina = 2;
         //attack stats
      int attack = 5;
      int strength = 20;
      int defense = 5;
      int protection = 0;
         //speed stats
      int speed = 0;
         
      Item tempItem = new Item(name, desc, uniqueID, price, type, level, findLevel, hands, health, stamina, attack, strength, defense, protection, speed);
      epicItems.add(tempItem);
   }//end flaming sword

//Armor   
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

	//IronArmor #52
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