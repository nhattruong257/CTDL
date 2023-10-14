package task2_lab3;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private OrderItem[] items;

public double cost() {
    double totalCost = 0.0;
    
    for (OrderItem item : items) {
        totalCost += item.getP().getPrice() * item.getQuality();
    }
    
    return totalCost;
}

public boolean contains(Product p) {
    // Implementing binary search
    int left = 0;
    int right = items.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (items[mid].getP().getId().equals(p.getId())) {
            return true;
        }
        
        if (items[mid].getP().getId().compareTo(p.getId()) < 0) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return false;
}

public Product[] filter(String type) {
    // Implementing linear search
    List<Product> filteredProducts = new ArrayList<>();
    
    for (OrderItem item : items) {
        if (item.getP().getType().equals(type)) {
            filteredProducts.add(item.getP());
        }
    }
    
    return filteredProducts.toArray(new Product[0]);
}
}

