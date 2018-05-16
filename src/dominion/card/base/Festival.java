package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Festival
 * 
 * +2 Actions.
 * +1 Achat.
 * +2 Pièces.
 */
public class Festival extends ActionCard {

	public Festival() {
		super("Festival", 5);
	}

	@Override
	public void play(Player p) {
		p.incrementActions(2);
		p.incrementActions(1);
		p.incrementMoney(2);
		p.addToDiscard(this); // place la carte dans la défausse une fois jouée
	}
}