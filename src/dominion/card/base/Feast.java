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
		p.removeFromInPlay(this);
		CardList choice = new CardList();
		for (Card c: p.getGame().availableSupplyCards()) {
			if (c.getCost() <= 5) {
				choice.add(c);
			}
		}
		String input = p.chooseCard("Recevez une carte coûtant jusqu'à 5 pièces.", choice, false);
		p.gain(input);
	}
}