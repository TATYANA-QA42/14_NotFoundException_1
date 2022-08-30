package ru.netology.repository;

import ru.netology.*;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product[] removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
        return products;
    }

    public Product findById(int id) {
        for (Product item : products) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Product[] removeById2(int id) {  //удалять по id

        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        //int length = products.length - 1;
        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        for (Product item : products) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        products = tmp;
        return tmp;
    }
}
//    public Product[] getProducts() {
//        return products;
//    }

