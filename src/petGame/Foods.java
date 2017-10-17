package petGame;

/**
 * This class implements six foods. 
 * This Constructs basic information and data of six different foods.
 * @author sly31 & mxu19
 * @version 1.0
 */

class Foods {
	
	/**
	 * 
	 * @param name is Set the name of foods.
	 * @param price is Set the initial price 9999.
	 * @param nutrition Set the initial nutrition value 0.
	 * @param Set the tastiness 0.
	 * @param Get the image address.
	 * @param Get the description.
	 * 
	 */
	
	
	public String name = "";
	public int price = 9999;
	public int nutrition = 0;
	public int tastiness = 0;
	public String ImgAddr;
	public String dis = "";
	
	/**
	 * @return the name.
	 * @return the price.
	 * @return the nutrition.
	 * @return the tastiness.
	 * @return the Get the image address.
	 * @return Get the description.
	 */
	// get food info
	public String getName(){return name;}
	public int getPrice(){return price;}
	public int getNutri(){return nutrition;}
	public int getTasti(){return tastiness;}
	public String getImg(){return ImgAddr;}
	public String getDis(){return dis;}
	
	}




/**
 * 
 * This Constructs basic information and data of Bone. it is extends from Foods.
 */


class Bone extends Foods{
	/**
	 * @param name is name the food Bone.
	 * @param price is set the price of Bone.
	 * @param nutrition is set the nutrition of Bone.
	 * @param tastiness is set the tastiness of Bone.
	 */
	public Bone() {
		super();
		name = "Bone";
		price = 15;
		nutrition = 15;
		tastiness = 5;
		ImgAddr = "/petGame/icons/Bone.png";
		dis = "Name: Bone\r\nNutrition: 15\r\nTastiness: 5\r\nPrice: 15";
		}
	}

/**
 * 
 * This Constructs basic information and data of Catmint. it is extends from Foods.
 */
class CatMint extends Foods{
	/**
	 * @param name is name the food catmint.
	 * @param price is set the price of catmint.
	 * @param nutrition is set the nutrition of catmint.
	 * @param tastiness is set the tastiness of catmint.
	 */
	public CatMint(){
		super();
		name = "CatMint";
		price = 15;
		nutrition = 10;
		tastiness = 25;
		ImgAddr = "/petGame/icons/Catmint.png";
		dis = "Name: Cat Mint\r\nNutrition: 5\r\nTastiness: 15\r\nPrice: 15";
		}
	}

/**
 * 
 * This Constructs basic information and data of bamboo. it is extends from Foods.
 */
class Bamboo extends Foods{
	/**
	 * @param name is name the food bamboo.
	 * @param price is set the price of bamboo.
	 * @param nutrition is set the nutrition of bamboo.
	 * @param tastiness is set the tastiness of bamboo.
	 */
	public Bamboo(){
		super();
		name = "Bamboo";
		price = 75;
		nutrition = 35;
		tastiness = 35;
		ImgAddr = "/petGame/icons/Bamboo.png";
		dis = "Name: Bamboo\r\nNutrition: 35\r\nTastiness: 35\r\nPrice: 75";
		}
	}

/**
 * 
 * This Constructs basic information and data of Mosquito. it is extends from Foods.
 */
class Mosquito extends Foods{
	/**
	 * @param name is name the food Mosquito.
	 * @param price is set the price of Mosquito.
	 * @param nutrition is set the nutrition of Mosquito.
	 * @param tastiness is set the tastiness of Mosquito.
	 */
	public Mosquito() {
		super();
		name = "Mosquito";
		price = 5;
		nutrition = 3;
		tastiness = 3;
		ImgAddr = "/petGame/icons/Mosquito.png";
		dis = "Name: Mosquito\r\nNutrition: 3\r\nTastiness: 3\r\nPrice: 5";
		}

	}
/**
 * 
 * This Constructs basic information and data of Grass. it is extends from Foods.
 */
class Grass extends Foods{
	/**
	 * @param name is name the food Grass.
	 * @param price is set the price of Grass.
	 * @param nutrition is set the nutrition of Grass.
	 * @param tastiness is set the tastiness of Grass.
	 */
	public Grass() {
		super();
		name = "Grass";
		price = 40;
		nutrition = 30;
		tastiness = 15;	
		ImgAddr = "/petGame/icons/Grass.png";
		dis = "Name: Grass\r\nNutrition: 30\r\nTastiness: 15\r\nPrice: 40";
		}

	}
/**
 * 
 * This Constructs basic information and data of Peanut. it is extends from Foods.
 */
class Peanut extends Foods{
	/**
	 * @param name is name the food Peanut.
	 * @param price is set the price of Peanut.
	 * @param nutrition is set the nutrition of Peanut.
	 * @param tastiness is set the tastiness of Peanut.
	 */
	public Peanut() {
		super();
		name = "Peanut";
		price = 1;
		nutrition = 1;
		tastiness = 20;
		ImgAddr = "/petGame/icons/Peanut.png";
		dis = "Name: Peanut\r\nNutrition: 1\r\nTastiness: 20\r\nPrice: 1";
		}
	}
