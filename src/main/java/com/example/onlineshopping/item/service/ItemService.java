package com.example.onlineshopping.item.service;

import com.example.onlineshopping.item.domain.Item;
import com.example.onlineshopping.item.etc.ItemForm;
import com.example.onlineshopping.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.util.List;

@Service
public class ItemService {


    @Autowired
    private ItemRepository itemRepository;

    public void create(Item item) throws SQLException {
        itemRepository.save(item);
    }

    public List<Item> findAll() throws SQLException {
        List<Item> items = itemRepository.findAll();
        return items;
    }


    public Item findById(Long myId) throws EntityNotFoundException {
        Item items = itemRepository.findById(myId).orElseThrow(EntityNotFoundException::new);
        return items;
    }

    public void update(ItemForm itemForm) throws Exception {
        Item item1 = itemRepository.findById(Long.parseLong(itemForm.getId())).orElseThrow(Exception::new);
        item1.updateItem(itemForm.getName(), itemForm.getPrice(),itemForm.getStockQuantity());
//        if (item1 == null) {
//            throw new Exception();
//        } else {
//            item1.setName(itemForm.getName());
//            item1.setPrice(itemForm.getPrice());
//            item1.setStockQuantity(itemForm.getStockQuantity());
            itemRepository.save(item1);
        }



    public void delete (Long id) {
        itemRepository.delete(this.findById(id));
    }


    public Item findByName(String name) {
        return itemRepository.findByName(name);
    }







}






