package fr.formation.dicoutils;

import java.util.ArrayList;
import java.util.List;

public class DicoCommandSearch extends DicoCommand {

	public DicoCommandSearch() {
		super("Rechercher des mots");
	}

	@Override
	public void run() {
		final List<String> results = new ArrayList<>();
		final String search = DicoMenu.readInput("Saisissez une chaîne à rechercher : ");
		for (final String word : DicoCommand.DICO) {
			if (word.contains(search)) {
				results.add(word);
			}
		}
		if (results.isEmpty()) {
			DicoCommand.LOGGER.info("Aucun résultats pour cette recherche.");
		} else {
			DicoCommand.LOGGER.info("Résultats de la recherche : ".concat(results.toString()));			
		}
	}

}
