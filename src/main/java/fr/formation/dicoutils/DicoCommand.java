package fr.formation.dicoutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class DicoCommand implements Runnable {

	protected static final Logger LOGGER = LoggerFactory.getLogger(DicoCommand.class);
	private static final boolean USE_CLASSPATH = false;
	private static final String DICO_PATH_SYSTEM = "D:/workspaces/java_nantes/formation-dicoutils/src/main/resources/dictionnaire.txt";
	protected static final List<String> DICO = new ArrayList<String>();

	public static void readDico() {
		if (DicoCommand.USE_CLASSPATH) {
			// DicoCommand.readDicoClasspath();
		} else {
			DicoCommand.readDicoSystem();
		}
	}

	private static void readDicoSystem() {
		final File dicoFile = new File(DicoCommand.DICO_PATH_SYSTEM);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(dicoFile));
			String line = null;
			do {
				line = reader.readLine();
				if (line != null) {
					DicoCommand.DICO.add(line);
				}
			} while (line != null);
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String name;
	
	public DicoCommand(final String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
