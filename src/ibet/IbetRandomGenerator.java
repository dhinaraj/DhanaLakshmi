package ibet;

import java.util.Arrays;
import java.util.Random;

public class IbetRandomGenerator {

	public static void main(String[] args) {
		
		generate2RandomNumberInGivenSet();

		
	}
	
	public static void generate2RandomNumberInGivenSet() {

		String randomNumber = "";
		String[] randomNumberArray = new String[10];

		for (int x = 0; x < randomNumberArray.length; x++) {
			boolean resetRegenerateFlag = true;
			while (resetRegenerateFlag) {
				for (int i = 1; i <= 4; i++) {
					randomNumber = randomNumber + getRandomNumberInRange(0, 9);
				}

				for (int j = 0; j < randomNumberArray.length; j++) {
					Inner_LOOP: if (CheckIfSameCharactersPresent(randomNumberArray[j], randomNumber)) {
						resetRegenerateFlag = true;
						randomNumber = "";
						break Inner_LOOP;

					}
					else
					{
						resetRegenerateFlag = false;
					}

				}
				
				if(!resetRegenerateFlag)
				{
					randomNumberArray[x]=randomNumber;
					randomNumber="";
				}

			}

		}
		
		System.out.println(Arrays.toString(randomNumberArray));

	}
	
	private static int getRandomNumberInRange(int min, int max) {
		
		int randomNumber;

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		
		

		Random r = new Random();
		
		randomNumber = r.nextInt((max - min) + 1) + min;
		return  randomNumber;
		
		
	}
	
	private static boolean CheckIfSameCharactersPresent(String s1, String s2) {

		if(s1==null)
		{
			System.out.println(false);
			return false;
		}
		

		else
		{
			char[] chars1 = s1.toCharArray();
			char[] chars2 = s2.toCharArray();
			Arrays.sort(chars1);
			Arrays.sort(chars2);
			
			System.out.println(Arrays.equals(chars1, chars2));
			
			return Arrays.equals(chars1, chars2);
		}
		
	}
	
	



}
