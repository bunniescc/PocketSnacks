package cc.bunnies.pocketsnacks.controller;

import cc.bunnies.pocketsnacks.model.Commodity;
import cc.bunnies.pocketsnacks.service.CommodityService;
import cc.bunnies.pocketsnacks.util.PageNav;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CommodityController {
    private final CommodityService commodityService;

    public CommodityController(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @RequestMapping("/admin/food/list")
    public String list(
            ModelMap modelMap,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "6") int size
    ) {
        int total = commodityService.getCount();
        int cur_page = PageNav.safePage(page, size, total);
        List<Commodity> commodities = commodityService.getCommoditiesByPage(cur_page, size);
        modelMap.addAttribute("commodities", commodities)
                .addAttribute("page_nav", PageNav.makePageNav(cur_page, size, total))
                .addAttribute("cur_page", cur_page);
        return "admin/food_list";
    }
}
