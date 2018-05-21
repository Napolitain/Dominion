package dominion.card.base;

import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Cave (Cellar)
 * 
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends ActionCard {

	public Cellar() {
		super("Cellar", 2);
	}

	@Override
	public void play(Player p) {
		p.incrementActions(1); // +1 action
		String input; // défaussez autant de cartes que vous voulez
		CardList cards = new CardList();
		do {
			input = p.chooseCard("Défaussez autant de cartes que vous le voulez.", p.cardsInHand(), true);
			if (!input.equals("")) {
				Card c = p.removeFromHand(input);
				p.addToDiscard(c);
				cards.add(p.drawCard());
			}
		} while (!input.equals("") && !p.cardsInHand().isEmpty()); // tant que ya une input et des cartes en main
		p.addToHand(cards); // on a rajouté une méthode qui prend en compte les cardlist
	}
}