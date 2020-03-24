package com.lomztein.assignments.common.services;

import com.lomztein.assignments.common.data.GameData;
import com.lomztein.assignments.common.data.World;

public interface IEntityProcessingService {

    void process(GameData gameData, World world);
}
