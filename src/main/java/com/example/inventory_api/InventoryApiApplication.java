package com.example.inventoryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class InventoryApiApplication {
    
    @PostConstruct
    public void logStartup() {
        System.out.println("=".repeat(50));
        System.out.println("🚀 INVENTORY API STARTED SUCCESSFULLY");
        System.out.println("Port from env: " + System.getenv("PORT"));
        System.out.println("Server port: " + System.getProperty("server.port"));
        System.out.println("=".repeat(50));
    }
    
    public static void main(String[] args) {
        // CRITICAL: Set port BEFORE Spring starts
        String port = System.getenv("PORT");
        if (port != null && !port.trim().isEmpty()) {
            System.setProperty("server.port", port.trim());
            System.out.println("⚡ Using PORT from environment: " + port);
        } else {
            System.out.println("⚠️  PORT not set, using default 8080");
        }
        
        SpringApplication.run(InventoryApiApplication.class, args);
    }
    
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("""
            <!DOCTYPE html>
            <html>
            <head><title>Inventory API</title></head>
            <body>
                <h1>✅ Inventory Management API</h1>
                <p>Spring Boot REST API - Successfully deployed!</p>
                <ul>
                    <li><a href="/health">Health Check</a></li>
                    <li><a href="/ping">Ping Test</a></li>
                    <li><a href="/about">About</a></li>
                </ul>
                <p><em>Deployed on Railway Cloud</em></p>
            </body>
            </html>
            """);
    }
    
    @GetMapping("/health")
    @ResponseBody
    public ResponseEntity<Map<String, String>> health() {
        // INSTANT response - no processing
        return ResponseEntity.ok(Map.of(
            "status", "UP",
            "service", "inventory-api",
            "message", "Application is healthy"
        ));
    }
    
    @GetMapping("/ping")
    @ResponseBody
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }
    
    @GetMapping("/about")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> about() {
        return ResponseEntity.ok(Map.of(
            "name", "Inventory Management API",
            "version", "1.0.0",
            "framework", "Spring Boot 3.5.9",
            "java", "OpenJDK 21",
            "developer", "Margaretha Angellina Nainggolan",
            "deployment", "Railway Cloud",
            "status", "Operational"
        ));
    }
}
