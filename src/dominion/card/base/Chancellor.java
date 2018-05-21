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
		Card c;
		List<String> choices = Arrays.asList("y", "n");
		String input = p.choose("Voulez-vous défausser votre deck ? y/n", choices, false);
		if (input.equals("y")) {
			p.discardDeck();
		}
	}
}