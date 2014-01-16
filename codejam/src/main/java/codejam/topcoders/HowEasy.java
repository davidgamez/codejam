package codejam.topcoders;

/**
 * Please find the description of the problem in HowEasy.txt
 *
 * @author David Gamez Diaz
 *
 */
public class HowEasy{
	public static int pointVal(String problemStatement){
		int result = 0;
		if (problemStatement != null){
			int wordLengthAverage = getWordAverageLength(problemStatement);
			if (wordLengthAverage > 0){
				if (wordLengthAverage <= 3){
					result = 250;
				}else{
					if (wordLengthAverage > 3 && wordLengthAverage <= 5){
						result = 500;
					}else{
						result = 1000;
					}
				}
			}
		}
		return result;
	}

	private static int getWordAverageLength(String problemStatement){
		int result = 0;
		int index = 0;
		int wordCount = 0;
		int wordLength = 0;
		while (true){
			if (index >= problemStatement.length()){
				break;
			}
			int currentWordLength = 0;
			while (index < problemStatement.length() && !isSeparator(problemStatement.charAt(index))){
				currentWordLength++;
				index++;
			}
			if (currentWordLength != 0){
				wordCount++;
				if (index < problemStatement.length() && problemStatement.charAt(index) == '.'){
					currentWordLength++;
				}
				wordLength += currentWordLength;
			}
			index++;
		}
		if (wordCount > 0){
			result = wordLength/wordCount;
		}
		return result;
	}

	private static  boolean isSeparator(char separator){
		return separator == '.' || separator == ' ';
	}
}