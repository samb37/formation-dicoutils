package fr.formation.dicoutils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.stream.Collectors;

/**
 * Implémentation de DicoLoader par chargement depuis le classpath Java.
 */
public class ClasspathDicoLoader implements DicoLoader {

	/**
	 * {@inheritDoc} Lecture d'un fichier par son chemin dans le classpath.
	 */
	@Override
	public String[] loadFile(InputStream inputStream) {
		Reader reader = new InputStreamReader(inputStream);
		BufferedReader buffer = new BufferedReader(reader);
		return (String[]) buffer.lines().collect(Collectors.toList())
				.toArray(new String[0]);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
