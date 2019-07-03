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
    public List<Category> getCategoriesWithParent() {
        return categoryDao.getCategoriesByWithParent();
    }
}
