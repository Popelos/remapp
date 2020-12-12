/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.entity.Orderlist;
import mapp.service.OrderlistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @orderlist Hello Java !
 */
@RestController//@RestController = @Controller + @ResponseBody
@RequestMapping("/orderlist")
public class OrderlistController {

    @Autowired
    private OrderlistServiceImpl service;

    
    @GetMapping
    public List<Orderlist> getOrderlists() {
        return service.findAll();
    }

    @GetMapping("/{myvariable}")
    public Orderlist getOrderlistById(@PathVariable(value = "myvariable") Integer orderlistId) throws Exception {
        Optional<Orderlist> optionalOrderlist = service.findById(orderlistId);
        return optionalOrderlist.orElseThrow(() -> new Exception("Orderlist not exists with id:" + orderlistId));
        //return optionalOrderlist.get();
    }

    @PostMapping
    public Orderlist createOrderlist(@RequestBody Orderlist orderlist) {
        return service.create(orderlist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrderlistById(@PathVariable(value = "id") Integer orderlistId) {
        service.delete(orderlistId);
        return ResponseEntity.ok("Orderlist deleted successfully, ID:" + orderlistId);
    }

    @PutMapping("/{id}")
    public void updateOrderlist(@PathVariable(value = "id") Integer orderlistId,
            @RequestBody Orderlist newOrderlistDetails) throws Exception {
        Optional<Orderlist> optionalOrderlist = service.findById(orderlistId);
        Orderlist orderlistToUpdate = optionalOrderlist.orElseThrow(() -> new Exception("Orderlist not exists with id:" + orderlistId));
        
//        orderlistToUpdate.setDay(newOrderlistDetails.getDay());
        service.edit(newOrderlistDetails);
    }
    
//    @GetMapping("/search/{address}")
//    public Orderlist getOrderlistByAddress(@PathVariable(value = "address") String address){
//        return service.findOrderlistByAddress(address);
//    }

}
