package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NaiveBayesClassifier {

	//Probabilité de chaque mot de mail spam
	private Map<String, Double> spamWordsProb = new HashMap<>();
	//Probabilité de chaque mot de mail non spam
	private Map<String, Double> hamWordsProb = new HashMap<>();
	//Probabilité qu'un mail soit un spam
	private double spamProbability;
	//Probabilité qu'un mail ne soit pas un spam
	private double hamProbability;

	/*
	 * This method trains the model by computing the probabilities of occurence of words
	 * in spam and ham emails, as well as the probability of an email being spam or ham
	 * @param trainingData list of Mail objects
	 */
	public void train(List<Mail> trainingData) {
		int spamCount = 0;
		int hamCount = 0;
		Map<String, Integer> spamWordCount = new HashMap<>();
		Map<String, Integer> hamWordCount = new HashMap<>();
		for (Mail email : trainingData) {
			String[] words = email.getContent().split("\\s+");
			if (email.isSpam()) {
				spamCount++;
				for (String word : words) {
					spamWordCount.put(word, spamWordCount.getOrDefault(word, 0) + 1);
				}
			} else {
				hamCount++;
				for (String word : words) {
					hamWordCount.put(word, hamWordCount.getOrDefault(word, 0) + 1);
				}
			}
		}

		//P(word|spam) = (n_word_spam + 1) / (n_spam)
		for (String word : spamWordCount.keySet()) {
			spamWordsProb.put(word, (double)(spamWordCount.get(word) +1 ) / (spamCount));
		}

		//P(word|nonspam) = (n_word_nonspam + 1) / (n_nonspam)
		for (String word : hamWordCount.keySet()) {
			hamWordsProb.put(word, (double)(hamWordCount.get(word) +1 ) / (hamCount));
		}

		if (!trainingData.isEmpty()) {
			//P(spam) = n_spam / (n_spam + n_nonspam)
			spamProbability = (double) spamCount / trainingData.size();
			//P(nonspam) = n_nonspam / (n_spam + n_nonspam)
			hamProbability = (double) hamCount / trainingData.size();
		} else {
			spamProbability = 0.0;
			hamProbability = 0.0;
		}

	}

	/*
     * This method predicts whether a given list of Mail objects contains spam
     * or ham emails by calculating the scores for each email and comparing them
     * @param realData a list of Mail objects to be used for prediction
     * @return String containing the number of spam and ham emails in the list
     */
    public String predict(List<Mail> realData) {
    	int spamNumber = 0;
    	int hamNumber = 0;
    	for (Mail mail : realData) {
		    double spamScore = spamProbability;
		    double hamScore = hamProbability;
		    String[] words = mail.getContent().split("\\s+");
		    for (String word : words) {
		    	if (spamWordsProb.containsKey(word)) {
		    		spamScore *= spamWordsProb.get(word);
		    	}

		    	if (hamWordsProb.containsKey(word)) {
		    		hamScore *= hamWordsProb.get(word);
		    	}
		    }
			if (spamScore > hamScore) {
				spamNumber++;
			} else {
				hamNumber++;
			}
    	}
	    return "LaPlace : The number of spam mail is : " + spamNumber + "\nLaPlace : The number of ham mail is : " + hamNumber;
    }
    
}
