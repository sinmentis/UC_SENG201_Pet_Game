package petGame;

import java.util.Random;
/**
 * This class implements pet part of pet game. 
 * This Constructs basic action and function which the pets using in pet game.
 * @author sly31 & mxu19
 * @version 1.0
 */
class Pets {
	/**
	 * 
	 * @param name is Set the name.
	 * @param describe is Set the describe.
	 * @param hungry is Set the initial value of hungry.
	 * @param tried is Set the initial value of tried.
	 * @param fun is Set initial value of fun.
	 * @param health is Set initial value of health.
	 * @param death is Set a boolean to show death.
	 * @param misB is Set a boolean to check is it at misbehavior situation.
	 * @param sick is Set a boolean to check is it at scik situation.
	 * @param toilet is Set the initial value of toilet to show is it need toilet.
	 * @param weight is Set the initial value of weight.
	 * @param rand is set a new random
	 * 
	 */
	String name = "";
	String describe = "";
	String getImg="";
	int hungry = 50;
	int tried = 50;
	int fun = 50;
	int health = 50;
	boolean death = false;
	boolean misB = false;
	boolean sick = false;
	int toilet = 50; 	
	int weight = 1;
	int actionPoint = 2;
	/**
	 * This method is set the name of the pet.
	 * @param name is Set the name of current pet the player choose.
	 * 
	 */
	// things pets can do.
	public void setName(String name){this.name = name;}
	/**
	 * This method is set the toilet function.
	 * @param toilet value increasing to 100.
	 * 
	 * 
	 */	
	public void Toilet(){this.toilet = 100;} // max is 100
	/**
	 * 
	 * This method is Print information and current value.
	 * 
	 */	
	public void printInfo(Pets pet){
		System.out.printf("Information about %s\n", pet.name);
		System.out.println(pet.getDesc());
		System.out.printf("Hungry: %s\n", pet.getHung());
		System.out.printf("Tried: %s\n", pet.getTried());
		System.out.printf("Fun: %s\n", pet.getFun());
		System.out.printf("Health: %s\n", pet.getHeath());
		System.out.printf("Toilet: %s\n", pet.getToilet());
		System.out.printf("Weight: %s\n", pet.getWeight());
		
	}

	/**
	 * 
	 * @return death or not.
	 * @return misbehavior or not.
	 * @return sick or not.
	 * @return hungry.
	 * @return tried.
	 * @return fun.
	 * @return toilet or not.
	 * @return weight.
	 * @return description of pet.
	 * @return name of pet.
	 *  
	 */	
		
	// get pets information
	public boolean getDeath(){return death;}
	public boolean getMisB(){return misB;}
	public boolean getSick(){return sick;}
	public int getHung(){return hungry;}
	public int getTried(){return tried;}
	public int getFun(){return fun;}
	public int getHeath(){return health;}
	public int getToilet(){return toilet;}
	public int getWeight(){return weight;}
	public String getDesc(){return describe;}
	public String getName(){return name;}
	public String getImg(){return getImg;}
	public int getActionPoint(){return actionPoint;}
	/**
	 * 
	 * All actions and situations the pet using or currently get.
	 * @param food is one of the Foods. used by eat method.
	 * @param play is one of the Toys, used by play method.
	 * 
	 * @param health equal 20 when get sick. health equal 50 when get cure.
	 * @param fun plus 10 when get cure.
	 * @param death equal true,the pet die.
	 * 
	 */	
	public void nextDay(){}
	public void misBehave(){misB=true;}
	public void misBkick(){misB=false;fun-=10;}
	public void eat(Foods food){}
	public void usePoint(){actionPoint-=1;}
	public void refillPoint(){actionPoint = 2;}
	public void play(Toys toy){}
	public void sleep(){}
	public void sick(){sick=true;}
	public void cure(){health = 50; fun += 10; sick=false;}
	public void die(){death = true;}
	/**
	 * 
	 * This method is about Rebirth and all value back to initial value.
	 * @param death is Set as false when running the rebirth.
	 * @param hungry is back to initial value 50.
	 * @param tried is back to initial value 50.
	 * @param fun is back to the initial value 50.
	 * @param health is back to initial value 50.
	 * @param toilet is back to initial value 50.
	 * 
	 */	
	public void rebirth(){
		death = false;
		hungry = 50;
		tried = 50;
		fun = 50;
		health = 50;
		toilet = 50;
	}
	}