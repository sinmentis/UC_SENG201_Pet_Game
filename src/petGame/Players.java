package petGame;

import java.util.ArrayList;
/**
 * This class implements player part of pet game. 
 * This Constructs basic action and function which the player using in pet game.
 * @author sly31 & mxu19
 * @version 1.0
 */
public class Players {
	/**
	 * 
	 * @param money is set the money without initial value.
	 * @param score Set the score to 0.
	 * @param name is Set the name to initial.
	 * @param actionPoint is Set action point of the pet which is 2. actionPoint is about how many times action you can execute in your pet.
	 * @param saving is Set the saving which is 1.
	 * @param pets Set a new list for saving pets.
	 * @param toys Set a new list for get and store toys.
	 * @param foods Sat a new list for get foods and store.
	 * @param isStand is set to check is your pet ready?
	 */
	int money;
	int score = 0;
	String name = "";
	int actionPoint = 2;
	int savingPet = 1;
	boolean isStand = false;
	ArrayList<Pets> pets = new ArrayList<Pets>();
	ArrayList<Toys> toys = new ArrayList<Toys>();
	ArrayList<Foods> foods = new ArrayList<Foods>();
	
	
	public Players(int money){this.money = money;}
	/**
	 * Save the game and get load.
	 * @return savingPet when we get saving.
	 * 
	 */
	
	
	// Save the game and get load.
	public int getSave(){return savingPet;}
	public void useSave(){savingPet = 0;}
	/**
	 * Set the name of player.
	 * @return name when we set name.
	 * 
	 */
	public void setname(String name){this.name = name;}
	public String getName(){return name;}
	/**
	 * get money, use money and show the balance.
	 * @param money will increasing by using method getMoney, decreasing by using method useMoney.
	 * @return money which is balance.
	 * 
	 */
	
	// get money, use money and show the balance.
	public void getMoney(int number){this.money += number;}
	public void useMoney(int number){this.money -= number;}
	public int showMoney(){return this.money;}
	/**
	 * get and lose score of the game.
	 * @param score will increasing by using method getScore, decreasing by using method losScore.
	 * 
	 */
	
	
	// get and lose score of the game
	public void getScore(int number){this.score += number;}
	public void losScore(int number){this.score -= number;}
	
	/**
	 * using money to buy toys and using toys.
	 * @param toy is one of the Toys.
	 * @param toys list will be add toy by method buyToy, remove toy from list by method useToy. 
	 */
	
	
	// using money to buy toys and using toys.
	public void buyToy(Toys toy){toys.add(toy);}
	public void useToy(Toys toy){toys.remove(toy);}
	
	/**
	 * using money to buy foods and feed.
	 * @param food is one of the Foods.
	 * @param foods list will be add food by method buyFood, remove food from list by method useFood. 
	 */
	
	
	// using money to buy foods and feed
	public void buyFood(Foods food){foods.add(food);}
	public void useFood(Foods food){foods.remove(food);}
	/**
	 * use actionPoint to do any execute.
	 * @return actionPoint.
	 * @param actionPoint equal to 2 by method refill.
	 */
	
	// things with action points.
	public void usePoint(){this.actionPoint--;}
	public int getPoint(){return actionPoint;}
	public void refill(){actionPoint = 2;}
	
	
	/**
	 * store the pet into the list we set.
	 * @param pet is one of the Pets.
	 * @return score.
	 * @return money is show your balance.
	 * 
	 */
	
	public void addPet(Pets pet){pets.add(pet);}
	public void addPetArray(ArrayList<Pets> petArray){this.pets = petArray;}
	public int score(){return score;}
	public int money(){return money;}
	public void stand(){isStand=true;}
	public void cancellStand(){isStand=false;}
	public boolean getStand(){return isStand;}
}
