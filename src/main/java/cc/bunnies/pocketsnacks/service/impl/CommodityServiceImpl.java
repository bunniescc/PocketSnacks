package cc.bunnies.pocketsnacks.service.impl;

import cc.bunnies.pocketsnacks.dao.CommodityDao;
import cc.bunnies.pocketsnacks.model.Commodity;
import cc.bunnies.pocketsnacks.service.CommodityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    private final CommodityDao commodityDao;

    public CommodityServiceImpl(CommodityDao commodityDao) {
        this.commodityDao = commodityDao;
    }

    @Override
    public List<Commodity> getCommoditiesByPage(int page, int size) {
        return commodityDao.getCommoditiesByPage((page - 1) * size, size);
    }

    @Override
    public int getCount() {
        return commodityDao.getCount();
    }
}
