package fr.formation.dicoutils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DicoCommandRegex extends DicoCommand {

	public DicoCommandRegex() {
		super("Recherche par expression régulière");
	}

	@Override
	public void run() {
		final String regex = DicoMenu.readInput("Saisir une expression : ");
		final Pattern pattern = Pattern.compile("(".concat(regex).concat("[^ ]*)"));
		final String allwords = String.join(" ", DicoCommand.DICO);
		final Matcher matcher = pattern.matcher(allwords);
		
		DicoCommand.LOGGER.info("Recherche de correspondances :");
		int i = 0;
		while (matcher.find()) {
			final String word = matcher.group(1);
			DicoCommand.LOGGER.info(word);
			++i;
		}
		DicoCommand.LOGGER.info("Nombre de correspondances trouvées : " + i);
	}

}
