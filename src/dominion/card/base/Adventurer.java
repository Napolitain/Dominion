package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Aventurier (Adventurer)
 * 
 * Dévoilez des cartes de votre deck jusqu'à ce que 2 cartes Trésor soient dévoilées. Ajoutez ces cartes Trésor à votre main et défaussez les autres cartes dévoilées.
 */
public class Adventurer extends ActionCard {

    public Adventurer() {
        super("Adventurer", 6);
    }

    @Override
    public void play(Player p) {
		Card card;
		int treasureCount = 0;
		int totalCount = 0;
    	do {
			card = p.drawCard();
			if (!(card.getTypes().contains(CardType.Treasure))) {
				p.addToDiscard(card);
			} else {
				p.addToHand(card);
				treasureCount++;
			}
			totalCount++;
		} while ((treasureCount < 2) && (totalCount < p.deckWithoutInPlay().size()));
    }
}