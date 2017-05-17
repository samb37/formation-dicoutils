package fr.formation.dicoutils;

public class DicoCommandStartsWith extends DicoCommandCheck {

	public DicoCommandStartsWith() {
		super("Mot commençant par un préfixe");
	}

	/**
	 * {@inheritDoc} Fonctionnalité startsWith.
	 */
	@Override
	protected boolean check(String pattern, String word) {
		return word.startsWith(pattern);
	}

}
