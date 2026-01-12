package com.example.inventoryapi.controller;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

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
                            "status": "IN_STOCK",
                            "lastUpdated": "2024-01-15T10:30:00Z"
                        },
                        {
                            "id": 2,
                            "name": "Wireless Mouse",
                            "category": "Accessories",
                            "quantity": 42,
                            "price": 29.99,
                            "status": "IN_STOCK",
                            "lastUpdated": "2024-01-14T14:20:00Z"
                        },
                        {
                            "id": 3,
                            "name": "Mechanical Keyboard",
                            "category": "Accessories",
                            "quantity": 23,
                            "price": 89.99,
                            "status": "IN_STOCK",
                            "lastUpdated": "2024-01-13T09:15:00Z"
                        },
                        {
                            "id": 4,
                            "name": "27-inch Monitor",
                            "category": "Electronics",
                            "quantity": 8,
                            "price": 299.99,
                            "status": "LOW_STOCK",
                            "lastUpdated": "2024-01-12T16:45:00Z"
                        }
                    ],
                    "summary": {
                        "totalProducts": 4,
                        "totalValue": 45709.67,
                        "lowStockItems": 1,
                        "inStockItems": 3
                    }
                },
                "metadata": {
                    "page": 1,
                    "limit": 10,
                    "totalPages": 1,
                    "timestamp": "%s"
                }
            }
            """.formatted(LocalDateTime.now());
    }
    
    @GetMapping("/{id}")
    public String getProductById(@PathVariable int id) {
        return String.format("""
            {
                "success": true,
                "message": "Product with ID %d found",
                "data": {
                    "product": {
                        "id": %d,
                        "name": "Sample Product %d",
                        "description": "This is a sample product for demonstrating Spring Boot REST API capabilities in a production deployment.",
                        "category": "Demo Category",
                        "sku": "PROD-%03d",
                        "quantity": 25,
                        "price": 99.99,
                        "supplier": "Demo Supplier Inc.",
                        "warehouseLocation": "A-12-4",
                        "createdAt": "2024-01-10T10:30:00Z",
                        "updatedAt": "%s",
                        "status": "IN_STOCK"
                    }
                },
                "metadata": {
                    "requestedId": %d,
                    "timestamp": "%s"
                }
            }
            """, id, id, id, id, LocalDateTime.now(), id, LocalDateTime.now());
    }
    
    @PostMapping
    public String createProduct() {
        return String.format("""
            {
                "success": true,
                "message": "Product created successfully",
                "data": {
                    "id": 100,
                    "name": "New Product",
                    "createdAt": "%s",
                    "sku": "AUTO-GENERATED"
                },
                "note": "This is a simulation. In a production system, this would save to a database with proper validation."
            }
            """, LocalDateTime.now());
    }
    
    @GetMapping("/categories")
    public String getCategories() {
        return """
            {
                "success": true,
                "data": {
                    "categories": [
                        {"id": 1, "name": "Electronics", "productCount": 2, "description": "Electronic devices and components"},
                        {"id": 2, "name": "Accessories", "productCount": 2, "description": "Computer and device accessories"},
                        {"id": 3, "name": "Office Supplies", "productCount": 0, "description": "General office supplies"},
                        {"id": 4, "name": "Furniture", "productCount": 0, "description": "Office furniture and equipment"}
                    ]
                },
                "metadata": {
                    "totalCategories": 4
                }
            }
            """;
    }
    
    @GetMapping("/status")
    public String getServiceStatus() {
        return """
            {
                "service": "Product API",
                "status": "operational",
                "endpoints": 5,
                "version": "1.0.0"
            }
            """;
    }
}
