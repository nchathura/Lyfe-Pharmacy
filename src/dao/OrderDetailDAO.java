package dao;

import entity.OrderDetail;
import entity.OrderDetailPK;

import java.util.List;

public interface OrderDetailDAO extends  SuperDAO{
    public List<OrderDetail> getAllOrderDetails();
    public  OrderDetail getOrderDetail(OrderDetailPK orderDetailPK);
    public  boolean saveOrderDetail(OrderDetail orderDetail);
    public  boolean deleteOrderDetail(OrderDetailPK orderDetailPK);
    public  boolean updateOrderDetail(OrderDetail orderDetail);
}
