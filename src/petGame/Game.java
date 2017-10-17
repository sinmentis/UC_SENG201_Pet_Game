package petGame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;


/**
 * This class implements this pet game. 
 * 
 * @author sly31 & mxu19
 * @version 1.0
 */

public class Game {
	static ArrayList<Pets> petList = new ArrayList<Pets>();
	static Scanner reader = new Scanner(System.in);
	static ArrayList<String> userNameList = new ArrayList<String>();
	static ArrayList<String> petsNameList = new ArrayList<String>();
	static Scanner ranReader = new Scanner(System.in);
	static Random ranRan = new Random();
	
	
	/**
	 * This method constructs to check the information of the foods.
	 * @param template is use for show the information and detail of the foods.
	 * @return template is return the information of the foods.
	 */
	
	public static String checkFood(){
		String template = "Here is the detail of the foods:";
		template += "\n1. Bone | Price: $15| Nutrition: 15| Tastiness: 5";
		template += "\n2. CatMint| Price: $15| Nutrition: 10| Tastiness: 25";
		template += "\n3. Bamboo| Price: $75| Nutrition: 35| Tastiness: 35";
		template += "\n4. Mosquito| Price: $5| Nutrition: 3| Tastiness: 3";
		template += "\n5. Grass| Price: $40| Nutrition: 30| Tastiness: 15";
		template += "\n6. Peanut| Price: $1| Nutrition: 1| Tastiness: 50";
		return template;
	}
	
	
	/**
	 * This method constructs to check the information of the toys.
	 * @param template is use for show the information and detail of the toys.
	 * @return template is return the information of the toys.
	 */
	
	
	public static String checkToy(){
		String template = "Here is the detials of the toys:";
		template += "\n1. Fake Mouse | Price: $30 | Durability: 6 | Abalilty: 15";
		template += "\n2. Flying Disk | Price: $50 | Durability: 8 | Abalilty: 28";
		template += "\n3. Toilet Pump | Price: $ 120| Durability: 7 | Abalilty: 60";
		template += "\n4. Used Male Underwear | Price: $5 | Durability: 3  | Abalilty: 2";
		template += "\n5. Carrot Rob | Price: $90 | Durability: 15 | Abalilty: 35 ";
		template += "\n6. Plastic Box | Price: $70 | Durability: 35 | Abalilty: 30";
		return template;
	}
	
	/**
	 * This method check dead Or do Rebirth. print warning message to player.
	 * @param player is one of the players.
	 * @param pet is one of the pets.
	 * 
	 * @return template is return the information of the toys.
	 */
	
	public static void deadOrRebirth(Players player, Pets pet){
		System.out.printf("\n%s are at death's door\n", pet.getName());
		if(player.getSave() == 0){
			System.out.printf("You can do nothing about %s\nR.I.P\n", pet.getName());
		}else{
			System.out.println("What a hero, now your pet are back!");
			pet.rebirth();
			player.useSave();
		}
	}
	/**
	 * This method use to check is it misbehavior. print warning message to player.
	 * @param misCom set by random, pets will gets misbehavior randomly. when misCom equal to "Kick", the health and fun will decreasing by that and misbehaving fixed.
	 * @param misRan equal to 1, the fun will decreasing by that, and misbehaving fixed.
	 * @param health display the health value of the pet. when it misbehavior, the health decreasing 10.
	 * @param fun display the "Happy" value of the pet. when it misbehavior, the fun decreasing 10.
	 * 
	 */
	
	
	
	public static void misbehave(Pets pet){
		System.out.println("Your pet are misbehaving! what are you gonna do? [Kick][pet]");
		String misCom = ranReader.next();
		if(misCom.equals("Kick")){
			System.out.printf("\nThat works, but %s is not happy.\n", pet.getName());
			pet.misB = false;
			pet.health -= 10;
			pet.fun -= 15;
		}else{
			int misRan = ranRan.nextInt(2)+1;
			if(misRan == 1){
				System.out.println("");
				pet.misB = false;
				pet.fun -= 10;
			}else{
				System.out.println("That didn't work cause your pet is an asshole!");
				pet.health -= 5;
			}
		}

		
	}
	
	
	/**
	 * This method use to check is pets get sick. print warning message to player.
	 * @param RamCom set by random, pets will get sick randomly. when misCom equal to "yes". the money decreasing 100 by running method useMoney.
	 * @param health display the health value of the pet. when it misbehavior, the health decreasing 10.
	 * @param fun display the "Happy" value of the pet. when it misbehavior, the fun decreasing 10.
	 * 
	 */
	
	
		
