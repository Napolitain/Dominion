package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Chancellier (Chancellor)
 * 
 * +2 Pièces.
 * Vous pouvez immédiatement défausser votre deck.
 */
public class Chancellor extends ActionCard {

	public Chancellor() {
		super("Chancellor", 3);
	}

	@Override
	public void play(Player p) {
		p.incrementMoney(2);
		List<String> choices = Arrays.asList("o", "n");
		String input = choose("Voulez-vous défausser votre deck ? o/n", choices, false);
		if (input.equals("o")) {
			for (Card c: p.totalCards()) {
				p.addToDiscard(c); // pas fini : addToDiscard remove une card de hand pas forcément de la ou elle est
			}
		}
	}
}