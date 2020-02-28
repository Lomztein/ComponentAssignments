/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.cbse.common.serviceloaders;

import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 *
 * @author Lomztein
 */
public class CommonServiceLoader {

    private static CommonServiceLoader instance;

    private ServiceLoader<IGamePluginService> pluginLoader;
    private ServiceLoader<IEntityProcessingService> processorLoader;
    private ServiceLoader<IPostEntityProcessingService> postProcessorLoader;

    private CommonServiceLoader() {
        pluginLoader = ServiceLoader.load(IGamePluginService.class);
        processorLoader = ServiceLoader.load(IEntityProcessingService.class);
        postProcessorLoader = ServiceLoader.load(IPostEntityProcessingService.class);
    }
    
    private static <T> List<T> toList (ServiceLoader<T> loader) {
        
        Iterator<T> iterator = loader.iterator();
        List<T> list = new ArrayList<T>();
        
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        
        return list;
    }

    public static CommonServiceLoader getInstance() {
        if (instance == null) {
            instance = new CommonServiceLoader();
        }

        return instance;
    }

    public static ServiceLoader<IGamePluginService> getPluginLoader() {
        return getInstance().pluginLoader;
    }
    
    public static List<IGamePluginService> getPluginList () {
        return toList(getInstance().pluginLoader);
    }

    public static ServiceLoader<IEntityProcessingService> getEntityProcessorLoader() {
        return getInstance().processorLoader;
    }
    
    public static List<IEntityProcessingService> getEntityProcessorList () {
        return toList(getInstance().processorLoader);
    }

    public static ServiceLoader<IPostEntityProcessingService> getPostEntityProcessorLoader() {
        return getInstance().postProcessorLoader;
    }
    
    public static List<IPostEntityProcessingService> getPostEntityProcessorList () {
        return toList(getInstance().postProcessorLoader);
    }
}
