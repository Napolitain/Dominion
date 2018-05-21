package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Espion (Spy)
 * 
 * +1 Carte.
 * +1 Action.
 * Tous les joueurs (vous aussi) dévoilent la première carte de leur deck. Vous décidez ensuite si chaque carte dévoilée est défaussée ou replacée sur son deck.
 */
public class Spy extends AttackCard {


    public Spy() {
        super("Spy", 4);
    }

    public void play(Player p) {
    	p.addToHand(p.drawCard());
    	p.incrementActions(1);
    	action(p);
    	for (Player a: p.otherPlayers()) {
    		if (!playerReact(a)) {
				action(a);
			}
		}
    }

    public void action(Player p) {
		Card c = p.drawCard();
		List<String> choices = Arrays.asList("y", "n");
		if (c != null) {
			String input = p.choose("Voulez-vous défausser la carte " + c.getName() + "? y/n", choices, false);
			if (input.equals("y")) {
				p.addToDiscard(c);
			} else {
				p.addToDraw(c);
			}
		}
	}
}