import java.util.*;

class Problem804 {
    private static Hashtable<Character,String> morseCodeLookupTable;
    private static final int asciiValueofLowercaseA = 97;
    private static final int asciiValueofLowercaseZ = 122;
    private static List<String> morseCodeWordList;

    public int uniqueMorseRepresentations(String[] words) {
        if(morseCodeLookupTable == null) loadMorseCodeHashTable();
        morseCodeWordList = new ArrayList<>();
        for(String word : words){
            morseCodeWordList.add(getMorseCode(word));
        }
        return countUniqueMorseCodeinWordlist();
    }
    private String getMorseCode(String s){
        String morseCodeString = new String();
        for(char c : s.toCharArray()){
            morseCodeString = morseCodeString + morseCodeLookupTable.get(c);
        }
        return morseCodeString;
    }
    private int countUniqueMorseCodeinWordlist(){
        List<String> uniqueMorseCodeList = new ArrayList<>();
        int uniqueMorseCodeCount = 0;
        for(String morseCodeString : morseCodeWordList){
            if(!uniqueMorseCodeList.contains(morseCodeString)){
                uniqueMorseCodeList.add(morseCodeString);
                uniqueMorseCodeCount++;
            }
        }
        return uniqueMorseCodeCount;
    }
    private void loadMorseCodeHashTable(){
        String[] morseCodeStringArray = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-.."
                ,"--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        morseCodeLookupTable = new Hashtable<>(36);
        for(int i = asciiValueofLowercaseA; i <= asciiValueofLowercaseZ; i++){
            morseCodeLookupTable.put((char) i, morseCodeStringArray[i - asciiValueofLowercaseA]);
        }
    }
}
