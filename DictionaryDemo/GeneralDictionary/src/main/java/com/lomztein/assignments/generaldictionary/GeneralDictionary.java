/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lomztein.assignments.generaldictionary;

import com.lomztein.assignments.dictionaryservice.Dictionary;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author Lomztein
 */
public class GeneralDictionary implements Dictionary {

    private SortedMap<String, String> defMap = new TreeMap<String, String>();

    public GeneralDictionary() {
        defMap.put("book", "A source of infinite wisdom and occasionally very concise descriptions of genitalia.");
        defMap.put("editor", "Theodor 'Editor' Lee, the one who Edits.");
    }

    @Override
    public String getDefinition(String word) {
        return defMap.get(word.toLowerCase());
    }

}
