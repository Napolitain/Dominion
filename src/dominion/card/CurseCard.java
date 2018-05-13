package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Malédiction
 */
public abstract class CurseCard extends Card {

	public CurseCard(String name, int cost) {
		super(name, cost);
	}

	@Override
	public void play(Player p) {
	}
}