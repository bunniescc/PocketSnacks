package cc.bunnies.pocketsnacks.service;

import cc.bunnies.pocketsnacks.model.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getBrandsByPage(int page, int size);

    int getCount();
}
