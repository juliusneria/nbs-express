package com.codegum.training.controllers;

import com.codegum.training.Manager;
import com.codegum.training.Store;
import com.codegum.training.repository.ManagerRepository;
import com.codegum.training.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by juliusneria on 19/10/2017.
 */
@Controller    // This means that this class is a Controller
@RequestMapping(path="/manager")
public class ManagerController {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @PostMapping(path="/add") // Map ONLY GET Requests
    //@CrossOrigin
    public @ResponseBody
    Object addNewManager (@RequestBody Manager manager) {
        return managerRepository.save(manager);
    }

    @GetMapping(path="/all")
    //@CrossOrigin
    public @ResponseBody Iterable<Manager> getAllUsers() {
        // This returns a JSON or XML with the users
        return managerRepository.findAll();
    }

    @PutMapping("/update")
    public @ResponseBody Object updateBook(@RequestBody Manager manager) {

        managerRepository.save(manager);

        return manager;
    }

    @DeleteMapping("/delete")
    public @ResponseBody Object delete(@RequestBody Manager manager) {
        try {
            Store store = storeRepository.findStoreByManager(manager);
            store.setManager(null);
            managerRepository.delete(manager);
        } catch (Exception e) {
            return null;
        }
        return manager;
    }
}
