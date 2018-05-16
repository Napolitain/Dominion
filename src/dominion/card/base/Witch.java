package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Sorcière (Witch)
 * 
 * +2 Cartes.
 * Tous vos adversaires recoivent une carte Curse.
 */
public class Witch extends AttackCard {

	public Witch() {
		super("Witch", 5);
	}

	@Override
	public void play(Player p) {
		p.gain(p.drawCard());
		p.gain(p.drawCard());
		for (Player a: p.otherPlayers()) {
			a.gain("Curse");
		}
		p.addToDiscard(this); // place la carte dans la défausse une fois jouée
	}
}
