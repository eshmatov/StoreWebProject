/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.packages.service;

import java.util.ArrayList;
import java.util.List;
import store.packages.model.Product;

/**
 *
 * @author Rustam
 */
public class ProductService {

    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();

        System.out.println("Product Service call!");

        products.add(new Product(1, "Iphone 6s plus 64 GB", "WITH 3D TOUCH, LIVE PHOTOS, 7000 SERIES ALUMINUM, A9 CHIP, ADVANCED CAMERAS, 5.5-INCH RETINA HD DISPLAY, AND SO MUCH MORE, YOU'LL SEE HOW WITH IPHONE 6S PLUS THE ONLY THING THAT'S CHANGED IS EVERYTHING", 942.0, "images/iphone6s.jpg"));
        products.add(new Product(2, "ASUS Zenbook UX305LA 13.3-Inch Laptop", "ASUS Zen book UX305LA-AB51 13.3 IPS FHD (19201080) Laptop (Titanium Gold) Intel i5-5200U 2.2 GHz, 8GB DDR3 RAM, 256 Solid State Storage, , 802.11AC(WiDi), Bluetooth 4.0, 1x USB 2.0, 2 x USB 3.0, 1x Headphone-out & Audio-in Combo Jack; 1x micro HDMI, SDXC card reader, Windows 10 (64 bit)", 699.94, "images/zenbook.jpg"));
        products.add(new Product(3, "LG Electronics 55LF6100 55-Inch 1080p Smart LED TV", "LED uses tiny, light-emitting diodes to illuminate the picture. The new standard in HDTVs, LED is superior to older CCFL technology, making slimmer televisions possible, with amazing brightness, clarity and color detail. Full HD 1080p meets the highest standards for high definition, displaying 1,080 (progressive) lines of resolution on screen for a clearer, more detailed image that is simply breathtaking.", 799.92, "images/lgtv.jpg"));
        products.add(new Product(4, "Apple iPhone 4S 16GB (White)", "The iPhone 4S (retroactively stylized with a lowercase 's' as iPhone 4s as of September 2013) is a smartphone that was designed and marketed by Apple Inc. It is the fifth generation of the iPhone, succeeding the iPhone 4 and preceding the iPhone 5. Announced on October 4, 2011 at Apple's Cupertino campus,[9] its media coverage was accompanied by the death of former Apple CEO and co-founder Steve Jobs on the following day.", 215.0, "images/iphone4s.jpg"));
        products.add(new Product(5, "Samsung Galaxy S6", "Samsung Galaxy S6 and Samsung Galaxy S6 Edge are Android smartphones manufactured and marketed by Samsung Electronics. The S6 and S6 Edge jointly serve as successors to the Galaxy S5. The smartphones were officially unveiled in a press conference at Mobile World Congress on 1 March 2015. Alongside the S6, Samsung also unveiled the S6 Edge, a variant whose screen is wrapped along the sides of the device; the curvature is usable for several additional features. The Galaxy S6 was released on 10 April 2015 in 20 countries", 699.99, "images/galaxy.jpg"));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}
