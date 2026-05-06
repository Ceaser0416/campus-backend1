package lk.icptechnologies.carergo.campusbackend.dto;

import java.util.List;
import java.util.Map;

public class InventoryReport {

    private Double totalValue;
    private List<Map<String, Object>> categoryDistribution;
    private List<Map<String, Object>> monthlySales;

    public InventoryReport() {
    }

    public InventoryReport(Double totalValue, List<Map<String, Object>> categoryDistribution, List<Map<String, Object>> monthlySales) {
        this.totalValue = totalValue;
        this.categoryDistribution = categoryDistribution;
        this.monthlySales = monthlySales;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<Map<String, Object>> getCategoryDistribution() {
        return categoryDistribution;
    }

    public void setCategoryDistribution(List<Map<String, Object>> categoryDistribution) {
        this.categoryDistribution = categoryDistribution;
    }

    public List<Map<String, Object>> getMonthlySales() {
        return monthlySales;
    }

    public void setMonthlySales(List<Map<String, Object>> monthlySales) {
        this.monthlySales = monthlySales;
    }
}
