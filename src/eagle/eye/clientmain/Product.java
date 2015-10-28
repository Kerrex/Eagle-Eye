/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eagle.eye.clientmain;

/**
 *
 * @author Tomek
 */
class Product {
    
    private Object[] product = new Object[3];
    
    public Product(String name, String ean, int quantity) {
        product[0] = name; //Name of the product
        product[1] = ean; //EAN code of the product
        product[2] = quantity; //Amount of the product
    }
    
    public Object[] getProduct(){
        return product;
    }
    public void setQuantity(int i){
        int temp = (int) product[2];
        product[2] = i+temp;
    }
    
    
    
}
