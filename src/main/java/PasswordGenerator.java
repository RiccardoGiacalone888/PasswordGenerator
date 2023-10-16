//this class works as the backend and will generate the password

import java.util.Random;

public class PasswordGenerator {
    //characters pool
    //these strings will hold the characters,numbers,symbol that we are going to randomly pick to generate our password
    public static final String LOWERCASE_CHARACTERS ="abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_SYMBOL = "!@#$%^&*()-_=+[]{};:,.<>/?";


    //the random class allows us to generate a random number which will be used to randomly chose the character
    private final Random random;

    //constructor
    public PasswordGenerator(){random = new Random();}
    public String generatePassword(int length, boolean includeUpperCase,
                                   boolean includeLowerCase, boolean includeNumbers,
                                   boolean includeSpecialSymbols){
        //use string builder over string for better efficiency
        StringBuilder passwordBuilder = new StringBuilder();

        //store valid characters
        String validCharacters= "";
        if(includeUpperCase) validCharacters += UPPERCASE_CHARACTER;
        if(includeLowerCase) validCharacters += LOWERCASE_CHARACTERS;
        if (includeNumbers) validCharacters += NUMBERS;
        if (includeSpecialSymbols) validCharacters += SPECIAL_SYMBOL;

        //build password
        for (int i=0; i<length; i++){
            //generate random index
            int randomIndex = random.nextInt(validCharacters.length());

            //get the char based on the random index
            char randomChar = validCharacters.charAt(randomIndex);

            //store char into password builder
            passwordBuilder.append(randomChar);


        }

        //return the result
        return passwordBuilder.toString();
    }
}
