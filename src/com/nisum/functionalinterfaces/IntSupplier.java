package com.nisum.functionalinterfaces;

import com.nisum.methodreference.ObjIntCreation;

@FunctionalInterface
public interface IntSupplier {
    public ObjIntCreation apply(int n);

}
