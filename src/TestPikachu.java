//do better you donkey
public class TestPikachu {
	
	public static void main(String[] args) {
		Pikachu pikaMain = new Pikachu();
		Pikachu pikaTarget = new Pikachu();
		Bulbasaur newBulb = new Bulbasaur();
		
		
		System.out.println("Bulbasaur use leechseed!");
		newBulb.leechSeed(pikaMain);
		System.out.println("Pika Main Hp: " + pikaMain.getHp() + "Balbasaur Hp: " + newBulb.getHp());
		
		//pikaMain.quickAttack(newBulb);
		
		while(pikaTarget.getHp() > 0) {
			
		System.out.println("Pikachu! use QUICK ATTACK!");
		//pikaMain.quickAttack(pikaTarget);
		System.out.println("Pika Target Hp: " + pikaTarget.getHp());
	}

}
}
