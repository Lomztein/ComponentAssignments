package com.lomztein.assignments.common.services;

import com.lomztein.assignments.common.data.GameData;
import com.lomztein.assignments.common.data.World;

public interface IGamePluginService {
    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}
