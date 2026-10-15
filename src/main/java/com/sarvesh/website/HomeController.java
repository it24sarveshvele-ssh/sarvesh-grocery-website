package com.sarvesh.website;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class HomeController {

    private record Product(String name, String category, int price,
                           String unit, String image) {}

    private final Map<String, Product> products = new LinkedHashMap<>();

    public HomeController() {
        add("Apples", "Fruits", 140, "1 kg",
                "https://images.unsplash.com/photo-1560806887-1e4cd0b6cbd6");
        add("Bananas", "Fruits", 50, "1 dozen",
                "https://images.unsplash.com/photo-1571771894821-ce9b6c11b08e");
        add("Oranges", "Fruits", 80, "1 kg",
                "https://images.unsplash.com/photo-1547514701-42782101795e");
        add("Mangoes", "Fruits", 120, "1 kg",
                "https://images.unsplash.com/photo-1553279768-865429fa0078");
        add("Grapes", "Fruits", 90, "500 g",
                "https://images.unsplash.com/photo-1537640538966-79f369143f8f");
        add("Watermelon", "Fruits", 40, "1 kg", "/images/watermelon.png");
        add("Papaya", "Fruits", 50, "1 kg",
                "https://images.unsplash.com/photo-1517282009859-f000ec3b26fe");
        add("Pomegranate", "Fruits", 160, "1 kg",
                "https://images.unsplash.com/photo-1541344999736-83eca272f6fc");

        add("Tomatoes", "Vegetables", 40, "1 kg", "https://images.unsplash.com/photo-1546094096-0df4bcaaa337?auto=format&fit=crop&w=500&q=80");
        add("Potatoes", "Vegetables", 35, "1 kg", "https://images.unsplash.com/photo-1518977676601-b53f82aba655?auto=format&fit=crop&w=500&q=80");
        add("Onions", "Vegetables", 40, "1 kg", "https://images.unsplash.com/photo-1508747703725-719777637510?auto=format&fit=crop&w=500&q=80");
        add("Carrots", "Vegetables", 50, "1 kg", "https://images.unsplash.com/photo-1445282768818-728615cc910a?auto=format&fit=crop&w=500&q=80");
        add("Broccoli", "Vegetables", 60, "1 piece", "https://images.unsplash.com/photo-1459411621453-7b03977f4bfc?auto=format&fit=crop&w=500&q=80");
        add("Spinach", "Vegetables", 25, "1 bunch", "https://images.unsplash.com/photo-1576045057995-568f588f82fb?auto=format&fit=crop&w=500&q=80");
        add("Cauliflower", "Vegetables", 40, "1 piece", "/images/cauliflower.png");
        add("Capsicum", "Vegetables", 60, "500 g", "https://images.unsplash.com/photo-1563565375-f3fdfdbefa83?auto=format&fit=crop&w=500&q=80");

        add("Toor Dal", "Pulses", 160, "1 kg", "/images/toor-dal.png");
        add("Moong Dal", "Pulses", 140, "1 kg", "/images/moong-dal.jpg");
        add("Masoor Dal", "Pulses", 110, "1 kg", "/images/masoor-dal.jpg");
        add("Chana Dal", "Pulses", 90, "1 kg", "/images/chana-dal.jpg");
        add("Urad Dal", "Pulses", 130, "1 kg", "/images/urad-dal.jpg");
        add("Kabuli Chana", "Pulses", 120, "1 kg", "/images/kabuli-chana.png");
        add("Rajma", "Pulses", 140, "1 kg", "/images/rajma.png");
        add("Green Moong", "Pulses", 120, "1 kg", "/images/green-moong.png");

        add("Potato Chips", "Snacks", 20, "1 packet", "https://images.unsplash.com/photo-1566478989037-eec170784d0b?auto=format&fit=crop&w=500&q=80");
        add("Cream Biscuits", "Snacks", 30, "1 pack", "https://images.unsplash.com/photo-1558961363-fa8fdf82db35?auto=format&fit=crop&w=500&q=80");
        add("Salted Peanuts", "Snacks", 40, "200 g", "https://images.unsplash.com/photo-1567892737950-30c4db37cd89?auto=format&fit=crop&w=500&q=80");
        add("Popcorn", "Snacks", 35, "1 pack", "https://images.unsplash.com/photo-1578849278619-e73505e9610f?auto=format&fit=crop&w=500&q=80");
        add("Namkeen", "Snacks", 45, "200 g", "https://images.unsplash.com/photo-1601050690597-df0568f70950?auto=format&fit=crop&w=500&q=80");
        add("Crackers", "Snacks", 30, "1 pack", "/images/crackers.jpg");
        add("Chocolate Cookies", "Snacks", 40, "1 pack", "https://images.unsplash.com/photo-1499636136210-6f4ee915583e?auto=format&fit=crop&w=500&q=80");
        add("Mixture", "Snacks", 50, "250 g", "https://images.unsplash.com/photo-1599490659213-e2b9527bd087?auto=format&fit=crop&w=500&q=80");

        add("Fresh Milk", "Dairy", 35, "500 ml", "https://images.unsplash.com/photo-1563636619-e9143da7973b?auto=format&fit=crop&w=500&q=80");
        add("Curd", "Dairy", 35, "400 g", "https://images.unsplash.com/photo-1488477181946-6428a0291777?auto=format&fit=crop&w=500&q=80");
        add("Butter", "Dairy", 58, "100 g", "https://images.unsplash.com/photo-1589985270826-4b7bb135bc9d?auto=format&fit=crop&w=500&q=80");
        add("Paneer", "Dairy", 90, "200 g", "https://images.unsplash.com/photo-1631452180519-c014fe946bc7?auto=format&fit=crop&w=500&q=80");
        add("Cheese Slices", "Dairy", 125, "10 slices", "https://images.unsplash.com/photo-1486297678162-eb2a19b0a32d?auto=format&fit=crop&w=500&q=80");
        add("Yogurt", "Dairy", 30, "100 g", "https://images.unsplash.com/photo-1488477181946-6428a0291777?auto=format&fit=crop&w=500&q=80");
        add("Buttermilk", "Dairy", 20, "200 ml", "https://images.unsplash.com/photo-1550583724-b2692b85b150?auto=format&fit=crop&w=500&q=80");
        add("Fresh Cream", "Dairy", 65, "250 ml", "https://images.unsplash.com/photo-1628088062854-d1870b4553da?auto=format&fit=crop&w=500&q=80");

        add("White Bread", "Bakery & Eggs", 40, "1 loaf", "https://images.unsplash.com/photo-1509440159596-0249088772ff?auto=format&fit=crop&w=500&q=80");
        add("Brown Bread", "Bakery & Eggs", 50, "1 loaf", "https://images.unsplash.com/photo-1586444248902-2f64eddc13df?auto=format&fit=crop&w=500&q=80");
        add("Pav", "Bakery & Eggs", 30, "6 pieces", "/images/pav.webp");
        add("Burger Buns", "Bakery & Eggs", 35, "4 pieces", "https://images.unsplash.com/photo-1555507036-ab1f4038808a?auto=format&fit=crop&w=500&q=80");
        add("Croissant", "Bakery & Eggs", 45, "1 piece", "https://images.unsplash.com/photo-1555507036-ab1f4038808a?auto=format&fit=crop&w=500&q=80");
        add("Eggs", "Bakery & Eggs", 75, "6 pieces", "https://images.unsplash.com/photo-1506976785307-8732e854ad03?auto=format&fit=crop&w=500&q=80");
        add("Whole Wheat Bread", "Bakery & Eggs", 55, "1 loaf", "https://images.unsplash.com/photo-1534620808146-d33bb39128b2?auto=format&fit=crop&w=500&q=80");
        add("Dinner Rolls", "Bakery & Eggs", 40, "4 pieces", "https://images.unsplash.com/photo-1586444248902-2f64eddc13df?auto=format&fit=crop&w=500&q=80");
    }

    private void add(String name, String category, int price,
                     String unit, String image) {
        products.put(name,
                new Product(name, category, price, unit, image));
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/products")
    public String products(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String category,
            Model model) {

        Map<String, Product> filtered = new LinkedHashMap<>();

        for (Product product : products.values()) {
            boolean matchesSearch = search == null || search.isBlank()
                    || product.name().toLowerCase()
                    .contains(search.trim().toLowerCase())
                    || product.category().toLowerCase()
                    .contains(search.trim().toLowerCase());

            boolean matchesCategory = category == null
                    || category.isBlank()
                    || product.category().equalsIgnoreCase(category);

            if (matchesSearch && matchesCategory) {
                filtered.put(product.name(), product);
            }
        }

        model.addAttribute("products", filtered);
        model.addAttribute("search", search);
        model.addAttribute("category", category);
        model.addAttribute("categories", products.values().stream()
                .map(Product::category).distinct().toList());

        return "products";
    }

    @PostMapping("/cart/add")
    public String addToCart(
            @RequestParam String product,
            HttpSession session) {

        if (!products.containsKey(product)) {
            return "redirect:/products";
        }

        Map<String, Integer> cart = getCart(session);
        cart.put(product, cart.getOrDefault(product, 0) + 1);

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cart(HttpSession session, Model model) {
        Map<String, Integer> cart = getCart(session);
        int total = calculateTotal(cart);

        model.addAttribute("cart", cart);
        model.addAttribute("products", products);
        model.addAttribute("total", total);

        return "cart";
    }

    @GetMapping("/checkout")
    public String checkout(HttpSession session, Model model) {
        Map<String, Integer> cart = getCart(session);

        if (cart.isEmpty()) {
            return "redirect:/products";
        }

        model.addAttribute("total", calculateTotal(cart));
        return "checkout";
    }

    @PostMapping("/checkout")
    public String placeOrder(HttpSession session) {
        Map<String, Integer> cart = getCart(session);

        if (cart.isEmpty()) {
            return "redirect:/products";
        }

        cart.clear();
        return "redirect:/order-confirmation";
    }

    @GetMapping("/order-confirmation")
    public String orderConfirmation() {
        return "order-confirmation";
    }

    private int calculateTotal(Map<String, Integer> cart) {
        int total = 0;

        for (Map.Entry<String, Integer> item : cart.entrySet()) {
            Product product = products.get(item.getKey());

            if (product != null) {
                total += product.price() * item.getValue();
            }
        }

        return total;
    }

    private Map<String, Integer> getCart(HttpSession session) {
        @SuppressWarnings("unchecked")
        Map<String, Integer> cart =
                (Map<String, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new LinkedHashMap<>();
            session.setAttribute("cart", cart);
        }

        return cart;
    }
}
