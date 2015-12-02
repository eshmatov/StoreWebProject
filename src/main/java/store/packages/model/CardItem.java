/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.packages.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rustam
 */
@XmlRootElement
public class CardItem {

    private Product product;
    private int quantity;

    public CardItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public CardItem() {

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
