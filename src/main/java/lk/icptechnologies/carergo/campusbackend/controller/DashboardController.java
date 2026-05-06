package lk.icptechnologies.carergo.campusbackend.controller;

import lk.icptechnologies.carergo.campusbackend.dto.Alert;
import lk.icptechnologies.carergo.campusbackend.dto.InventoryReport;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {

    /**
     * Provides a mock inventory report for the dashboard.
     *
     * @return A mock InventoryReport object.
     */
    @GetMapping("/reports/summary")
    public InventoryReport getInventorySummary() {
        // Mock category distribution
        List<Map<String, Object>> categoryDistribution = Arrays.asList(
                createCategory("Electronics", 150),
                createCategory("Books", 300),
                createCategory("Home Goods", 200)
        );

        // Mock monthly sales data
        List<Map<String, Object>> monthlySales = Arrays.asList(
                createSale("January", 12000.0),
                createSale("February", 18000.0),
                createSale("March", 25000.0)
        );

        return new InventoryReport(55000.0, categoryDistribution, monthlySales);
    }

    /**
     * Provides a list of mock alerts, such as low-stock warnings.
     *
     * @return A list of mock Alert objects.
     */
    @GetMapping("/alerts")
    public List<Alert> getAlerts() {
        return Arrays.asList(
                new Alert(UUID.randomUUID().toString(), "Low Stock", "Product 'Laptop' is running low on stock.", "Warning", LocalDateTime.now().minusHours(2)),
                new Alert(UUID.randomUUID().toString(), "Low Stock", "Product 'Coffee Maker' is running low on stock.", "Warning", LocalDateTime.now().minusHours(5))
        );
    }

    // Helper method to create category map
    private Map<String, Object> createCategory(String name, Integer value) {
        Map<String, Object> category = new HashMap<>();
        category.put("name", name);
        category.put("value", value);
        return category;
    }

    // Helper method to create sales map
    private Map<String, Object> createSale(String month, Double value) {
        Map<String, Object> sale = new HashMap<>();
        sale.put("month", month);
        sale.put("sales", value);
        return sale;
    }
}
