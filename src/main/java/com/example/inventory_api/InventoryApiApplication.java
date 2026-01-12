package com.example.inventoryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
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
        String port = System.getenv("PORT");
        if (port != null && !port.trim().isEmpty()) {
            System.setProperty("server.port", port.trim());
            System.out.println("⚡ Using PORT from environment: " + port);
        } else {
            System.setProperty("server.port", "8080");
            System.out.println("⚠️  PORT not set, using default 8080");
        }
        
        SpringApplication.run(InventoryApiApplication.class, args);
    }
    
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<String> home() {
        String currentTime = LocalDateTime.now().toString();
        String html = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <title>Inventory Management API</title>\n" +
            "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\">\n" +
            "    <style>\n" +
            "        body {\n" +
            "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
            "            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);\n" +
            "            margin: 0;\n" +
            "            padding: 20px;\n" +
            "            min-height: 100vh;\n" +
            "            display: flex;\n" +
            "            justify-content: center;\n" +
            "            align-items: center;\n" +
            "        }\n" +
            "        .container {\n" +
            "            background: white;\n" +
            "            border-radius: 20px;\n" +
            "            box-shadow: 0 20px 60px rgba(0,0,0,0.3);\n" +
            "            max-width: 1000px;\n" +
            "            width: 100%;\n" +
            "            overflow: hidden;\n" +
            "        }\n" +
            "        .header {\n" +
            "            background: linear-gradient(135deg, #2c3e50 0%, #4a6491 100%);\n" +
            "            color: white;\n" +
            "            padding: 40px;\n" +
            "            text-align: center;\n" +
            "        }\n" +
            "        .header h1 {\n" +
            "            font-size: 2.5rem;\n" +
            "            margin-bottom: 15px;\n" +
            "        }\n" +
            "        .status {\n" +
            "            display: inline-block;\n" +
            "            background: #27ae60;\n" +
            "            color: white;\n" +
            "            padding: 8px 20px;\n" +
            "            border-radius: 50px;\n" +
            "            font-weight: bold;\n" +
            "            margin-top: 10px;\n" +
            "        }\n" +
            "        .content {\n" +
            "            padding: 40px;\n" +
            "            display: grid;\n" +
            "            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));\n" +
            "            gap: 30px;\n" +
            "        }\n" +
            "        .card {\n" +
            "            background: #f8f9fa;\n" +
            "            padding: 30px;\n" +
            "            border-radius: 15px;\n" +
            "            border-left: 5px solid #3498db;\n" +
            "        }\n" +
            "        .card h3 {\n" +
            "            color: #2c3e50;\n" +
            "            margin-bottom: 20px;\n" +
            "        }\n" +
            "        .endpoint {\n" +
            "            background: #2c3e50;\n" +
            "            color: white;\n" +
            "            padding: 10px 15px;\n" +
            "            border-radius: 8px;\n" +
            "            font-family: monospace;\n" +
            "            margin: 10px 0;\n" +
            "            display: block;\n" +
            "        }\n" +
            "        .footer {\n" +
            "            background: #2c3e50;\n" +
            "            color: white;\n" +
            "            padding: 20px;\n" +
            "            text-align: center;\n" +
            "        }\n" +
            "        .tech {\n" +
            "            display: inline-block;\n" +
            "            background: #3498db;\n" +
            "            color: white;\n" +
            "            padding: 5px 15px;\n" +
            "            border-radius: 20px;\n" +
            "            margin: 5px;\n" +
            "            font-size: 0.9rem;\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <div class=\"container\">\n" +
            "        <div class=\"header\">\n" +
            "            <h1><i class=\"fas fa-boxes\"></i> Inventory Management API</h1>\n" +
            "            <p>Spring Boot REST API deployed on Railway Cloud</p>\n" +
            "            <div class=\"status\">\n" +
            "                <i class=\"fas fa-circle\"></i> Status: OPERATIONAL\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        \n" +
            "        <div class=\"content\">\n" +
            "            <div class=\"card\">\n" +
            "                <h3><i class=\"fas fa-plug\"></i> API Endpoints</h3>\n" +
            "                <span class=\"endpoint\">GET /health</span>\n" +
            "                <span class=\"endpoint\">GET /ping</span>\n" +
            "                <span class=\"endpoint\">GET /about</span>\n" +
            "                <span class=\"endpoint\">GET /api/products</span>\n" +
            "            </div>\n" +
            "            \n" +
            "            <div class=\"card\">\n" +
            "                <h3><i class=\"fas fa-cogs\"></i> Technology Stack</h3>\n" +
            "                <span class=\"tech\">Java 17</span>\n" +
            "                <span class=\"tech\">Spring Boot</span>\n" +
            "                <span class=\"tech\">Maven</span>\n" +
            "                <span class=\"tech\">Railway</span>\n" +
            "                <span class=\"tech\">REST API</span>\n" +
            "                <span class=\"tech\">Docker</span>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        \n" +
            "        <div class=\"footer\">\n" +
            "            <p>Developed by Margaretha Angellina Nainggolan</p>\n" +
            "            <p>Deployed: " + currentTime + "</p>\n" +
            "            <p>\n" +
            "                <a href=\"/health\" style=\"color: #4cc9f0; margin: 0 10px;\">Health</a> | \n" +
            "                <a href=\"/about\" style=\"color: #4cc9f0; margin: 0 10px;\">About</a> | \n" +
            "                <a href=\"https://railway.app\" target=\"_blank\" style=\"color: #4cc9f0; margin: 0 10px;\">Railway</a>\n" +
            "            </p>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "</body>\n" +
            "</html>";
        
        return ResponseEntity.ok(html);
    }
    
    @GetMapping("/health")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> health() {
        return ResponseEntity.ok(Map.of(
            "status", "UP",
            "service", "inventory-api",
            "timestamp", LocalDateTime.now().toString(),
            "version", "1.0.0"
        ));
    }
    
    @GetMapping("/ping")
    @ResponseBody
    public ResponseEntity<Map<String, String>> ping() {
        return ResponseEntity.ok(Map.of(
            "status", "pong",
            "timestamp", LocalDateTime.now().toString()
        ));
    }
    
    @GetMapping("/about")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> about() {
        return ResponseEntity.ok(Map.of(
            "project", "Inventory Management API",
            "version", "1.0.0",
            "developer", "Margaretha Angellina Nainggolan",
            "framework", "Spring Boot 3.5.9",
            "deployment", "Railway Cloud",
            "url", "https://inventory-api-production-851c.up.railway.app"
        ));
    }
}
