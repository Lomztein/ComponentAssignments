/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lomztein.assignments.core;

import com.lomztein.assignments.dictionaryservice.DictionaryService;

/**
 *
 * @author Lomztein
 */
public class Main {
    
    public static void main (String[] args) {
        
        DictionaryService dict = DictionaryService.getInstance();
        System.out.println (lookup (dict, "book"));
        System.out.println (lookup (dict, "editor"));
        System.out.println (lookup (dict, "xml"));
        System.out.println (lookup (dict, "rest"));
        System.out.println (lookup (dict, "booty"));
        
    }
    
    public static String lookup (DictionaryService dict, String word) {
        String output = word + ": ";
        String def = dict.getDefinition(word);
        if (def == null) {
            return output + "Cannot find definition for this word.";
        }else{
            return output + def;
        }
    }
    
}
