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
        System.out.println("Recevez une carte Argent; placez-la sur votre deck.");
        System.out.println("Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Vitoire).");
        p.gain("Silver");
        List<Player> adversaries = p.otherPlayers();
        for (int i = 0; i < adversaries.size(); i++) {
            String cardName = adversaries.get(i).chooseCard(adversaries.get(i).getName() + "...", adversaries.get(i).getVictoryCards(), false); // choisis la carte à montrer
            System.out.println("--> " + cardName);
            adversaries.get(i).
        }
    }
}