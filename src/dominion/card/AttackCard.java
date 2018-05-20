package dominion.card;
import java.util.*;
import dominion.*;

/**
 * Les cartes Attaque
 * Rmq: les cartes Attaque sont toutes des cartes Action
 */
public abstract class AttackCard extends ActionCard {

    public AttackCard(String name, int cost) {
        super(name, cost);
    }

	@Override
	public List<CardType> getTypes() {
    	List<CardType> types = super.getTypes(); // action + attack (stack)
    	types.add(CardType.Attack);
    	return types;
	}

	@Override
	public void play(Player p) {

	}
}