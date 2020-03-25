package com.lomztein.assignments.common.services;

import com.lomztein.assignments.common.data.GameData;
import com.lomztein.assignments.common.data.World;

/**
 *
 * @author jcs
 */
public interface IPostEntityProcessingService  {
        void process(GameData gameData, World world);
}
