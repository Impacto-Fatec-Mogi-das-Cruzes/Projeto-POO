package com.example.service.registries;

import java.util.HashMap;
import java.util.Map;

// Registry Pattern
abstract class Registry<T> {
    private Map<String, T> registry;
    
    Registry() {
        registry = new HashMap<>();
    }

    public void register(String key, T value) {
        registry.put(key, value);
    }

    public T get(String key) {
        return registry.get(key);
    }

    public Map<String, T> getAll() {
        return registry;
    }
}
