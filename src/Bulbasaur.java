
public class Bulbasaur extends PokeBank{

private int hp;
	
	public Bulbasaur() {
		setHp(70);
	}
	
	public void leechSeed(PokeBank target) {
		//deal 20 damage
		int currentHp = target.getHp();
		int resultingHp = currentHp - 10;
		target.setHp(resultingHp);
		// we are missing a line of code. Health can't go over 70
		int thisCurrentHp = this.getHp();
		this.setHp(thisCurrentHp + 20);
		
		target.setHp(resultingHp);
		
		
	}
	
}


