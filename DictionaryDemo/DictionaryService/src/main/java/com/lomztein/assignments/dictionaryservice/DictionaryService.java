/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lomztein.assignments.dictionaryservice;

import com.lomztein.assignments.dictionaryservice.Dictionary;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/**
 *
 * @author Lomztein
 */
public class DictionaryService {
    
    private static DictionaryService instance;
    private ServiceLoader<Dictionary> loader;
    
    private DictionaryService () {
        loader = ServiceLoader.load(Dictionary.class);
    }
    
    public static synchronized DictionaryService getInstance () {
        // In accordance to Singleton pattern, only the class itself may create instances of itself, and should also make sure only a single one ever exists.
        if (instance == null) {
            instance = new DictionaryService ();
        }
        
        return instance;
    }
    
    public String getDefinition (String word) {
        
        String def = null;
        
        try {
            
            // Go through each provided dictionary and try to get the definition from there.
            Iterator<Dictionary> iterator = loader.iterator();
            while (def == null && iterator.hasNext()) {
                Dictionary dict = iterator.next();
                def = dict.getDefinition(word);
            }

            // Avoid dying in a fire if the loader was for some reason configured wrongly.
        }catch (ServiceConfigurationError serviceError) {
            def = null;
            serviceError.printStackTrace();
        }
        
        return def;
    }
    
}
