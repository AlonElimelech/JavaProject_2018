package com.jct.oshri.project_01.model.backend;

import android.content.Context;

import com.jct.oshri.project_01.model.entities.ride;

public interface DB_manager {
    /**
     * The function adds a ride to the DB
     *
     * @param travel - An instance of the new travel
     */
    void addNewRide(ride travel);

}
