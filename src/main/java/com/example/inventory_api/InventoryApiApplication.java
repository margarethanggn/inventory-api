package com.example.inventoryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@SpringBootApplication
@RestController
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
                    body { font-family: Arial, sans-serif; margin: 40px; background: #f5f5f5; }
                    .container { max-width: 900px; margin: 0 auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }
                    h1 { color: #2c3e50; border-bottom: 3px solid #3498db; padding-bottom: 10px; }
                    .endpoint { background: #f8f9fa; padding: 15px; margin: 10px 0; border-left: 5px solid #3498db; border-radius: 5px; }
                    .method { display: inline-block; padding: 5px 10px; background: #3498db; color: white; border-radius: 3px; font-weight: bold; margin-right: 10px; }
                    .url { font-family: monospace; color: #2c3e50; }
                    .status { float: right; background: #27ae60; color: white; padding: 3px 10px; border-radius: 3px; font-size: 12px; }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>📦 Inventory Management API</h1>
                    <p>Spring Boot REST API for inventory management • <span class="status">Status: ONLINE</span></p>
                    
                    <h2>📊 API Documentation</h2>
                    
                    <div class="endpoint">
                        <span class="method">GET</span>
                        <span class="url">/</span>
                        <p>API homepage with documentation</p>
                    </div>
                    
                    <div class="endpoint">
                        <span class="method">GET</span>
                        <span class="url">/health</span>
                        <p>Health check endpoint</p>
                    </div>
                    
                    <div class="endpoint">
                        <span class="method">GET</span>
                        <span class="url">/about</span>
                        <p>Project information</p>
                    </div>
                    
                    <div class="endpoint">
                        <span class="method">GET</span>
                        <span class="url">/api/products</span>
                        <p>Get all products</p>
                    </div>
                    
                    <div class="endpoint">
                        <span class="method">GET</span>
                        <span class="url">/api/products/{id}</span>
                        <p>Get product by ID</p>
                    </div>
                    
                    <div class="endpoint">
                        <span class="method">POST</span>
                        <span class="url">/api/products</span>
                        <p>Create new product</p>
                    </div>
                    
                    <div class="endpoint">
                        <span class="method">GET</span>
                        <span class="url">/api/products/categories</span>
                        <p>Get product categories</p>
                    </div>
                    
                    <h3>🔧 Technical Information</h3>
                    <ul>
                        <li><strong>Framework:</strong> Spring Boot 3.5.9</li>
                        <li><strong>Java Version:</strong> 17</li>
                        <li><strong>Deployment:</strong> Railway Cloud</li>
                        <li><strong>Build Tool:</strong> Apache Maven</li>
                    </ul>
                    
                    <p><em>Created by: Margaretha Angellina Nainggolan</em></p>
                </div>
            </body>
            </html>
            """;
    }
    
    @GetMapping("/health")
    public String healthCheck() {
        return String.format("""
            {
                "status": "healthy",
                "service": "InventoryAPI",
                "timestamp": "%s",
                "version": "1.0.0",
                "developer": "Margaretha Angellina",
                "environment": "production",
                "uptime": "100%%"
            }
            """, LocalDateTime.now());
    }
    
    @GetMapping("/about")
    public String about() {
        return """
            {
                "project": "Inventory Management API",
                "purpose": "Spring Boot learning project for internship application",
                "technologies": ["Java 17", "Spring Boot 3.5.9", "Spring Web", "REST API"],
                "features": ["REST API", "Health Check", "Product Management", "Cloud Deployment"],
                "status": "Production",
                "deployment": "Railway Cloud",
                "endpoints": 7,
                "repository": "https://github.com/margarethanggn/inventory-api"
            }
            """;
    }
}
