package cc.bunnies.pocketsnacks.controller;

import cc.bunnies.pocketsnacks.model.Category;
import cc.bunnies.pocketsnacks.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/admin/category/list")
    public String list(
            ModelMap modelMap,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size
    ) {
        List<Category> categories = categoryService.getCategoriesWithParent();
        modelMap.addAttribute("categories", categories);
        return "admin/category_list";
    }
}
