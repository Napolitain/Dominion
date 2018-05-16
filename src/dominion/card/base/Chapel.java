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
		int i = 0;
		do {
			input = p.chooseCard("Écartez jusqu'à 4 cartes de votre main.", p.cardsInHand(), true);
			p.cardsInHand().remove(input); // on a choisi de ne pas mettre les cartes dans trashedCards car elles ne serviront plus; donc on laisse explicitement le garbage collector s'en occuper (solution acceptée)
			i++;
		} while (!input.equals("") && i < 4);
		p.addToDiscard(this); // place la carte dans la défausse une fois jouée
	}
}