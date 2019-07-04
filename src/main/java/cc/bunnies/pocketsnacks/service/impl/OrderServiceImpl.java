package cc.bunnies.pocketsnacks.service.impl;

import cc.bunnies.pocketsnacks.dao.OrderDetailDao;
import cc.bunnies.pocketsnacks.model.OrderDetail;
import cc.bunnies.pocketsnacks.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDetailDao orderDetailDao;

    public OrderServiceImpl(OrderDetailDao orderDetailDao) {
        this.orderDetailDao = orderDetailDao;
    }

    @Override
    public List<OrderDetail> getOrderDetailsByPage(int page, int size) {
        return orderDetailDao.getOrderDetailsByPage((page - 1) * size, size);
    }

    @Override
    public int getCount() {
        return orderDetailDao.getCount();
    }
}
