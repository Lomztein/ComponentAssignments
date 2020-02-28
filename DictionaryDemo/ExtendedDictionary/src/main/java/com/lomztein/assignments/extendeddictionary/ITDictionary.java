/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lomztein.assignments.extendeddictionary;

import com.lomztein.assignments.dictionaryservice.Dictionary;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author Lomztein
 */
public class ITDictionary implements Dictionary {

    private SortedMap<String, String> defMap = new TreeMap<String, String>();

    public ITDictionary() {
        defMap.put("xml", "A type of file format great for storing complex composite data.");
        defMap.put("rest", "Representational State Transfer, a technique of providing CRUD functionality using the HTML protocol only.");
    }

    @Override
    public String getDefinition(String word) {
        return defMap.get(word.toLowerCase());
    }

}
