package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Bibliothèque (Library)
 * 
 * Piochez jusqu'à ce que vous ayez 7 cartes en main. Chaque carte Action piochée peut être mise de côté. Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
 */
public class Library extends ActionCard {

	public Library() {
		super("Library", 5);
	}

	@Override
	public void play(Player p) {
		CardList actionCards = new CardList();
		Card c;
		String input;
		List<String> choices = Arrays.asList("o", "n");
		while (p.cardsInHand().size() < 7) {
			c = p.drawCard();
			if (c == null) {
				System.err.println("Il n'y a pas de carte à piocher (pioche et défausse vide).");
				return;
			}
			p.addToHand(c);
			if (c.getTypes().contains(CardType.Action)) {
				actionCards.add(c);
			}
		}
		for (c: actionCards) {
			input = p.choose("Voulez vous défausser")
		}
	}
}