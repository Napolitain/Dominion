package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Chapelle (Chapel)
 * 
 * Écartez jusqu'à 4 cartes de votre main.
 */
public class Chapel extends ActionCard {

	public Chapel() {
		super("Chapel", 2);
	}

	@Override
	public void play(Player p) {
		String input;
		do {
			input = p.chooseCard("Écartez jusqu'à 4 cartes de votre main.", p.cardsInHand(), true);
			p.cardsInHand().remove(input);
			p.getGame().t
		} while (input.equals(""));
	}
}