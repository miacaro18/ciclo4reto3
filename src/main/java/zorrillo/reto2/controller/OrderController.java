package zorrillo.reto2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zorrillo.reto2.model.Order;

import zorrillo.reto2.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order){
        return orderService.create(order);
    }

    @GetMapping("/all")
    public List<Order> getOrder(){
        return orderService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer id){
        return orderService.getOrder(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return orderService.update(order);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int orderId){
        return orderService.delete(orderId);
    }

    @GetMapping("/zona/{zone}")
    public List<Order> findByZone(@PathVariable("zone") String zone){
        return orderService.findByZone(zone);
    }

    @GetMapping("/salesman/{id}")
    public List<Order> ordersSalesManByID(@PathVariable("id") Integer id){
        return orderService.ordersSalesManByID(id);
    }

    @GetMapping("/state/{state}/{id}")
    public List<Order> ordersSalesManByState(@PathVariable("state") String state, @PathVariable("id") Integer id){
        return orderService.ordersSalesManByState(state, id);
    }

    @GetMapping("/date/{date}/{id}")
    public List<Order> ordersSalesManByDate(@PathVariable("date") String dateStr, @PathVariable("id") Integer id) {
        return orderService.ordersSalesManByDate(dateStr,id);
    }

}
