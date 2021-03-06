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

/**
 * Special subfamily of creation-expensive products: their identifiers
 * should stay unique even if products themselves have been cloned.
 *
 * @see Product
 *
 * @version 1.02, 04 September 2013
 * @since 03 September 2013
 * @author Ilya Gubarev
 */
public abstract class UniqueProduct extends Product {

    private String _id;

    UniqueProduct(String id, int value) {
        super(value);
        _id = id;
    }

    /**
     * Gets an identifier of the product.
     *
     * @return a product identifier.
     */
    public String getId() {
        return _id;
    }

    void setId(String id) {
        _id = id;
    }
}