	public static void sick(Players player, Pets pet){	
		pet.sick();
		System.out.printf("\nYou can buy a pill to save %s, but that will cost you $100 [yes][no]", pet.getName());
		String RamCom = ranReader.next();
		if(RamCom.equals("yes")){
			player.useMoney(100);
			pet.cure();
		}else{
			pet.health -= 10;
			if(pet.getHeath() <= 0){
				deadOrRebirth(player, pet);
			}
		}
	}
	
	/**
	 * This method constructs a shop for food and toy.
	 * @param shopReader set by random.
	 * @param buyFlag set for check buy or not.
	 * @param shopCom if shopCom equal to "food", then start buying food, if shopCom equal to "toy", 
	 * then starting buying toy.when shopCom equal to "quit", then quit the shop
	 * 
	 * 
	 */
	
	public static void shop(Players player){
		Scanner shopReader = new Scanner(System.in);
		System.out.printf("Welcome to the shop, %s\n", player.getName());
		System.out.printf("User account: %s\n", player.showMoney());
		boolean buyFlag = true;
		while(buyFlag){
			System.out.println("What do you want to buy? [food][toy][quit]");
			String shopCom = shopReader.next();
			
			if(shopCom.equals("food")){
				System.out.println("What food do you want to buy for your pet?{[0] to quit}{[10] for check} \n1.Bone 2.CatMint 3.Bamboo 4.Mosquito 5.Nice Grass 6.Peanut");
				int foodCom = shopReader.nextInt();
				Foods food = new Foods();
				switch(foodCom){
				case 0: break;
				case 1: food = new Bone();break;
				case 2: food = new CatMint();break;
				case 3: food = new Bamboo();break;
				case 4: food = new Mosquito();break;
				case 5: food = new Grass();break;
				case 6: food = new Peanut();break;
				case 10: System.out.println(checkFood());;break;
				}
				if(food.getPrice() <= player.showMoney()){
					player.useMoney(food.getPrice());
					player.buyFood(food);
					System.out.printf("Success! players account: %s\n", player.showMoney());
					break;
				}else{
					System.out.println("You don't have enough money!");
				}
				
			}
			
			if(shopCom.equals("toy")){
				System.out.println("What toy do you want to buy for your pet?{[0] to quit}{[10] for check} \n1.FakeMouse 2.FlyingDisk 3.ToiletPump 4.Underwear 5.CarrotRob 6.Box");
				int toyCom = shopReader.nextInt();
				Toys toy = new Toys();
				switch(toyCom){
				case 0: break;
				case 1: toy = new FakeMouse();break;
				case 2: toy = new FlyingDisk();break;
				case 3: toy = new ToiletPump();break;
				case 4: toy = new Underwear();break;
				case 5: toy = new CarrotRob();break;
				case 6: toy = new Boxx();break;
				case 10: System.out.println(checkToy());
				}
				if(toy.getPrice() <= player.showMoney()){
					player.useMoney(toy.getPrice());
					player.buyToy(toy);
					System.out.printf("Success! players account: %s", player.showMoney());
					break;	
					}else{
						System.out.println("You don't have enough money!");break;
						}				
				}
			if(shopCom.equals("quit")){
				System.out.println("Quit shop");
				buyFlag = false;
				}
			}
		
	}
	/**
	 * This method is use for check information of pets.
	 * 
	 */
	
	
	public static void checkInfo(Pets pet){
		pet.printInfo(pet);
	}
	
	/**
	 * This method is check the backPack, backPack will include money, foods and toys, the player can see how many of them left.
	 * 
	 */

	public static void backPack(Players player){
		System.out.printf("The money you have is : $%s\n", player.showMoney());
		
		if(player.foods.size()==0){
			System.out.println("\nYou have no food!\n");
			}else{
				System.out.println("You have food:");
				for(Foods food:player.foods){
					System.out.println(food.getName());
					}
				}
		
		if(player.toys.size()==0){
			System.out.println("\nYou have no toy!\n");
			}else{
				System.out.println("You have toy:");
				for(Toys toy:player.toys){
					System.out.println(toy.getName());
					}
				}
		
	}
	
	/**
	 * This method is use to feed pet. and Random events can happen when eating.
	 * @param NameReade is a scanner.
	 * @param foodName is from scanner NameReade.
	 * @param random is set a random events can happen when eating.
	 */

	
	
