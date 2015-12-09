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