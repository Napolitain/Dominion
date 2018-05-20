package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Trésor
 */
public abstract class TreasureCard extends Card {

	public TreasureCard(String name, int cost) {
		super(name, cost);
	}

	@Override
	public List<CardType> getTypes() {
		List<CardType> types = super.getTypes();
		types.add(CardType.Victory);
		return types;
	}

	public abstract int treasureValue(); // treasureValue est obligé d'exister donc play est obligé de fonctionné

	@Override
	public void play(Player p) {
		p.incrementMoney(treasureValue());
	}
}