package cc.bunnies.pocketsnacks.service;

import cc.bunnies.pocketsnacks.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategoriesWithParent();
}
