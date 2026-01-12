package com.example.inventoryapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @GetMapping
    public String getAllProducts() {
        return """
            {
                "success": true,
                "message": "Products retrieved successfully",
                "data": {
                    "products": [
                        {
                            "id": 1,
                            "name": "Laptop Dell XPS 13",
                            "category": "Electronics",
                            "quantity": 15,
                            "price": 1299.99,
                            "lastUpdated": "2024-01-15"
                        },
                        {
                            "id": 2,
                            "name": "Wireless Mouse",
                            "category": "Accessories",
                            "quantity": 42,
                            "price": 29.99,
                            "lastUpdated": "2024-01-14"
                        },
                        {
                            "id": 3,
                            "name": "Mechanical Keyboard",
                            "category": "Accessories",
                            "quantity": 23,
                            "price": 89.99,
                            "lastUpdated": "2024-01-13"
                        },
                        {
                            "id": 4,
                            "name": "27-inch Monitor",
                            "category": "Electronics",
                            "quantity": 8,
                            "price": 299.99,
                            "lastUpdated": "2024-01-12"
                        }
                    ],
                    "summary": {
                        "totalProducts": 4,
                        "totalValue": 45709.67,
                        "lowStockItems": 1
                    }
                },
                "metadata": {
                    "page": 1,
                    "limit": 10,
                    "totalPages": 1
                }
            }
            """;
    }
    
    @GetMapping("/{id}")
    public String getProductById(@PathVariable int id) {
        String productTemplate = """
            {
                "success": true,
                "message": "Product with ID %d found",
                "data": {
                    "product": {
                        "id": %d,
                        "name": "Sample Product %d",
                        "description": "This is a sample product for demonstration of Spring Boot REST API capabilities.",
                        "category": "Demo Category",
                        "sku": "PROD-%03d",
                        "quantity": 25,
                        "price": 99.99,
                        "supplier": "Demo Supplier Inc.",
                        "warehouseLocation": "A-12-4",
                        "createdAt": "2024-01-10T10:30:00Z",
                        "updatedAt": "2024-01-15T14:20:00Z",
                        "status": "IN_STOCK"
                    }
                }
            }
            """;
        
        return String.format(productTemplate, id, id, id, id);
    }
    
    @PostMapping
    public String createProduct() {
        return """
            {
                "success": true,
                "message": "Product created successfully (simulated)",
                "data": {
                    "id": 100,
                    "name": "New Product",
                    "createdAt": "%s"
                },
                "note": "This is a simulation. In a real application, this would save to database."
            }
            """.formatted(java.time.LocalDateTime.now());
    }
    
    @GetMapping("/categories")
    public String getCategories() {
        return """
            {
                "categories": [
                    {"id": 1, "name": "Electronics", "productCount": 2},
                    {"id": 2, "name": "Accessories", "productCount": 2},
                    {"id": 3, "name": "Office Supplies", "productCount": 0},
                    {"id": 4, "name": "Furniture", "productCount": 0}
                ]
            }
            """;
    }
}