	public static void fedPet(Players player, Pets pet){
		Scanner NameReader = new Scanner(System.in);
		
		if(player.foods.size() == 0){
			System.out.println("You have nothing to fed!");
		}else{	
			System.out.println("What do you want to fed? [name]");
			//print out backpack
			for(int i = 0;i!=player.foods.size();i++){
				System.out.print((i+1) +"  "+ player.foods.get(i).getName()+"\n");
			}
			
			int foodName = NameReader.nextInt();
			if(foodName<=player.foods.size()){
				pet.eat(player.foods.get(foodName-1));
				player.useFood(player.foods.get(foodName-1));
				player.usePoint();
				player.getScore(10);
				System.out.println("Yummy!");
				}else{
					System.out.println("You don't have that!");
					}
			}
			
		//Ramdom things can happen when eatting!
		Random random = new Random();
		int ranFlag = random.nextInt(10)+1; // max=10 & min=1
		if(ranFlag==3){
			misbehave(pet);
		}
			}
	
	/**
	 * This method is use to play with pet using toys. 
	 * @param NameReade is a scanner.
	 * @param toyName is from scanner NameReade. when toy broke, the toyName decreasing 1.
	 * 
	 */
	
		
	public static void playPet(Players player, Pets pet){
		Scanner NameReader = new Scanner(System.in);
		
		if(player.toys.size() ==0){
			System.out.println("You have nothing to play!");
		}else{	
			System.out.println("What do you want to play? [name]");
			//print out backpack
			for(int i = 0;i!=player.toys.size();i++){
				System.out.print((i+1) + player.toys.get(i).getName());
			}
			
			int toyName = NameReader.nextInt();
			if(toyName<=player.toys.size()){
				pet.play(player.toys.get(toyName-1));
				player.toys.get(toyName-1).useToy();
				player.usePoint();
				player.getMoney(25);
				player.getScore(10);
				System.out.println("That was good!");
				if(player.toys.get(toyName-1).isBreak){
					System.out.println("Your pet just break your toy!");
					player.useToy(player.toys.get(toyName-1));
				}
				}else{
					System.out.println("You don't have that!");
					}
			}
			}
	
	/**
	 * This method is pets go to toilet.
	 * @param ranFlag is Random events can happen, max value of it is 10, min value is 1, when ranFlag equal 3, the pets gets misbehavior.
	 */
	

	public static void toiletPet(Players player, Pets pet){
		System.out.println("Peeeeeeeeeeeeeeeeeeeeeeeeee done");
		player.usePoint();
		pet.Toilet();
		System.out.printf("The pet's toilet level: %s\n", pet.getToilet());
		
		//Ramdom things can happen when eating!
		Random random = new Random();
		int ranFlag = random.nextInt(10)+1; // max=10 & min=1
		if(ranFlag==3){
			misbehave(pet);
		}
	}
	
	/**
	 * This method is pets go to sleep.
	 * @param ranFlag is Random events can happen, max value of it is 10, min value is 1, when ranFlag equal 3, the pets gets misbehavior.
	 */
	


	public static void sleepPet(Players player, Pets pet){
		player.usePoint();
		pet.sleep();
		System.out.println("Your pet is sleeping");
		
		//Ramdom things can happen when eatting!
		Random random = new Random();
		int ranFlag = random.nextInt(10)+1; // max=10 & min=1
		if(ranFlag==3){
			misbehave(pet);
		}
	}
	
	/**
	 * This method is display rank between player. 
	 * @param readerNum is set a initial value which is 0.
	 * 
	 */
	

	
	public static void DisplayRank(){
		int readerNum = 0;
		BufferedReader br = null;
		try{
			FileReader fr = new FileReader("Rank.txt");
			br = new BufferedReader(fr);
			String line = br.readLine();
			while(line != null){
				System.out.printf("%s: %s\n", readerNum++, line);
				line = br.readLine();
			}
			
		}catch(FileNotFoundException e){
			System.out.println("File not found");}
		catch(IOException e){
			System.out.println("Error reading from file");
		}
		
		if(br != null){
			try{
				br.close();
			}catch(IOException e){
				/* ignore */
			}
		}
	}
	
	/**
	 * This method is save the score and find the winner. 
	 * @param winner is the winner of the game.
	 * @param scoreReader is a scanner.
	 * 
	 */
	

	
	public static void SaveScore(Players winner){
		System.out.println("Do you want to save your score?[yes][no]");
		Scanner scoreReader = new Scanner(System.in);
		String scoreCom = scoreReader.next();
		BufferedWriter buffwriter = null;
		if(scoreCom.equals("yes")){
			try{
				FileWriter fw = new FileWriter("Rank.txt");
				buffwriter = new BufferedWriter(fw);
				String template = winner.getName() + " : " + winner.score();
				buffwriter.write(template);
				buffwriter.newLine();
			}catch(IOException e){
				System.out.println("Error Wring to file");
			}
			if(buffwriter !=null){
				try{buffwriter.close();}catch(IOException e){/*nothing*/}
			}
			
		}
	}
	
