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

        CardList trash = new CardList(); // Liste de carte poubelle
        CardList playerTreasureList = new CardList(); // Liste des cartes Treasure piochés par les adversaires
        CardList choiceTreasureList = new CardList(); //Liste des cartes Treasure non écartées par le joueur

        for (Player a : p.otherPlayers()) { //Pour chaque adversiare
            for (int i = 0; i < 2; i++) { //on fait piocher 2 fois
                Card c = a.drawCard();
                if (c instanceof TreasureCard) { //Si la carte pioché est une carte Trésor
                    playerTreasureList.add(c); //on ajoute la carte a la liste de carte trésor
                } else {
                    a.addToDiscard(c); //sinon on la défausse
                }
            }
            if (playerTreasureList.size() > 1) { // Si l'adversaire a pioché 2 cartes trésor
                String input = p.chooseCard("Quelle carte voulez vous écarter ?", playerTreasureList, false); //On demande laquelle il veut écarter
                choiceTreasureList.add(choiceTreasureList.getCard(input)); //on ajoute la carte écarté à la liste des cartes choisis
                playerTreasureList.remove(input); // [facultatif] on enlève la carte de la card list
            } else if (playerTreasureList.size() == 1) { //Si l'adversaire a pioché 1 carte trésor
                choiceTreasureList.add(choiceTreasureList.get(0)); // on ajoute la carte à la liste de choix du joueur
            }
            CardList stockTreasure = new CardList(); //Création d'une liste de carte temporaire pour stocké 1 carte
            for (int z = 0; z < choiceTreasureList.size(); z++) {
                stockTreasure.add(choiceTreasureList.get(z)); //on ajoute les cartes une par une à la liste
                String input = p.chooseCard("Voulez vous garder cette carte ? o/n", stockTreasure, false);
                if (input == "o") { //si le joueur veut garder la carte
                    p.addToDiscard(choiceTreasureList.get(z)); // on ajoute la carte à sa défausse
                }
                else { //sinon on l'ajoute à une liste poubelle
                    trash.add(choiceTreasureList.get(z));
                }
            }
            playerTreasureList.clear(); //on vide la liste de carte pour passer au joueur suivant
            choiceTreasureList.clear(); //idem
        }
    }
}