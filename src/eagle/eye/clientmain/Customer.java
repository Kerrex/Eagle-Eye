/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eagle.eye.clientmain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tomek
 */
public class Customer {
    private String name;
    private String regon;
    private List<Product> productList;

    public Customer(String name, String regon) {
        this.name = name;
        this.regon = regon;
        productList = new ArrayList();
    }

    Customer() {}

    public void setProductList(List<Product> list){
        productList = list;
    }

    public List<Product> getProductList(){
        return productList;
    }
    
    public String getRegon(){
        return regon;
    }
    @Override
    public String toString() {
        return name;
    }
    
    
}
