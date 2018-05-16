package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Rénovation (Remodel)
 * 
 * Écartez une carte de votre main.
 * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.
 */
public class Remodel extends ActionCard {

	public Remodel() {
		super("Remodel", 4);
	}

	@Override
	public void play(Player p) {
		String input = p.chooseCard("Écartez une carte de votre main.", p.cardsInHand(), false);
		Card card = p.cardsInHand().remove(input); // (avec int cost = p.cardsInHands().remove(input).getCost() on pourrait avoir un NullPointerException)
		CardList availableCardsPlusTwo = p.getGame().availableSupplyCards();
		for (Card c: p.getGame().availableSupplyCards()) {
			if (c.getCost() <= card.getCost() + 2) {
				availableCardsPlusTwo.add(c);
			}
		}
		input = p.chooseCard("Recevez une carte coûtant jusqu'à 2 pièces de plus que la carte écartée.", availableCardsPlusTwo, false);
		p.addToHand(p.getGame().removeFromSupply(input)); // reçoit une carte de la réserve
		p.addToDiscard(this); // défausse la carte jouée
	}
}