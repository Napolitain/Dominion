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

    public Library(){
        super ("Library", 5);
    }

    public void play(Player p){
        /*List<String> choices = Arrays.asList("y", "n");
        String input;
        while (p.cardsInHand().size() < 7){
            Card c = p.drawCard();
            if (c == null) {
                System.err.println("Il n'y a pas de carte à piocher (pioche et défausse vide).");
                return;
            }
            p.addToHand(c);
            if (c instanceof ActionCard) {
                input = p.chooseCard("Voulez vous défausser cette carte ? o/n", choices, false);
                if (input.equals("o")) {
                    p.addToDiscard(c);
                    p.cardsInHand().remove(c);
                }
            }
        }*/
    }
}