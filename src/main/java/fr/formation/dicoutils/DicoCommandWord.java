package fr.formation.dicoutils;

public class DicoCommandWord extends DicoCommand {

	public DicoCommandWord() {
		super("Vérifier présence d'un mot");
	}

	@Override
	public void run() {
		String wrd = DicoMenu.readInput("mot : ");
		if (DicoCommand.DICO.contains(wrd)) {
			DicoCommand.LOGGER.info("Y");
		} else {
			DicoCommand.LOGGER.info("N");
		}
	}
}
