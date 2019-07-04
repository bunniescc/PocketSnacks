package cc.bunnies.pocketsnacks.controller;

import cc.bunnies.pocketsnacks.model.Category;
import cc.bunnies.pocketsnacks.service.CategoryService;
import cc.bunnies.pocketsnacks.util.PageNav;
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
            @RequestParam(name = "size", required = false, defaultValue = "6") int size
    ) {
        int total = categoryService.getCount();
        int cur_page = PageNav.safePage(page, size, total);
        List<Category> categories = categoryService.getCategoriesWithParentByPage(cur_page, size);
        modelMap.addAttribute("categories", categories)
                .addAttribute("page_nav", PageNav.makePageNav(cur_page, size, total))
                .addAttribute("cur_page", cur_page);
        return "admin/category_list";
    }
}
