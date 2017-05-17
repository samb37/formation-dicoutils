package fr.formation.dicoutils;

public class DicoCommandEndsWith extends DicoCommandCheck {

	public DicoCommandEndsWith() {
		super("Mot terminant par un suffixe");
	}

	/**
	 * {@inheritDoc} Fonctionnalité endsWith.
	 */
	@Override
	protected boolean check(String pattern, String word) {
		return word.endsWith(pattern);
	}

}
