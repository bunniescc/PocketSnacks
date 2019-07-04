package cc.bunnies.pocketsnacks.controller;

import cc.bunnies.pocketsnacks.model.OrderDetail;
import cc.bunnies.pocketsnacks.service.OrderService;
import cc.bunnies.pocketsnacks.util.PageNav;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/admin/order/list")
    public String list(
            ModelMap modelMap,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "6") int size
    ) {
        int total = orderService.getCount();
        int cur_page = PageNav.safePage(page, size, total);
        List<OrderDetail> orderDetails = orderService.getOrderDetailsByPage(cur_page, size);
        modelMap.addAttribute("orderDetails", orderDetails)
                .addAttribute("page_nav", PageNav.makePageNav(cur_page, size, total))
                .addAttribute("cur_page", cur_page);
        return "admin/order_list";
    }
}
