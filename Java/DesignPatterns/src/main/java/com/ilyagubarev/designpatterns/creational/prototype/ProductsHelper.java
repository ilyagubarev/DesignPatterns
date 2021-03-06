/*
 * Copyright 2013 Ilya Gubarev.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ilyagubarev.designpatterns.creational.prototype;

import java.util.UUID;

/**
 * Products service class.
 *
 * @version 1.02, 04 September 2013
 * @since 03 September 2013
 * @author Ilya Gubarev
 */
public final class ProductsHelper {

    /**
     * Creates a new instance of Product.
     *
     * @param value a product value.
     * @param unique true if an unique product is needed.
     * @return a new instance of Product.
     *
     * @see Product
     */
    public static Product create(int value, boolean unique) {
        Product result;
        if (unique) {
            result = new ConcreteUniqueProduct(generateId(), value);
        } else {
            result = new ConcreteProduct(value);
        }
        return result;
    }

    /**
     * Creates a copy of specified prototype Product.
     *
     * @param prototype a prototype Product to be copied.
     * @return a new instance of of Product (prototype copy).
     *
     * @see Product
     */
    public static Product copy(Product prototype) {
        Product result;
        try {
            result = (Product) prototype.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        if (result instanceof UniqueProduct) {
            ((UniqueProduct) result).setId(generateId());
        }
        return result;
    }

    private static String generateId() {
        return UUID.randomUUID().toString();
    }

    private ProductsHelper() {

    }
}
