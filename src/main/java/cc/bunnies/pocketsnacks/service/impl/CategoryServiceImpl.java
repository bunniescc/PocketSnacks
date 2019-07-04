package cc.bunnies.pocketsnacks.service.impl;

import cc.bunnies.pocketsnacks.dao.CategoryDao;
import cc.bunnies.pocketsnacks.model.Category;
import cc.bunnies.pocketsnacks.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> getCategoriesWithParentByPage(int page, int size) {
        return categoryDao.getCategoriesByWithParent((page - 1) * size, size);
    }

    @Override
    public int getCount() {
        return categoryDao.getCountWithParent();
    }
}
