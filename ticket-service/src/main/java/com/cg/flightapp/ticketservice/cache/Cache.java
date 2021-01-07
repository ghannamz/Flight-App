package com.cg.flightapp.ticketservice.cache;

public interface Cache {
    void add(Integer key, Object value, long periodInMillis);

    void remove(Integer key);

    Object get(Integer key);

    void clear();

    long size();
}
