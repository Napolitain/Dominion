package dominion.card.base;
import java.util.*;
import dominion.*;
import dominion.card.*;

/**
 * Carte Douves (Moat)
 * 
 * +2 Cartes.
 * Lorsqu’un adversaire joue une carte Attaque, vous pouvez dévoiler cette carte de votre main. Dans ce cas, l’Attaque n’a pas d’effet sur vous.
 */
public class Moat extends ReactionCard {

	public Moat() {
		super("Moat", 2);
	}

	@Override
	public void play(Player p) {
		p.addToHand(p.drawCard());
		p.addToHand(p.drawCard());
	}

	/**
	 * Effet réaction de la carte Douve.
	 * @param p joueur (adversaire) ciblé par l'attaque
	 * @return un boolean, {@code true si le joueur se défend}
	 */
	@Override
	public boolean reaction(Player p) {
		List<String> choices = Arrays.asList("o", "n");
		String input = p.choose("Voulez vous jouer la carte Douve? o/n", choices, false);
		if (input.equals("o")) {
			System.out.println("Douve! Attaque évitée");
			return true;
		}
		return false;
	}
}