package com.lomztein.assignments.player;

import com.lomztein.assignments.common.data.Entity;
import com.lomztein.assignments.common.data.GameData;
import com.lomztein.assignments.common.data.World;
import com.lomztein.assignments.common.data.entityparts.LifePart;
import com.lomztein.assignments.common.data.entityparts.MovingPart;
import com.lomztein.assignments.common.data.entityparts.PositionPart;
import com.lomztein.assignments.common.services.IGamePluginService;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;

@ServiceProviders (value = { @ServiceProvider (service = IGamePluginService.class),})
public class PlayerPlugin implements IGamePluginService {

    private Entity player;

    public PlayerPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        
        // Add entities to the world
        player = createPlayerShip(gameData);
        world.addEntity(player);
    }

    private Entity createPlayerShip(GameData gameData) {

        float deacceleration = 10;
        float acceleration = 200;
        float maxSpeed = 300;
        float rotationSpeed = 5;
        float x = gameData.getDisplayWidth() / 2;
        float y = gameData.getDisplayHeight() / 2;
        float radians = 3.1415f / 2;
        
        Entity playerShip = new Player();
        playerShip.setRadius(3);
        
        playerShip.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        playerShip.add(new PositionPart(x, y, radians));
        playerShip.add(new LifePart(6,69)); 
        
        return playerShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(player);
    }

}
