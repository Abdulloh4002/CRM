package org.example.marketapplication.listener;

import jakarta.persistence.Entity;

public interface EntityListener<T>{
    void onInsert(T entity);
    void onUpdate(T entity);

}
