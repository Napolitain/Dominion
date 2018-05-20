package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Atelier (Workshop)
 * 
 * Recevez une carte coûtant jusqu'à 4 Pièces.
 */
public class Workshop extends ActionCard {

	public Workshop() {
		super("Workshop", 	3);
	}

	@Override
	public void play(Player p) {
		CardList cardsUnderFour = new CardList();
		for (Card c: p.getGame().availableSupplyCards()) {
			if (c.getCost() <= 4) {
				cardsUnderFour.add(c);
			}
		}
		String input = p.chooseCard("Recevez une carte coûtant jusqu'à 4 pièces.", cardsUnderFour, false);
		p.addToHand(p.getGame().removeFromSupply(input));
	}
}