/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.regex.Pattern;

/**
 *
 * @author Patricio
 */
public class RegexMatcher {
    static String regex;
    
    
    public static boolean testcell(String cell){
        return Pattern.matches("[0-9]{10}", cell);
    }
    public static boolean testcedula(String CI){
        return Pattern.matches("[0-9]{10}", CI);
    }
    
    public static boolean emptyField(String field){
        return field.equals("");
    }
    public static boolean testMatricula(String matricula){
        return Pattern.matches("[0-9]{9}", matricula);
    }
    public static boolean testEmail(String email){
        return Pattern.matches("[A-Z0-9._%+-]+@[A-Z0-9-]+.+.[A-Z]{2,4}", email);
    }
    
}