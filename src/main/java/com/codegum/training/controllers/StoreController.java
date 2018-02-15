package com.codegum.training.controllers;

import com.codegum.training.Store;
import com.codegum.training.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by juliusneria on 19/10/2017.
 */
@Controller    // This means that this class is a Controller
@RequestMapping(path="/store") // This means URL's start with /demo (after Application path)
public class StoreController {

    @Autowired
    private StoreRepository storeRepository;

    @PostMapping(path="/add") // Map ONLY GET Requests
    //@CrossOrigin
    public @ResponseBody
    Object addNewStore (@RequestBody Store store) {
        return storeRepository.save(store);
    }

    //@CrossOrigin
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Store> getAllUsers() {
        return storeRepository.findAll();
    }

    @PutMapping("/update")
    //@CrossOrigin
    public @ResponseBody Object updateStore(@RequestBody Store store) {

//        Store oldStore = storeRepository.findOne(store.getStore_id());
        /*store.setBooks(store.getBooks());
        store.setManager(store.getManager());*/
        storeRepository.save(store);

        return store;
    }

    @DeleteMapping("/delete/{store_id}")
    //@CrossOrigin
    public @ResponseBody Object delete(@PathVariable Long store_id) {
        // PUT processing
        Store store = storeRepository.findOne(store_id);
        storeRepository.delete(store_id);
        return store;
    }


}