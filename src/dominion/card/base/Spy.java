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
		List<Player> players = new ArrayList<Player>();
		players.addAll(p.otherPlayers());
		players.add(p);
		Card c;
		String input;
		List<String> choices = Arrays.asList("y", "n");
		for (Player player: players) { // tous les joueurs p compris
			if ((p == player) || (p != player && playerReact(p))) {
				c = player.drawCard();
				if (c != null) {
					input = player.choose("Voulez-vous défausser cette carte? y/n", choices, false);
					if (input.equals("y")) {
						player.addToDiscard(c);
					} else {
						player.addToDraw(c);
					}
				}
			}
		}
    }
}