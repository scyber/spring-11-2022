package ru.otus.spring.services;

import java.util.List;

public interface ProviderServiceI<T> {
    List<T> provide();
}
