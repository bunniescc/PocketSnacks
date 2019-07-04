package cc.bunnies.pocketsnacks.service;

import cc.bunnies.pocketsnacks.model.OrderDetail;

import java.util.List;

public interface OrderService {
    List<OrderDetail> getOrderDetailsByPage(int page, int size);

    int getCount();
}
