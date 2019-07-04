package cc.bunnies.pocketsnacks.controller;

import cc.bunnies.pocketsnacks.model.Brand;
import cc.bunnies.pocketsnacks.service.BrandService;
import cc.bunnies.pocketsnacks.util.PageNav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BrandController {
    private BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @RequestMapping("/admin/brand/list")
    public String list(
            ModelMap modelMap,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "6") int size
    ) {
        int total = brandService.getCount();
        int cur_page = PageNav.safePage(page, size, total);
        List<Brand> brands = brandService.getBrandsByPage(cur_page, size);
        modelMap.addAttribute("brands", brands)
                .addAttribute("page_nav", PageNav.makePageNav(cur_page, size, total))
                .addAttribute("cur_page", cur_page);
        return "admin/brand_list";
    }
}
