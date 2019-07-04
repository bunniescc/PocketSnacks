package cc.bunnies.pocketsnacks.service;

import cc.bunnies.pocketsnacks.model.Commodity;

import java.util.List;

public interface CommodityService {
    List<Commodity> getCommoditiesByPage(int page, int size);

    int getCount();
}
