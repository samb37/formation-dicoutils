package fr.formation.dicoutils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DicoMenu {

	private static final Logger LOGGER = LoggerFactory.getLogger(DicoMenu.class);
	private static final Scanner SCANNER = new Scanner(System.in);
	
	public static String readInput(final String message) {
		DicoMenu.LOGGER.info(message);
		String value = null;
		do {
			if (value != null && value.isEmpty()) {
				DicoMenu.LOGGER.error("Valeur saisie vide, recommencez la saisie :");
			}
			value = SCANNER.nextLine();
		} while (value.isEmpty());
		return value;
	}
	
	@Override
	protected void finalize() throws Throwable {
		SCANNER.close();
		// super.finalize();
	}

	/**
	 * Instance de la map.
	 */
	private Map<Integer, DicoCommand> menuItems;
	
	public DicoMenu() {
		this.menuItems = new HashMap<>();
		this.menuItems.put(1, new DicoCommandWord());
		this.menuItems.put(2, new DicoCommandSearch());
		this.menuItems.put(3, new DicoCommandExit());
	}

	public DicoCommand getCommand(final Integer menuItem) {
		return this.menuItems.get(menuItem);
	}

	/**
	 * Afficher le menu dans la console.
	 */
	public void display() {
		DicoMenu.LOGGER.info("Menu des fonctionnalités :");
		for (final Integer key : this.menuItems.keySet()) {
			final DicoCommand command = this.menuItems.get(key);
			DicoMenu.LOGGER.info("\t".concat(key.toString())
					.concat(" - ").concat(command.getName()));
		}
	}
}
