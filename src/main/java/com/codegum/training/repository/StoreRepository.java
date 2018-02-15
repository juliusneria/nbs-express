package com.codegum.training.repository;

import com.codegum.training.Manager;
import com.codegum.training.Store;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by juliusneria on 19/10/2017.
 */
public interface StoreRepository extends CrudRepository<Store, Long> {

    Store findStoreByManager(Manager manager);
}

