package petGame;

/**
 * This class implements seven toys. 
 * This Constructs basic information and data of seven different toys.
 * @author sly31 & mxu19
 * @version 1.0
 */

class Toys {
	
	/**
	 * 
	 * @param name is Set the name.
	 * @param is Set the price.
	 * @param durability Set the durability.
	 * @param abailty is Set the ability.
	 * @param isBreak set a boolean for check is it get break?
	 * @param ImgAddr is get the image address.
	 * @param dis Get the description.
	 */
	String name = "";
	int price = 0;
	int durability = 0;
	int abailty = 0;
	boolean isBreak = false;
	String ImgAddr=null;
	String dis = "";
	
	/**
	 * 
	 * @Return the price.
	 * @Return the durability.
	 * @Return the ability.
	 * @Return the name.
	 * @Return isBreak is the result of check of the break.
	 * @Return ImgAddr is get the image address.
	 * @Return dis is Get the description.
	 */
	
	public int getPrice(){return price;}
	public int getDur(){return durability;}
	public void useToy(){durability -= 1;if(durability == 0){isBreak=true;}} // toy break when 0 durability
	public int getAba(){return abailty;}
	public String getName(){return name;}
	public boolean getBreak(){return isBreak;}
	public String getImg(){return ImgAddr;}
	public String getDis(){return dis;}
}

/**
 * 
 * This Constructs basic information and data of RomaKing. it is extends from Toys.
 */

class RomaKing extends Toys{
	/**
	 * 
	 * @param name is Name the Toy RomaKing.
	 * @param price is Set the price of RomaKing.
	 * @param durability is Set the durability of RomaKing.
	 * @param abailty is Set the ability of RomaKing.
	 * 
	 */
	
	public RomaKing() {
		super();
		name = "Roma King";
		price = 1000;
		durability = 1;
		abailty = 999;
		}	
	}

/**
 * 
 * This Constructs basic information and data of FakeMouse. it is extends from Toys.
 */

class FakeMouse extends Toys{
	/**
	 * 
	 * @param name is Name the Toy FakeMouse.
	 * @param price is Set the price of FakeMouse.
	 * @param durability is Set the durability of FakeMouse.
	 * @param abailty is Set the ability of FakeMouse.
	 * @param ImgAddr is get the image address.
	 * @param dis Get the description.
	 * 
	 */
	
	public FakeMouse() {
		super();
		name = "Fake Mouse";
		price = 30;
		durability = 6;
		abailty = 15;
		ImgAddr = "/petGame/icons/FakeMouse.png";
		dis = "Name: FakeMouse\r\nDurability: %d\r\nAbailty: 15\r\nPrice: 30";
		}
	}
/**
 * 
 * This Constructs basic information and data of FlyingDisk. it is extends from Toys.
 */

class FlyingDisk extends Toys{
	/**
	 * 
	 * @param name is Name the Toy FlyingDisk.
	 * @param price is Set the price of FlyingDisk.
	 * @param durability is Set the durability of FlyingDisk.
	 * @param abailty is Set the ability of FlyingDisk.
	 * @param ImgAddr is get the image address.
	 * @param dis Get the description.
	 * 
	 */
	
	
	public FlyingDisk() {
		super();
		name = "Flying Disk";
		price = 50;
		durability = 8;
		abailty = 28;
		ImgAddr = "/petGame/icons/FlyingDisk.png";
		dis = "Name:FlyingDisk\r\nDurability: %d\r\nAbailty: 28\r\nPrice: 50";
		}	
	}
/**
 * 
 * This Constructs basic information and data of ToiletPump. it is extends from Toys.
 */

class ToiletPump extends Toys{
	/**
	 * 
	 * @param name is Name the Toy Toilet Pump.
	 * @param price is Set the price of Toilet Pump.
	 * @param durability is Set the durability of Toilet Pump.
	 * @param abailty is Set the ability of Toilet Pump.
	 * @param ImgAddr is get the image address.
	 * @param dis Get the description.
	 */
	
	public ToiletPump() {
		super();
		name = "Toilet Pump";
		price = 120;
		durability = 7;
		abailty = 60;
		ImgAddr = "/petGame/icons/ToiletPump.png";
		dis = "Name:ToiletPump\r\nDurability: %d\r\nAbailty: 60\r\nPrice: 120";
		}	
	}
/**
 * 
 * This Constructs basic information and data of Underwear. it is extends from Toys.
 */


class Underwear extends Toys{
	/**
	 * 
	 * @param name is Name the Toy Underwear.
	 * @param price is Set the price of Underwear.
	 * @param durability is Set the durability of Underwear.
	 * @param abailty is Set the ability of Underwear.
	 * @param ImgAddr is get the image address.
	 * @param dis Get the description.
	 */
	
	public Underwear() {
		super();
		name = "Used Male Underwear";
		price = 5;
		durability = 3;
		abailty = 2;
		ImgAddr = "/petGame/icons/Underwear.png";
		dis = "Name:MaleUnderwear\r\nDurability: %d\r\nAbailty: 2\r\nPrice: 5";
		}	
	}

/**
 * 
 * This Constructs basic information and data of CarrotRo. it is extends from Toys.
 */
class CarrotRob extends Toys{
	/**
	 * 
	 * @param name is Name the Toy CarrotRob.
	 * @param price is Set the price of CarrotRob.
	 * @param durability is Set the durability of CarrotRob.
	 * @param abailty is Set the ability of CarrotRob.
	 * @param ImgAddr is get the image address.
	 * @param dis Get the description.
	 */
	public CarrotRob() {
		super();
		name = "Carrot Rob";
		price = 90;
		durability = 15;
		abailty = 35;
		ImgAddr = "/petGame/icons/CarrotRob.png";
		dis = "Name: Rob\r\nDurability: %d\r\nAbailty: 35\r\nPrice: 90";
		}
	}
/**
 * 
 * This Constructs basic information and data of Plastic Box. it is extends from Toys.
 */

class Boxx extends Toys{
	/**
	 * 
	 * @param name is Name the Toy Plastic Box.
	 * @param price is Set the price of Plastic Box.
	 * @param durability is Set the durability of Plastic Box.
	 * @param abailty is Set the ability of Plastic Box.
	 * @param ImgAddr is get the image address.
	 * @param dis Get the description.
	 */
	public Boxx() {
		super();
		name = "Plastic Box";
		price = 70;
		durability = 35;
		abailty = 30;
		ImgAddr = "/petGame/icons/Box.png";
		dis = "Name: Box\r\nDurability: %d\r\nAbailty: 30\r\nPrice: 70";
		}	
	}