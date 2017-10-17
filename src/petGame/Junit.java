package petGame;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class Junit {

	@Test
	public void Nametest() {
		Players player = new Players(999);
		player.setname("Tony");
		assertEquals("Tony", player.getName());
	}
	
	@Test
	public void getAndUseMoneyThenShowtest() {
		Players player = new Players(999);
		player.getMoney(1);
		assertEquals(1000, player.showMoney());
		player.useMoney(5);
		assertEquals(995, player.showMoney());		
	}
	
	
	@Test
	public void getAndUseSavetest() {
		Players player = new Players(999);
		assertEquals(1, player.getSave());
		player.useSave();
		assertEquals(0, player.getSave());
	
	}
	

	@Test
	public void buyToyAndUseToyTest() {
		Players player = new Players(999);
		Toys toy1 = new FakeMouse();
		Toys toy2 = new Underwear();
		player.buyToy(toy1);
		player.buyToy(toy2);
		ArrayList<Toys> expectedOutput = new ArrayList<Toys>();
		expectedOutput.add(toy1);expectedOutput.add(toy2);
		assertEquals(player.toys, expectedOutput);
		player.useToy(toy1);
		player.useToy(toy2);
		expectedOutput.remove(toy1);expectedOutput.remove(toy2);
		assertEquals(player.toys, expectedOutput);		
	}
	
	@Test
	public void buyToyAndUseFoodTest() {
		Players player = new Players(999);
		Foods food1 = new Bone();
		Foods food2 = new Foods();
		player.buyFood(food1);
		player.buyFood(food2);
		ArrayList<Foods> expectedOutput = new ArrayList<Foods>();
		expectedOutput.add(food1);expectedOutput.add(food2);
		assertEquals(player.foods, expectedOutput);	
		player.useFood(food1);
		player.useFood(food2);
		expectedOutput.remove(food1);expectedOutput.remove(food2);
		assertEquals(player.foods, expectedOutput);
	}
	
	@Test
	public void getPointsAndUsePointAndRefillTest() {
		Players player = new Players(999);
		player.usePoint();
		assertEquals(1, player.getPoint());
		player.refill();
		assertEquals(2, player.getPoint());
	}
	
	@Test
	public void getAndLoseScoreTest() {
		Players player = new Players(999);
		player.getScore(10);
		assertEquals(10, player.score());
		player.losScore(5);
		assertEquals(5, player.score());		
	}

	@Test
	public void AddPetTest() {
		Players player = new Players(999);
		Cat cat = new Cat();
		Ant ant = new Ant();
		player.addPet(cat);
		player.addPet(ant);
		ArrayList<Pets> expectedOutput = new ArrayList<Pets>();
		expectedOutput.add(cat);expectedOutput.add(ant);
		assertEquals(player.pets, expectedOutput);	
	}
	
	@Test
	public void PetnameTest() {
		Cat cat = new Cat();
		cat.setName("carol");
		assertEquals("carol", cat.getName());
			
		
	}

	@Test
	public void Toliettest() {
		Cat cat = new Cat();
		cat.Toilet();
		assertEquals(100, cat.getToilet());
		
	}
	
	@Test
	public void TolietMaxtest() {
		Cat cat = new Cat();
		cat.Toilet();
		cat.Toilet();
		cat.Toilet();
		assertEquals(100, cat.getToilet());
		
	}
	
	
	
	
	@Test
	public void Catsleeptest() {
		Cat cat = new Cat();
		cat.sleep();
		assertEquals(65, cat.getHeath());
		assertEquals(55, cat.getTried());
		assertEquals(35, cat.getHung());
		assertEquals(40, cat.getFun());
	}
	
	@Test
	public void CatNextdaytest() {
		Cat cat = new Cat();
		cat.nextDay();
		assertEquals(47, cat.getHeath());
		assertEquals(30, cat.getTried());
		assertEquals(35, cat.getHung());
		assertEquals(35, cat.getFun());
		assertEquals(35, cat.getToilet());
		assertEquals(7, cat.getWeight());
		
		
	}
	
	
	@Test
	public void Poneysleeptest() {
		Poney poney = new Poney();
		poney.sleep();
		assertEquals(75, poney.getHeath());
		assertEquals(65, poney.getTried());
		assertEquals(25, poney.getHung());
		assertEquals(40, poney.getFun());
		assertEquals(40, poney.getToilet());
		
	}
	
		
	@Test
	public void sicktest() {
		Cat cat = new Cat();
		cat.sick();
		assertTrue(cat.sick);
	}
	
	@Test
	public void curetest() {
		Cat cat = new Cat();
		cat.cure();
		assertEquals(50, cat.getHeath());
		assertEquals(60, cat.getFun());
	}
	
	
	
	@Test
	public void sickThencuretest() {
		Cat cat = new Cat();
		cat.sick();
		assertTrue(cat.sick);
		cat.cure();
		assertEquals(50, cat.getHeath());
		assertEquals(60, cat.getFun());
		assertFalse(cat.sick);
	}
		
	
	@Test
	public void DieThenRebirthtest() {
		Cat cat = new Cat();
		cat.getDeath();
		cat.rebirth();
		assertFalse(cat.getDeath());
		assertEquals(50, cat.getHeath());
		assertEquals(50, cat.getFun());
		assertEquals(50, cat.getToilet());
		assertEquals(50, cat.getTried());
		assertEquals(50, cat.getHung());
	}
	
	@Test
	public void DogEatNormaltest() {
		Dog dog =  new Dog();
		Mosquito food = new Mosquito();
		food.getNutri();
		dog.eat(food);
		assertEquals(53, dog.getHung());
		assertEquals(60, dog.getToilet());
		assertEquals(11, dog.getWeight());
	}
	
	@Test
	public void frogEatFavtest() {
		Frog frog =  new Frog();
		Mosquito food = new Mosquito();
		food.getNutri();
		frog.eat(food);
		assertEquals(56, frog.getHung());
		assertEquals(60, frog.getToilet());
		assertEquals(11, frog.getWeight());
		assertEquals(60, frog.getFun());
	}
	
	@Test
	public void MaxHungtest() {
		PanDa panda =  new PanDa();
		Bamboo food = new Bamboo();
		food.getNutri();
		panda.eat(food);
		assertEquals(100, panda.getHung());
	}
	

	@Test
	public void Bonetest() {
		Bone food = new Bone();
		assertEquals(15, food.getPrice());
		assertEquals(15, food.getNutri());
		assertEquals("Bone", food.getName());
		assertEquals(5, food.getTasti());
	}
	@Test
	public void CatMinttest() {
		CatMint food = new CatMint();
		assertEquals(15, food.getPrice());
		assertEquals(10, food.getNutri());
		assertEquals("CatMint", food.getName());
		assertEquals(25, food.getTasti());
	}
	@Test
	public void Bambootest() {
		Bamboo food = new Bamboo();
		assertEquals(75, food.getPrice());
		assertEquals(35, food.getNutri());
		assertEquals("Bamboo", food.getName());
		assertEquals(35, food.getTasti());
	}
	@Test
	public void Mosquitotest() {
		Mosquito food = new Mosquito();
		assertEquals(5, food.getPrice());
		assertEquals(3, food.getNutri());
		assertEquals("Mosquito", food.getName());
		assertEquals(3, food.getTasti());
	}
	@Test
	public void Grasstest() {
		Grass food = new Grass();
		assertEquals(40, food.getPrice());
		assertEquals(30, food.getNutri());
		assertEquals("Grass", food.getName());
		assertEquals(15, food.getTasti());
	}
	@Test
	public void Peanuttest() {
		Peanut food = new Peanut();
		assertEquals(1, food.getPrice());
		assertEquals(1, food.getNutri());
		assertEquals("Peanut", food.getName());
		assertEquals(20, food.getTasti());
	}
	
	@Test
	public void playAnttest() {	
		Ant ant = new Ant();
		Underwear toy = new Underwear();
		toy.getAba();
		ant.paly(toy);
		assertEquals(52, ant.getFun());
		assertEquals(40, ant.getTried());
		assertEquals(40, ant.getHung());
	}
	@Test
	public void playCatfavtest() {
		Cat cat = new Cat();
		FakeMouse toy = new FakeMouse();
		toy.getAba();
		cat.paly(toy);
		assertEquals(80, cat.getFun());
		assertEquals(30, cat.getTried());
		assertEquals(40, cat.getHung());
		
	}


	@Test
	public void RomaKingtest() {
		RomaKing toy = new RomaKing();
		assertEquals(1000, toy.getPrice());
		assertEquals(1, toy.getDur());
		assertEquals("Roma King", toy.getName());
		assertEquals(999, toy.getAba());
		assertEquals(false, toy.getBreak());
		toy.useToy();
		assertTrue(toy.getBreak());
		
	}
	@Test	
	public void FakeMousetest() {	
		FakeMouse toy = new FakeMouse();
		assertEquals(30, toy.getPrice());
		assertEquals(6, toy.getDur());
		assertEquals("Fake Mouse", toy.getName());
		assertEquals(15, toy.getAba());
		assertEquals(false, toy.getBreak());
		toy.useToy();
		assertFalse(toy.getBreak());
		assertEquals(5, toy.getDur());
		
	}
	@Test
	public void FlyingDisktest() {	
		FlyingDisk toy = new FlyingDisk();
		assertEquals(50, toy.getPrice());
		assertEquals(8, toy.getDur());
		assertEquals("Flying Disk", toy.getName());
		assertEquals(28, toy.getAba());
		assertEquals(false, toy.getBreak());
		toy.useToy();
		assertFalse(toy.getBreak());
		assertEquals(7, toy.getDur());
		
	}
	@Test
	public void ToiletPumptest() {	
		ToiletPump toy = new ToiletPump();
		assertEquals(120, toy.getPrice());
		assertEquals(7, toy.getDur());
		assertEquals("Toilet Pump", toy.getName());
		assertEquals(60, toy.getAba());
		assertEquals(false, toy.getBreak());
		toy.useToy();
		assertFalse(toy.getBreak());
		assertEquals(6, toy.getDur());
	}
	@Test
	public void Underweartest() {	
		Underwear toy = new Underwear();
		assertEquals(5, toy.getPrice());
		assertEquals(3, toy.getDur());
		assertEquals("Used Male Underwear", toy.getName());
		assertEquals(2, toy.getAba());
		assertEquals(false, toy.getBreak());
		toy.useToy();
		assertFalse(toy.getBreak());
		assertEquals(2, toy.getDur());
	}
	@Test
	public void CarrotRobtest() {	
		CarrotRob toy = new CarrotRob();
		assertEquals(90, toy.getPrice());
		assertEquals(15, toy.getDur());
		assertEquals("Carrot Rob", toy.getName());
		assertEquals(35, toy.getAba());
		assertEquals(false, toy.getBreak());
		toy.useToy();
		assertFalse(toy.getBreak());
		assertEquals(14, toy.getDur());
	}
	@Test
	public void Boxtest() {	
		Boxx toy = new Boxx();
		assertEquals(70, toy.getPrice());
		assertEquals(35, toy.getDur());
		assertEquals("Plastic Box", toy.getName());
		assertEquals(30, toy.getAba());
		assertEquals(false, toy.getBreak());
		toy.useToy();
		assertFalse(toy.getBreak());
		assertEquals(34, toy.getDur());
	}



}
