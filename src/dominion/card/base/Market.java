package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Marché (Market)
 * 
 * +1 Carte.
 * +1 Action.
 * +1 Achat.
 * +1 Pièce.
 */
public class Market extends ActionCard {

	public Market() {
		super("Market", 5);
	}

	@Override
	public void play(Player p) {
		p.addToHand(p.drawCard()); // +1 carte
		p.incrementActions(1); // +1 action
		p.incrementBuys(1); // +1 achat
		p.incrementMoney(1); // +1 piece
		p.addToDiscard(this); // on défausse la carte jouée
	}
}