package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Mine
 * 
 * Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ; ajoutez cette carte à votre main.
 */
public class Mine extends ActionCard {

	public Mine() {
		super("Mine", 5);
	}

	@Override
	public void play(Player p) {
		String input;
		Card card;
		CardList treasureCardPlusThree = new CardList();
		if (p.getTreasureCards().size() > 0) { // si il a au moins 1 carte trésor
			input = p.chooseCard("Écartez une carte Trésor de votre main.", p.getTreasureCards(), false);
			card = p.removeFromHand(input); // pas de trashed : même raison que pour Chapel
			for (Card c: p.getGame().availableSupplyCards()) {
				if ((c instanceof TreasureCard) && (c.getCost() <= card.getCost() + 3)) {
					treasureCardPlusThree.add(c);
				}
			}
			input = p.chooseCard("Choisissez une carte Trésor coûtant jusqu'à 3 pièces en plus.", treasureCardPlusThree, false);
			p.addToHand(p.getGame().removeFromSupply(input)); // on prend une carte de la réserve
		}
	}
}