package fr.formation.dicoutils;

public class DicoUtils implements Runnable {
	
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
			final String strMenuItem = DicoMenu.readInput("Choisissez une foncionnalité : ");
			// FIXME : Attention, la méthode parseInt peut lever une NumberFormatException.
			final int menuItem = Integer.parseInt(strMenuItem);
			final DicoCommand command = menu.getCommand(menuItem);
			command.run();
		}
	}
}
