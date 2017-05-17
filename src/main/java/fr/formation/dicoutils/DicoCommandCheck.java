package fr.formation.dicoutils;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite permettant de factoriser/regrouper le code de parcourt du
 * dictionnaire, afin d'effectuer une vérification (méthode check) sur chaque
 * mot et décider si il fait partie des résultats à afficher à l'utilisateur.
 * 
 * @author Arcanis
 *
 */
public abstract class DicoCommandCheck extends DicoCommand {

	/**
	 * La présence de ce constructeur est obligatoire même si elle ne sera
	 * jamais utilisée avec "new DicoCommandCheck(name)". En effet la classe est
	 * abstraite, mais le constructeur est nécessaire pour que les classes
	 * enfant puissent être construites.
	 * 
	 * @param name
	 *            le nom de la commande à afficher dans le menu.
	 */
	public DicoCommandCheck(String name) {
		super(name);
	}

	/**
	 * {@inheritDoc} Parcourt des mots du dictionnaire, pour chaque mot la
	 * méthode check() est appelée pour vérifier si le mot fait partie des
	 * résultats attendus.
	 */
	@Override
	public void run() {
		final List<String> results = new ArrayList<>();
		final String search = DicoMenu.readInput("Saisissez une chaîne à rechercher : ");
		for (final String word : DicoCommand.DICO) {
			if (this.check(search, word)) {
				results.add(word);
			}
		}
		if (results.isEmpty()) {
			DicoCommand.LOGGER.info("Aucun résultats pour cette recherche.");
		} else {
			DicoCommand.LOGGER.info("Résultats de la recherche : ".concat(results.toString()));
		}
	}

	/**
	 * Méthode abstraite qui sera implémentée dans les classes enfant pour
	 * chaque fonctionnalité différente.
	 * 
	 * @param pattern la chaîne de caractères saisie par l'utilisateur.
	 * @param word le mot du dictionnaire à vérifier.
	 * @return boolean vrai si le mot fait partie des résultats à afficher.
	 */
	protected abstract boolean check(final String pattern, final String word);

}
