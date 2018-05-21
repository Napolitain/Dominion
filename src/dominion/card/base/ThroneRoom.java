package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Salle du trône (Throne Room)
 * 
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends ActionCard {

	public ThroneRoom() {
		super("Throne Room", 4);
	}

	@Override
	public void play(Player p) {
		String input = p.chooseCard("Choisissez une carte action de votre main à jouer deux fois.", p.getActionCards(), false);
		p.getActionCards().getCard(input).play(p); // joue une carte sans défausser
		p.playCard(input); // joue une carte en défaussant
	}
}