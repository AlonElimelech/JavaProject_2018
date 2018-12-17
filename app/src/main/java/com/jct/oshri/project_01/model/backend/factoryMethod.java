package com.jct.oshri.project_01.model.backend;

import com.jct.oshri.project_01.model.datasource.FireBase_DBManager;

public class factoryMethod {

    static DB_manager manager = null;

    public static DB_manager getManager() {
        if (manager == null) // singleton
            manager = new FireBase_DBManager();
        return manager;
    }
}
