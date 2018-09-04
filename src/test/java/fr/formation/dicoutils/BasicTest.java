package fr.formation.dicoutils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BasicTest {
	private DicoLoader loader;
	private InputStream is;
	
	@Before
	public void initialize() {
		this.loader = new ClasspathDicoLoader();
		this.is = this.getClass().getResourceAsStream("/dictionnaire.txt");		
	}
	
	@Before
	public void destroy() throws IOException {
		this.is.close();
	}
	
	@Test
	public void firstTest() {
		Assert.assertNotNull("Le fichier n'existe pas",this.is);
		String[] results = loader.loadFile(this.is);	
		Assert.assertNotNull("Lecture du fichier KO",results);
		Assert.assertEquals("Le fichier pas bon nb mots", 336532, results.length);
	}

	@Test
	public void advancedTest() {
		if (this.is != null) {
			String[] results = loader.loadFile(this.is);	
			Assert.assertThat(Arrays.asList(results),CoreMatchers.hasItem("super"));
		}			
	}
}
