package fr.formation.dicoutils;

public class DicoCommandWord extends DicoCommand {

	public DicoCommandWord() {
		super("Vérifier la présence d'un mot exact");
	}

	@Override
	public void run() {
		String wrd = DicoMenu.readInput("Saisissez un mot : ");
		if (DicoCommand.DICO.contains(wrd)) {
			DicoCommand.LOGGER.info("Ce mot existe bien dans le dictionnaire !");
		} else {
			DicoCommand.LOGGER.info("Ce mot n'existe pas dans le dictionnaire...");
		}
	}
}
