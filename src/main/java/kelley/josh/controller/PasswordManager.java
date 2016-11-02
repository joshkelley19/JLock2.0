package kelley.josh.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by joshuakelley on 11/1/16.
 */
public class PasswordManager {
    protected static String createPasswordScheme(int length){
        StringBuilder passwordScheme = new StringBuilder();
        for (int i = 0;i < length;i++){
            passwordScheme.append(getLetter((int) Math.floor(Math.random()*2.99)));
        }
        return passwordScheme.toString();
    }

    protected static String createCustomPasswordScheme(int[] specs){
        StringBuilder passwordScheme = new StringBuilder("");
        if(!validSpecs(specs))return passwordScheme.toString();
        passwordScheme.append(setScheme(specs[0],'R'));
        passwordScheme.append(setScheme(specs[1],'N'));
        passwordScheme.append(setScheme(specs[2],'!'));
        char[] chars = passwordScheme.toString().toCharArray();
        List<Character> bigChars = Arrays.asList(convertToCharacterArray(chars));
        Collections.shuffle(bigChars);
        chars = convertToCharArray((Character[])bigChars.toArray());
        return new String(chars);
    }

    private static boolean validSpecs(int[] specs) {
        if(specs.length!=2)return false;
        for (int num: specs){
            if(num<1||num>Integer.MAX_VALUE)return false;
        }
        return true;
    }

    private static String setScheme(int amount, char schemeLetter){
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i < amount;i++){
            builder.append(schemeLetter);
        }
        return builder.toString();
    }

    private static Character[] convertToCharacterArray(char[] scheme){
        Character[] schemeArray = new Character[scheme.length];
        for (int i = 0;i < scheme.length;i++) {
            schemeArray[i] = new Character(scheme[i]);
        }
        return schemeArray;
    }

    private static char[] convertToCharArray(Character[] scheme){
        char[] schemeArray = new char[scheme.length];
        for (int i = 0;i < scheme.length;i++){
            schemeArray[i] = scheme[i];
        }
        return schemeArray;
    }

    private static char getLetter(int option){
        switch (option){
            case 1: return 'R';
            case 2: return 'N';
            case 3: return '!';
            default:return 0;
        }
    }
}