	/**
	 * This method is to running the main game. include greeting and every step. 
	 * 
	 */
	

	
	public static void main(String[] args){
		
		// create a ArrayList of pets
		petList.add(new Dog());
		petList.add(new Cat());
		petList.add(new Ant());
		petList.add(new Frog());
		petList.add(new PanDa());
		petList.add(new Poney());
	
		// ask for how many players
		System.out.print("How many players: ");
		int playerNum = reader.nextInt();
		Players[] players= new Players[playerNum]; // set up the number of playerList
		
		// ask for how many days
		System.out.print("\nHow many days do you want to play: ");
		int days = reader.nextInt();
		
		// print out help section
		System.out.println("\n\nHow to play?");
		System.out.println("1. The winner of the game is determined by the final score.");
		System.out.println("2. Every player has two action points in each day.");
		System.out.println("3. Using action point to interactive with your pet can get different score.");
		System.out.println("4. Keep your eye on the pet's data in case accident happened.");
		System.out.println("5. You can buy things to keep your pet act like pet in store.");
		System.out.println("6. It is just a game so have fun and good luck!");
		
		/* 
		 * start detail decision for each player | run once.
		 */
		
		// ask players detail and choosing pets.
		for(int i = 0; i!=playerNum;i++){
			String userName = null;
			players[i] = new Players(1000); // 100 bucks for everyone.
			
			// ask name and check repeat
			boolean userNameFlag = true;
			while(userNameFlag){
				System.out.printf("The name of %d player: ", i+1);
				userName = reader.next();
				// if there already has a same name.
				if(userNameList.contains(userName) == false){
					players[i].setname(userName);
					userNameList.add(userName);
					userNameFlag = false;
				}else{
					System.out.println("Sorry, the name already exist. Let's try again.");
				}
			}
			
			// ask player how many pets does he want.
			boolean petNumFlag = true;
			int petsNum = 0;
			while(petNumFlag == true){
				System.out.print("How many pets do you want:   (1) (2) (3)");
				petsNum = reader.nextInt();
				if(petsNum > 3 || petsNum < 1){
					System.out.println("You only have 3 options");
				}else{
					petNumFlag = false;
				}
			}
			
			//greeting
			System.out.printf("Well hello there %s\n", userName);
			System.out.println("1.Ant\n2.Cat\n3.Dog\n4.Frog\n5.PanDa\n6.Poney\n");
			
			// choosing pets and name check.
			for(int j = 0; j!= petsNum; j++){
				boolean commandFlag = true;
				
				// until enter pets number instead of Check.
				while(commandFlag == true){
					System.out.println("Which one do you want now?\nEnter [Check] to check the pets\n");
					String command = reader.next();
					
					// when surface input are invalid.
					if(command.equals("1")||command.equals("2")||command.equals("3")||command.equals("4")||command.equals("5")||command.equals("6")||command.equals("Check")){
					
						// open check menu.
						if(command.equals("Check")){
							System.out.println("     Check menu ");
							System.out.println("Which pets do you want to check?");
							int CheckCom = reader.nextInt();
							
							// identify pets class, call describe method.
							Pets selectedPet = new Pets();
							switch(CheckCom){
							case 1: selectedPet = new Ant();break;
							case 2: selectedPet = new Cat();break;
							case 3: selectedPet = new Dog();break;
							case 4: selectedPet = new Frog();break;
							case 5: selectedPet = new PanDa();break;
							case 6: selectedPet = new Poney();break;
							
							default: System.out.println("Invalid input"); 
							}
							System.out.println(selectedPet.getDesc());// call describe and print it out.
							
						}else{
							
							// identify pets class, and call player.addpet method.
							Pets selectedPet = null;
							switch(command){
							case "1": selectedPet = new Ant();break;
							case "2": selectedPet = new Cat();break;
							case "3": selectedPet = new Dog();break;
							case "4": selectedPet = new Frog();break;
							case "5": selectedPet = new PanDa();break;
							case "6": selectedPet = new Poney();break;
							}
							
							
							// name the pet and check the repeat
							boolean petNameFlag = true;
							while(petNameFlag){
								System.out.println("what is your pets name?");
								String petName = reader.next();
								if(petsNameList.contains(petName)==false){
									petsNameList.add(petName); // add name in list.
									selectedPet.setName(petName); // set up the name.
									players[i].addPet(selectedPet); // call player.addpet method.
									System.out.println("Excellent choice!"); 
									commandFlag = false; // go to next pet selection.
									petNameFlag = false; // break out the loop.
								}else{
									System.out.println("Not a good name, try again.");
								}
							}
						}
					}else{
						System.out.println("Invalid input\nI give you one more chance!"); 
					}
				}//end of surface command --check or selection
			}// end of pet choosing.
		}// each player
		
		/*
		 * when code runs here, which means every player already pick up their pets and name it currently.
		 * 
		 * now start with loop for every player and the real game starts.
		 */
		
		System.out.print("It seems like every one are happy with their pets, let the game begin!\n\n");
		for(int day = 0; day < days; day++){
			//greeting for each days
			System.out.printf("********************Day %s********************\n", day+1);
			
			//each player.
			for(int playOrder = 0; playOrder < players.length; playOrder++){
				
				//Greeting for each player.
				System.out.printf("Hello %s\n", players[playOrder].getName());
				
				//Greeting for each pets.
				for(int petsOrder=0; petsOrder != players[playOrder].pets.size(); petsOrder++){
					if(players[playOrder].pets.get(petsOrder).getDeath()){
						System.out.printf("\n%s is dead, sorry\n", players[playOrder].pets.get(petsOrder).getName());
						}else{
							System.out.printf("player " + players[playOrder].getName() + " and pet " + players[playOrder].pets.get(petsOrder).getName());
							players[playOrder].refill();
							// action point
							while(players[playOrder].getPoint() != 0){
								//read user input command and call whatever it is.
								boolean actionFlag = true;
								while(actionFlag == true){
									System.out.println(" \nwhat do you want to do?\n[shop][check][fed][play][toilet][sleep][backpack]");
									String actionCom = reader.next();
									// identify the command and call it.
									switch(actionCom){
										case "shop":shop(players[playOrder]);actionFlag = false;break;
										case "check":checkInfo(players[playOrder].pets.get(petsOrder));actionFlag = false;break;
										case "fed":fedPet(players[playOrder], players[playOrder].pets.get(petsOrder));actionFlag = false;break;
										case "play":playPet(players[playOrder], players[playOrder].pets.get(petsOrder));actionFlag = false;break;
										case "toilet":toiletPet(players[playOrder], players[playOrder].pets.get(petsOrder));actionFlag = false;break;
										case "sleep": sleepPet(players[playOrder],players[playOrder].pets.get(petsOrder));actionFlag = false;break;
										case "backpack":backPack(players[playOrder]);actionFlag = false;break;
										default: System.out.println("Invaild input, try again.\n");
									}
								}
							}
							
							// deal with all situation
							if(players[playOrder].pets.get(petsOrder).getFun() == 0 || players[playOrder].pets.get(petsOrder).getHeath() == 0 || players[playOrder].pets.get(petsOrder).getHung() == 0 || players[playOrder].pets.get(petsOrder).getToilet() == 0 || players[playOrder].pets.get(petsOrder).getTried() == 0){
								players[playOrder].pets.get(petsOrder).die();
								deadOrRebirth(players[playOrder], players[playOrder].pets.get(petsOrder));
							}else{
								// sick
								if(players[playOrder].pets.get(petsOrder).getHeath() <= 20){
									sick(players[playOrder], players[playOrder].pets.get(petsOrder));
								}
								// misbeahave
								if(players[playOrder].pets.get(petsOrder).getMisB()){
									misbehave(players[playOrder].pets.get(petsOrder));
								}
							}
								
								System.out.println("******Action point runs out!******");
						}
					}
			}
		}
		
		
		
		
		/**
		 * When code runs here, which means game is already over and it is time to calculate the winner! 
		 * shows winner and message
		 */	
		
		// winner and message
		
		System.out.println("GAME OVER!!!!!!");
		Players winner = players[0];
		for(Players player: players){
			System.out.println("Player " +player.getName() +", Socre: "+player.score());
			if(player.score() > winner.score()){winner = player;}
		}
		
		System.out.printf("----------\nThe winner is %s\n----------", winner.getName());
		
		/**
		 * display the rank list.

		 */	

		// display the rank list
		DisplayRank();
		
		/**
		 * ask for save the result

		 */	
		
		
		// ask for save the result
		SaveScore(winner);

		
		
		}// main method
}// whole game class
