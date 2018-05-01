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
			stack.add(new Cellar());
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Market());
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Militia());
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Mine());
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Moat());
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Remodel());
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Smithy());
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Village());
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Woodcutter());
		}
		kingdomStacks.add(stack);
		stack = new CardList();
		for (int i = 0; i < 10; i++) {
			stack.add(new Workshop());
		}
		kingdomStacks.add(stack);
		System.out.println(kingdomStacks.toString());

		// Instancie et exécute une partie
		Game g = new Game(playerNames, kingdomStacks);
		g.run();
	}

}