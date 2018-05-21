package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Voleur (Thief)
 * 
 * Tous vos adversaires dévoilent les 2 premières cartes de leur deck. S'ils dévoilent des cartes Trésor, ils en écartent 1 de votre choix. Parmi ces cartes Trésor écartées, recevez celles de votre choix. Les autres cartes dévoilées sont défaussées.
 */
public class Thief extends AttackCard {

    public Thief() {

        super("Thief", 4);
    }

    public void play(Player p) {
    	CardList trashCards = new CardList();
    	for (Player a: p.otherPlayers()) {
    		if (!playerReact(a)) {
    			CardList cards = new CardList();
    			for (int i = 0; i < 2; i++) {
    				Card c = a.drawCard();
    				if (c != null) {
    					cards.add(c);
					} else {
						System.err.println("Pioche vide.");
					}
				}
				System.out.println(cards);
    			for (Card c: cards) { // pour chaque carte qui n'est pas une trésor on la défausse
    				if (!c.getTypes().contains(CardType.Treasure)) {
    					a.gain(cards.remove(c.getName()));
					}
				}
				if (cards.isEmpty()) {
					System.out.println("Il n'y a pas de cartes Trésor à voler");
				} else { // sinon s'il y a des cartes trésor
    				String input = p.chooseCard("Défaussez-lui une carte.", cards, false);
    				trashCards.add(cards.getCard(input));
    				cards.remove(input);
				}
				if (!cards.isEmpty()) { // on rajoute l'autre carte Trésor non écarté à la défausse
    				a.gain(cards.get(0));
				}
			}
		}
		boolean choice = true;
    	String input;
		while (!trashCards.isEmpty() && choice == true) {
			input = p.chooseCard("Choisissez une carte à recevoir", trashCards, true);
			if (input.equals("")) {
				choice = false;
			} else {
				p.gain(trashCards.getCard(input));
				trashCards.remove(input);
			}
		}
		// On écarte le reste
		while (!trashCards.isEmpty()) {
			trashCards.clear();
		}
    }
}