package com.nisum.functionalinterfaces;

import com.nisum.methodreference.ObjIntCreation;

@FunctionalInterface
public interface IntObjectSupplier {
    ObjIntCreation apply(ObjIntCreation obj);
}
