package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Bureaucrate (Bureaucrat)
 * 
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends AttackCard {

    public Bureaucrat() {
        super("Bureaucrat", 4);
    }

    @Override
    public void play(Player p) {
    	if (p.getGame().getFromSupply("Silver") == null) {
			System.err.println("Il n'y a pas de carte Silver.");
			return;
		}
        p.addToDraw(p.getGame().removeFromSupply("Silver"));

    	for (Player a: p.otherPlayers()) { // a est un adversaire
        	if (!playerReact(a)) {
        		CardList victory = a.getVictoryCards();
				if (victory.isEmpty()) {
					System.out.println(a.cardsInHand().toString()); // dévoile le jeu entier
				} else {
					String input = a.chooseCard("Dévoilez une carte", a.getVictoryCards(), false);
					System.out.println(input);
					a.placeOnDraw(input);
				}
			}
		}
    }
}