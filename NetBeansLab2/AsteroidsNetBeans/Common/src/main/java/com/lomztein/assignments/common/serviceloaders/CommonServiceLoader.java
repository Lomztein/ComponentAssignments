/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lomztein.assignments.common.serviceloaders;

import com.lomztein.assignments.common.services.IEntityProcessingService;
import com.lomztein.assignments.common.services.IGamePluginService;
import com.lomztein.assignments.common.services.IPostEntityProcessingService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import org.openide.util.Lookup;

/**
 *
 * @author Lomztein
 */
public class CommonServiceLoader {

    private static CommonServiceLoader instance;

    private final Lookup lookup = Lookup.getDefault();

    private static <T> List<T> toList(Collection<T> collection) {

        List<T> list = new ArrayList<T>();

        for (T element : collection) {
            list.add(element);
        }

        return list;
    }

    public static CommonServiceLoader getInstance() {
        if (instance == null) {
            instance = new CommonServiceLoader();
        }

        return instance;
    }

    public static List<IGamePluginService> getPluginList() {
        return toList(getInstance().lookup.lookupAll(IGamePluginService.class));
    }

    public static List<IEntityProcessingService> getEntityProcessorList() {
        return toList(getInstance().lookup.lookupAll(IEntityProcessingService.class));

    }

    public static List<IPostEntityProcessingService> getPostEntityProcessorList() {
        return toList(getInstance().lookup.lookupAll(IPostEntityProcessingService.class));

    }
}
