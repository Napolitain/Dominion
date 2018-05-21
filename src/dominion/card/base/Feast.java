package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Festin (Feast)
 * 
 * Écartez cette carte.
 * Recevez une carte coûtant jusqu'à 5 Pièces.
 */
public class Feast extends ActionCard {

	public Feast() {
		super("Feast", 4);
	}

	@Override
	public void play(Player p) {
		String input = p.chooseCard("Recevez une carte coûtant jusqu'à 5 pièces.", p.getGame().availableSupplyCards(), false);
		for (Card c: p.getGame().availableSupplyCards()) {
			if (c.getName() == input && c.getCost() <= 5) {
				p.gain(c); // gagne une carte
				p.removeFromHand(c); // écarte cette carte
				return;
			}
		}
	}
}