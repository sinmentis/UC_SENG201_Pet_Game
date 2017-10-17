package petGame;
/**
 * This class implements the Ant. 
 * This Constructs three basic actions of the pet which are eat, play, sleep. 
 * @author sly31 & mxu19
 * @version 1.0
 */
public class Ant extends Pets{
	
	public Ant() {
		super();
		describe = "1.Need more time to eat, east to get sick, hard to get tired\n2. Likes [Peanut] and [Plastic Box]";
		getImg = "/petGame/icons/Ant.png";
	}
	
	
	/**
	 * This method constructs eat of this pet.The pet eats foods,
	 * 
	 * @param food is one of the Foods.
	 * @param hungry is increasing by the food. hungry must in range 0 to 100 if greater than 100, the hungry keep value equal to 100, if is favorite food of 
	 * this pet, then double the plus value in hungry.
	 * @param fun is increasing 10 by the food.
	 * @param toilet is increasing 10 by the food.
	 * @param weight is increasing 10 by the food.
	 */

	public void eat(Foods food){
		// if is fav food. increase hungry and fun and toilet.
		if(food.getName() == "Peanut"){
			hungry += food.getNutri()*2;
			fun += 10;
			System.out.println("Your pets like this, Double the effect");
		}else{
			hungry += food.getNutri();}
		if(hungry>100){hungry = 100;} // max is 100
		
		toilet += 10;
		weight += 10;
	}
	
	/**
	 * This method constructs play with this pet using toy.
	 * 
	 * @param fun is increasing 10 by the toy. if it is favorite toy. then double the plus value in fun.
	 * @param tried is decreasing 10.
	 * @param hungry is decreasing 10.
	 * @param toy is one of the toys. when the fun increasing, the durability reduce 1.
	 * 
	 */
	
	public void paly(Toys toy){
		// if is fav toy. increase fun and reduce hungry and tried.
		if(toy.getName() == "Plastic Box"){
			fun += toy.getAba()*2;
		}else{
			fun += toy.getAba(); // play the toy reduce 1 durability. 
		}
		
		tried -= 10;
		hungry -= 10;
		
		// reduce the number of durability
		toy.useToy();}
	
	/**
	 * This method constructs sleep of this pet. The pet gets sleep.
	 * 
	 * @param health increasing 5 by sleep.
	 * @param tried are increasing 25 by the sleep.
	 * @param hungry decreasing 25 by sleep.
	 * @param fun decreasing 10 by sleep.
	 * @param toilet decreasing 10 by sleep.
	 */

	// sleep function, put pet in sleep and reduce every variable. and determine death.
	public void sleep(){
		health += 5; // sleep increase health
		tried += 25;
		hungry -= 25;
		fun -= 10;
		toilet -= 10;
		
	
	}
	
	/**
	 * This method constructs next day.
	 * 
	 * @param health decreasing 15 by next day.
	 * @param tried are decreasing 3 by next day.
	 * @param hungry decreasing 25 by next day.
	 * @param fun decreasing 10 by next day.
	 * @param toilet decreasing 15 by next day.
	 * @param weight is increasing 5 by next Day
	 */
	public void nextDay(){
		health -= 15;
		hungry -= 25;
		tried -= 3;
		toilet -= 15;
		fun -= 10;
		weight += 5;
	}
	
}