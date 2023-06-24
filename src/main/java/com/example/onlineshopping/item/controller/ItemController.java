package com.example.onlineshopping.item.controller;


import com.example.onlineshopping.item.domain.Item;
import com.example.onlineshopping.item.etc.ItemForm;
import com.example.onlineshopping.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class ItemController {


    @Autowired
    private ItemService itemService;


    @GetMapping("/items/new")
    public String createForm (Model model){
        model.addAttribute("itemForm", new ItemForm());
        return "items/createItemForm";
    }


    @PostMapping("/items/new")
    public String itemCreate(ItemForm itemForm) throws Exception{
        Item item1 = Item.builder()
                .name(itemForm.getName())
                .price(itemForm.getPrice())
                .stockQuantity(itemForm.getStockQuantity())
                .build();
        itemService.create(item1);
        return "redirect:/items";
    }

//    회원 목록 조회
    @GetMapping("items")
    public String memberFindAll(Model model) throws SQLException {
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    @GetMapping("/items/{id}/edit")
    //        get 요청의 parameter 넣는 방법 2가지 1) pathvariable 2)RequestParam (Form 을 쓰는 방법)
//    아래의 방식을 사용하지 않고 patchvariable 방법을 사용하라
    public String itemUpdateForm(@PathVariable(value = "id")Long myId, Model model) throws Exception {
        Item item  = itemService.findById(myId);
        model.addAttribute("itemForm", item);
        return "items/updateItemForm";
    }


    @PostMapping("/items/{id}/edit")
    public String itemUpdate(ItemForm itemForm) throws Exception {
        itemService.update(itemForm);
        return "redirect:/items";
    }

    @GetMapping("/items/{id}/delete")
    public String deleteItem(@PathVariable(value = "id")String id){
        itemService.delete(Long.parseLong(id));
        return "redirect:/items";
    }















}






