package fr.formation.dicoutils;

public class DicoCommandExit extends DicoCommand {

	public DicoCommandExit() {
		super("Quitter l'application");
	}

	@Override
	public void run() {
		DicoCommand.LOGGER.info("Quitter l'application");
		DicoUtils.RUNNING = false;
	}

}
