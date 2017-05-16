package fr.formation.dicoutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DicoUtils implements Runnable {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DicoUtils.class);
	public static boolean RUNNING = true; 

	public static void main(String[] args) {
		new DicoUtils().run();
	}

	@Override
	public void run() {
		DicoCommand.readDico();
		final DicoMenu menu = new DicoMenu();
		while (DicoUtils.RUNNING) {
			menu.display();
			// Tant que saisi utilisateur invalide, demander la saisie d'une fonction.
			boolean inputOk = false;
			int menuItem = 0;
			while (!inputOk) {
				final String strMenuItem = DicoMenu.readInput("Choisissez une foncionnalité : ");
				try {
					menuItem = Integer.parseInt(strMenuItem);
					if (menuItem > 0 && menu.hasMenuKey(menuItem)) {
						inputOk = true;						
					} else {
						DicoUtils.LOGGER.error("Saisie invalide, le nombre doit correspondre à un item du menu.");
					}
				} catch (final NumberFormatException e) {
					DicoUtils.LOGGER.error("Saisie invalide, veuillez recommencer...");
				}
			}
			final DicoCommand command = menu.getCommand(menuItem);
			command.run();
		}
	}
}
