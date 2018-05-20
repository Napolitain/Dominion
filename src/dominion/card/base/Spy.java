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


    public Spy(){
        super("Spy", 4);
    }

    public void play(Player p) {

        p.addToHand(p.drawCard()); // on ajoute une carte pioché à la main du joueur
        p.incrementActions(1); // on donne +1 action au joueur
        CardList c = new CardList();
        c.add(p.drawCard()); //On génère une cardlist pour une carte
        String input = p.chooseCard("Voulez vous défausser cette carte ? o/n", c, false);
        if (input == "o") { //si le joueur veut défausser SA carte
            p.addToDiscard(input); //on ajoute à la défausse
            c.remove(input); //on enlève la carte de la cardlist
        } else { //si le joueur veut replacer sa carte dans son deck
            p.getDraw().add(0, c.get(0)); // on la rajoute en 1ère position
            c.remove(input); //on l'enlève de la cardlist
        }
        for (Player a : p.otherPlayers()) { // a est un adversaire, même principe qu'au dessus
            c.add(a.drawCard());
            String adinput = p.chooseCard("Voulez vous défausser cette carte ? o/n", c, false);
            if (adinput == "o") {
                a.addToDiscard(input);
                c.remove(input);
            } else {
                a.getDraw().add(0, c.get(0));
                c.remove(input);
            }
        }
    }
}