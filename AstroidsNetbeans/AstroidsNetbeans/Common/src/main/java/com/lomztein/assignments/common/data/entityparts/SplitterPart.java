/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lomztein.assignments.common.data.entityparts;

import com.lomztein.assignments.common.data.Entity;
import com.lomztein.assignments.common.data.GameData;

/**
 *
 * @author Phillip O
 */
public class SplitterPart implements EntityPart {
    
    boolean shouldSplit = false;

    @Override
    public void process(GameData gameData, Entity entity) {
        
    }

    public boolean ShouldSplit() {
        return shouldSplit;
    }

    public void setShouldSplit(boolean shouldSplit) {
        this.shouldSplit = shouldSplit;
    }
    
    
}
