package lk.icptechnologies.carergo.campusbackend.controller;

import lk.icptechnologies.carergo.campusbackend.entity.Supplier;
import lk.icptechnologies.carergo.campusbackend.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin(origins = "http://localhost:3000")
public class SupplierController {

    @Autowired
    private SupplierRepository supplierRepository;

    // Get all suppliers
    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    // Get a single supplier by ID
    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable(value = "id") Long supplierId) {
        return supplierRepository.findById(supplierId)
                .map(supplier -> ResponseEntity.ok().body(supplier))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new supplier
    @PostMapping
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    // Update a supplier
    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable(value = "id") Long supplierId,
                                                   @RequestBody Supplier supplierDetails) {
        return supplierRepository.findById(supplierId)
                .map(supplier -> {
                    supplier.setName(supplierDetails.getName());
                    supplier.setContactPerson(supplierDetails.getContactPerson());
                    supplier.setEmail(supplierDetails.getEmail());
                    supplier.setPhone(supplierDetails.getPhone());
                    supplier.setCategory(supplierDetails.getCategory());
                    supplier.setLeadTime(supplierDetails.getLeadTime());
                    Supplier updatedSupplier = supplierRepository.save(supplier);
                    return ResponseEntity.ok(updatedSupplier);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a supplier
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable(value = "id") Long supplierId) {
        return supplierRepository.findById(supplierId)
                .map(supplier -> {
                    supplierRepository.delete(supplier);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
