package com.example.inventoryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class InventoryApiApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(InventoryApiApplication.class, args);
    }
    
    @GetMapping("/")
    public String home() {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Inventory API</title>
                <style>
                    body { font-family: Arial, sans-serif; margin: 40px; }
                    .container { max-width: 800px; margin: 0 auto; }
                    .endpoint { background: #f5f5f5; padding: 10px; margin: 10px 0; border-left: 4px solid #007bff; }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>📦 Inventory Management API</h1>
                    <p>Spring Boot REST API for inventory management</p>
                    
                    <h2>Available Endpoints:</h2>
                    <div class="endpoint">
                        <strong>GET</strong> <code>/api/health</code> - Health check
                    </div>
                    <div class="endpoint">
                        <strong>GET</strong> <code>/api/products</code> - List all products
                    </div>
                    <div class="endpoint">
                        <strong>GET</strong> <code>/api/products/{id}</code> - Get product by ID
                    </div>
                    
                    <p><em>Created by: Margaretha Angellina Nainggolan</em></p>
                </div>
            </body>
            </html>
            """;
    }
    
    @GetMapping("/health")
    public String healthCheck() {
        return """
            {
                "status": "healthy",
                "service": "InventoryAPI",
                "timestamp": "%s",
                "version": "1.0.0",
                "developer": "Margaretha Angellina"
            }
            """.formatted(java.time.LocalDateTime.now());
    }
    
    @GetMapping("/about")
    public String about() {
        return """
            {
                "project": "Inventory Management API",
                "purpose": "Spring Boot learning project for internship application",
                "technologies": ["Java 17", "Spring Boot 3.5.9", "Spring Web", "Spring Data JPA"],
                "features": ["REST API", "Health Check", "Product Management"],
                "status": "Active Development"
            }
            """;
    }
}