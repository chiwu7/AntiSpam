package test;

import static org.junit.jupiter.api.Assertions.*;
import model.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class TestClassifier {

	@Test
	public void trainWithZeroMail() {
	    NaiveBayesClassifier classifier = new NaiveBayesClassifier();
	    List<Mail> trainingData = Collections.emptyList();
	    classifier.train(trainingData);
	    Map<String, Double> expectedSpamWordCounts = new HashMap<>();
	    Map<String, Double> expectedHamWordCounts = new HashMap<>();
	    assertEquals(expectedSpamWordCounts, classifier.getSpamWordsProb());
	    assertEquals(expectedHamWordCounts, classifier.getHamWordsProb());
	    assertEquals(0.0, classifier.getSpamProbability(), 0.001);
	    assertEquals(0.0, classifier.getHamProbability(), 0.001);
	}
	
	@Test
    public void trainWithOneMail() {
		NaiveBayesClassifier classifier = new NaiveBayesClassifier();
        List<Mail> trainingData = Arrays.asList(
                new Mail("This is a spam email", true)
        );
        classifier.train(trainingData);
        Map<String, Double> expectedSpamWordCounts = new HashMap<>();
        expectedSpamWordCounts.put("This", 2.0);
        expectedSpamWordCounts.put("is", 2.0);
        expectedSpamWordCounts.put("a", 2.0);
        expectedSpamWordCounts.put("spam", 2.0);
        expectedSpamWordCounts.put("email", 2.0);
        assertEquals(expectedSpamWordCounts, classifier.getSpamWordsProb());

        Map<String, Double> expectedHamWordCounts = new HashMap<>();
        assertEquals(expectedHamWordCounts, classifier.getHamWordsProb());

        assertEquals(1.0, classifier.getSpamProbability(), 0.001);
        assertEquals(0.0, classifier.getHamProbability(), 0.001);
    }

	@Test
    public void trainWithTwoMails() {
		NaiveBayesClassifier classifier = new NaiveBayesClassifier();
		List<Mail> trainingData = Arrays.asList(
				new Mail("This is a spam email", true),
				new Mail("This is a ham email", false)
				);
		classifier.train(trainingData);
		Map<String, Double> expectedSpamWordCounts = new HashMap<>();
		expectedSpamWordCounts.put("This", 2.0);
		expectedSpamWordCounts.put("is", 2.0);
		expectedSpamWordCounts.put("a", 2.0);
		expectedSpamWordCounts.put("spam", 2.0);
		expectedSpamWordCounts.put("email", 2.0);
		assertEquals(expectedSpamWordCounts, classifier.getSpamWordsProb());

		Map<String, Double> expectedHamWordCounts = new HashMap<>();
		expectedHamWordCounts.put("This", 2.0);
		expectedHamWordCounts.put("is", 2.0);
		expectedHamWordCounts.put("a", 2.0);
		expectedHamWordCounts.put("ham", 2.0);
		expectedHamWordCounts.put("email", 2.0);
		assertEquals(expectedHamWordCounts, classifier.getHamWordsProb());

		assertEquals(0.5, classifier.getSpamProbability(), 0.001);
		assertEquals(0.5, classifier.getHamProbability(), 0.001);
    }
}
