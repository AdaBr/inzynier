package com.example.library.commons;

import javax.lang.model.element.Element;

public interface Repository<T>
{
    T GetById(Element id);
    T GetByQuery(Element query);
    void Add(T item);
    void Remove(T item);
    void Update(T item);
}
