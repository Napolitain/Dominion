package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Victoire
 */
public abstract class VictoryCard extends Card {

	public VictoryCard(String name, int cost) {
		super(name, cost);
	}

	/**
	 * Une carte Victoire renvoit des
	 *
	 * @param p joueur qui possède la carte (la valeur d'une carte peut dépendre du joueur qui la possède, c'est le cas des cartes Gardens)
	 *
	 * Toutes les cartes qui ne sont pas de type Victoire ont une valeur de 0
	 * (la méthode devra donc être redéfinie pour les cartes ayant une valeur
	 * @return
	 */
	@Override
	public int victoryValue(Player p) {
		return 0;
	}

	@Override
	public void play(Player p) {

	}
}