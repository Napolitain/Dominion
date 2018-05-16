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
        p.addToHand(p.getGame().removeFromSupply("Silver"));
        for (Player a: p.otherPlayers()) { // a est un adversaire
        	if (a.getVictoryCards().size() == 0) {
				System.out.println(a.cardsInHand().toString()); // dévoile le jeu entier
			} else {
        		String input = p.chooseCard("Dévoilez une carte", p.getVictoryCards(), false);
				System.out.println(input);
				p.getDraw().add(0, p.getVictoryCards().remove(input)); // enlève place la carte de sa main sur le haut de sa pioche
			}
		}
        p.addToDiscard(this); // défausse la carte jouée
    }
}