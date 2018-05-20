package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Milice (Militia)
 * 
 * 2 Pièces.
 * Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.
 */
public class Militia extends AttackCard {

	public Militia() {
		super("Militia", 4);
	}

	@Override
	public void play(Player p) {
		p.incrementMoney(2); // +2 pieces
		String input;
		for (Player a: p.otherPlayers()) { // pour chaque adversaire
			while (a.cardsInHand().size() > 3) { // tant qu'il a plus de 3 cartes
				input = a.chooseCard("Choisissez une carte à défausser.", a.cardsInHand(), false);
				a.addToDiscard(input);
			}
		}
	}
}