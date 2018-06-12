package com.opsbin.springbootblog.utils;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionUtil {

    public static <T> Collection<T> iterableToCollection(Iterable<T> iterable) {
        Collection<T> collection = new ArrayList<>();
        iterable.forEach(collection::add);
        return collection;
    }
}
