package fr.formation.dicoutils;

public class DicoCommandSearch extends DicoCommandCheck {

	/**
	 * Constructeur faisant appel au constructeur de DicoCommandCheck.
	 */
	public DicoCommandSearch() {
		super("Rechercher des mots");
	}

	/**
	 * {@inheritDoc} Fonctionnalité contains.
	 */
	@Override
	protected boolean check(String pattern, String word) {
		return word.contains(pattern);
	}

}
