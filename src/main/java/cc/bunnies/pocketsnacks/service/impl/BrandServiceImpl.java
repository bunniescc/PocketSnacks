package cc.bunnies.pocketsnacks.service.impl;

import cc.bunnies.pocketsnacks.dao.BrandDao;
import cc.bunnies.pocketsnacks.model.Brand;
import cc.bunnies.pocketsnacks.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private BrandDao brandDao;

    @Autowired
    public BrandServiceImpl(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    @Override
    public List<Brand> getBrandsByPage(int page, int size) {
        return brandDao.getBrandsByPage((page - 1) * size, size);
    }

    @Override
    public int getCount() {
        return brandDao.getCount();
    }
}
