Version 0.4 - Add XP + Leveling
		-add in player Class
		-increaseLevel in player Class
			Increases Max Health, Attack, Defense
			Decreases Speed
			XP to level = currentLevel * 10
			giveGold (gives player food)
			giveFood (gives player food)
		-Add to monster
			*getGold
			*getFood
		-In fight in Dungeon Heroes...
			*Reward player for winning
			*Set monster health to max
			
	    -Add Master Room
		-Loot
		-Explore (next room)
		-Rest (uses food to heal)
			-3 player functions
				rest (uses food to heal)
				Stamina / health
				stamina = 1 food per 10 stamina
				health = 1 food per health

Version 0.3 - Add fighting
	Create a random dice roller function
	Simulate a fight between the character and the monster (to the death)
		Choice character will have each round:
			(S)trong attack, (W)eak attack, (F)lee
		The return of the monster function will set up the appropriate number of treasures



Version 0.2-
	Add Monsters + Rooms
		Create a Monster Class
			Name
			Description
			Health
			Attack
			Defense
			Strength
			Protection
			Speed
			XP
			//Treasure (Will do this later)
		Create a Monster List Class
			Add a type of monster
			Randomly choose a monster from the player


Version 0.1 - 
	Create the Player Class
		Attributes:
			Name
			Class
			Health
			Attack
			Defense
			Strength
			Armor
			Food
			Inventory
			Experience
			Level
			Stamina

		Methods
			Player(Name, Class) --> Creates a new player
			