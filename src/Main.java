import java.util.*;
import dominion.*;
import dominion.card.*;
import dominion.card.base.*;

/**
 * Classe pour l'exécution d'une partie de Dominion
 */
class Main {

	public static void main(String[] args) {
		// Noms des joueurs de la partie
		// (le nombre total de joueurs correspond au nombre de noms dans le 
		// tableau)
		String[] playerNames = new String[]{"Marco", "Polo"};

		// Prépare les piles "royaume" de la réserve (hors cartes communes)
		List<CardList> kingdomStacks = new ArrayList<CardList>();
		CardList stack;

		// Ajouter un bloc pour chaque carte royaume à utiliser
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Cellar()); // fait
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Market()); // fait
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Militia()); // fait
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Mine()); // fait
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Moat()); // fait
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Remodel()); // fait
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Smithy()); // fait
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Village()); // fait
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Woodcutter()); // fait
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Workshop()); // fait
		}
		kingdomStacks.add(stack);

		// Instancie et exécute une partie
		Game g = new Game(playerNames, kingdomStacks);
		g.run();
	}

}