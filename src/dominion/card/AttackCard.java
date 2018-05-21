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

	/**
	 * On check si le joueur peut et veut réagir
	 * @param p
	 * @return boolean {@code true si le joueur réagit}
	 */
	public boolean playerReact(Player p) {
    	boolean flag = false; // valeur par défaut
    	for (Card c: p.cardsInHand()) {
    		if (c.getTypes().contains(CardType.Attack) && flag == false) { // si la carte est une carte réaction
    			flag = ((ReactionCard) c).reaction(p); // on cast la carte (qui est une reaction d'après le if) pour appliquer la méthode reaction retournant un boolean
			} // si le boolean est vrai on stop et on return, sinon on attend (au cas ou il veut réagir avec une autre carte)
		}
		return flag;
	}
}