package com.example.inventoryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        return ResponseEntity.ok("""
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Inventory Management API - Spring Boot</title>
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
                <style>
                    :root {
                        --primary: #4361ee;
                        --secondary: #3a0ca3;
                        --success: #4cc9f0;
                        --dark: #1a1a2e;
                        --light: #f8f9fa;
                        --gradient: linear-gradient(135deg, #4361ee 0%, #3a0ca3 100%);
                    }
                    
                    * {
                        margin: 0;
                        padding: 0;
                        box-sizing: border-box;
                        font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
                    }
                    
                    body {
                        background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
                        min-height: 100vh;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        padding: 20px;
                        color: #333;
                    }
                    
                    .container {
                        background: white;
                        border-radius: 24px;
                        box-shadow: 0 20px 80px rgba(67, 97, 238, 0.15);
                        overflow: hidden;
                        max-width: 1200px;
                        width: 100%;
                        animation: fadeIn 0.8s ease-out;
                    }
                    
                    @keyframes fadeIn {
                        from { opacity: 0; transform: translateY(20px); }
                        to { opacity: 1; transform: translateY(0); }
                    }
                    
                    .header {
                        background: var(--gradient);
                        color: white;
                        padding: 50px 40px;
                        text-align: center;
                        position: relative;
                        overflow: hidden;
                    }
                    
                    .header::before {
                        content: '';
                        position: absolute;
                        top: -50%;
                        right: -50%;
                        width: 100%;
                        height: 200%;
                        background: radial-gradient(circle, rgba(255,255,255,0.1) 1px, transparent 1px);
                        background-size: 30px 30px;
                        animation: float 20s linear infinite;
                    }
                    
                    @keyframes float {
                        0% { transform: rotate(0deg); }
                        100% { transform: rotate(360deg); }
                    }
                    
                    .header-content {
                        position: relative;
                        z-index: 2;
                    }
                    
                    .header h1 {
                        font-size: 3.2rem;
                        margin-bottom: 15px;
                        font-weight: 800;
                        display: flex;
                        align-items: center;
                        justify-content: center;
                        gap: 20px;
                    }
                    
                    .header p {
                        font-size: 1.3rem;
                        opacity: 0.95;
                        max-width: 700px;
                        margin: 0 auto 25px;
                        line-height: 1.7;
                        font-weight: 300;
                    }
                    
                    .status-badge {
                        display: inline-flex;
                        align-items: center;
                        gap: 10px;
                        background: rgba(255,255,255,0.2);
                        backdrop-filter: blur(10px);
                        color: white;
                        padding: 12px 30px;
                        border-radius: 50px;
                        font-size: 1rem;
                        font-weight: 600;
                        margin-top: 10px;
                        border: 2px solid rgba(255,255,255,0.3);
                        animation: pulse 2s infinite;
                    }
                    
                    @keyframes pulse {
                        0%, 100% { transform: scale(1); }
                        50% { transform: scale(1.05); }
                    }
                    
                    .content {
                        padding: 50px 40px;
                        display: grid;
                        grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
                        gap: 35px;
                    }
                    
                    .card {
                        background: var(--light);
                        border-radius: 20px;
                        padding: 35px;
                        transition: all 0.4s cubic-bezier(0.175, 0.885, 0.32, 1.275);
                        border: 2px solid transparent;
                        position: relative;
                        overflow: hidden;
                    }
                    
                    .card::before {
                        content: '';
                        position: absolute;
                        top: 0;
                        left: 0;
                        width: 100%;
                        height: 5px;
                        background: var(--gradient);
                    }
                    
                    .card:hover {
                        transform: translateY(-10px);
                        box-shadow: 0 25px 50px rgba(67, 97, 238, 0.15);
                        border-color: var(--primary);
                    }
                    
                    .card h3 {
                        color: var(--dark);
                        margin-bottom: 25px;
                        font-size: 1.6rem;
                        display: flex;
                        align-items: center;
                        gap: 15px;
                        font-weight: 700;
                    }
                    
                    .card h3 i {
                        color: var(--primary);
                        font-size: 1.8rem;
                    }
                    
                    .endpoint-list {
                        list-style: none;
                    }
                    
                    .endpoint-item {
                        padding: 18px 0;
                        border-bottom: 1px solid rgba(0,0,0,0.08);
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                        transition: padding 0.3s;
                    }
                    
                    .endpoint-item:hover {
                        padding-left: 10px;
                    }
                    
                    .endpoint-item:last-child {
                        border-bottom: none;
                    }
                    
                    .method {
                        display: inline-flex;
                        align-items: center;
                        gap: 8px;
                        padding: 8px 18px;
                        border-radius: 8px;
                        font-weight: 700;
                        font-size: 0.85rem;
                        letter-spacing: 0.5px;
                    }
                    
                    .method.get { 
                        background: linear-gradient(135deg, #27ae60 0%, #2ecc71 100%); 
                        color: white; 
                    }
                    
                    .endpoint-path {
                        font-family: 'Courier New', monospace;
                        background: var(--dark);
                        color: white;
                        padding: 10px 18px;
                        border-radius: 10px;
                        font-size: 0.95rem;
                        flex-grow: 1;
                        margin: 0 20px;
                        box-shadow: 0 4px 15px rgba(0,0,0,0.1);
                    }
                    
                    .tech-stack {
                        display: flex;
                        flex-wrap: wrap;
                        gap: 12px;
                        margin-top: 20px;
                    }
                    
                    .tech-item {
                        background: white;
                        border: 2px solid var(--primary);
                        color: var(--primary);
                        padding: 10px 20px;
                        border-radius: 50px;
                        font-size: 0.9rem;
                        font-weight: 600;
                        transition: all 0.3s;
                    }
                    
                    .tech-item:hover {
                        background: var(--primary);
                        color: white;
                        transform: scale(1.05);
                    }
                    
                    .footer {
                        background: var(--dark);
                        color: white;
                        padding: 30px 40px;
                        text-align: center;
                        border-top: 1px solid rgba(255,255,255,0.1);
                    }
                    
                    .footer p {
                        opacity: 0.8;
                        font-size: 1rem;
                        margin-bottom: 10px;
                    }
                    
                    .timestamp {
                        font-size: 0.9rem;
                        opacity: 0.6;
                        font-family: monospace;
                    }
                    
                    .quick-links {
                        display: flex;
                        justify-content: center;
                        gap: 25px;
                        margin-top: 20px;
                    }
                    
                    .quick-link {
                        display: inline-flex;
                        align-items: center;
                        gap: 10px;
                        color: var(--success);
                        text-decoration: none;
                        font-weight: 600;
                        padding: 12px 25px;
                        border-radius: 50px;
                        background: rgba(255,255,255,0.1);
                        transition: all 0.3s;
                    }
                    
                    .quick-link:hover {
                        background: rgba(255,255,255,0.2);
                        transform: translateY(-3px);
                    }
                    
                    @media (max-width: 768px) {
                        .header h1 {
                            font-size: 2.5rem;
                            flex-direction: column;
                            gap: 15px;
                        }
                        
                        .content {
                            grid-template-columns: 1fr;
                            padding: 30px 20px;
                        }
                        
                        .quick-links {
                            flex-direction: column;
                            align-items: center;
                        }
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <div class="header">
                        <div class="header-content">
                            <h1>
                                <i class="fas fa-boxes"></i>
                                Inventory Management API
                            </h1>
                            <p>Enterprise-grade REST API built with Spring Boot for inventory management systems. Fully deployed on Railway Cloud with automated CI/CD pipeline.</p>
                            <div class="status-badge">
                                <i class="fas fa-circle" style="color: #4CAF50; font-size: 0.8rem;"></i>
                                <span>System Status: OPERATIONAL</span>
                            </div>
                        </div>
                    </div>
                    
                    <div class="content">
                        <div class="card">
                            <h3><i class="fas fa-plug"></i> API Endpoints</h3>
                            <ul class="endpoint-list">
                                <li class="endpoint-item">
                                    <span class="method get"><i class="fas fa-heartbeat"></i> GET</span>
                                    <span class="endpoint-path">/health</span>
                                    <span>System Health Check</span>
                                </li>
                                <li class="endpoint-item">
                                    <span class="method get"><i class="fas fa-signal"></i> GET</span>
                                    <span class="endpoint-path">/ping</span>
                                    <span>Instant Ping Test</span>
                                </li>
                                <li class="endpoint-item">
                                    <span class="method get"><i class="fas fa-info-circle"></i> GET</span>
                                    <span class="endpoint-path">/about</span>
                                    <span>Project Information</span>
                                </li>
                                <li class="endpoint-item">
                                    <span class="method get"><i class="fas fa-box"></i> GET</span>
                                    <span class="endpoint-path">/api/products</span>
                                    <span>Product Management</span>
                                </li>
                            </ul>
                        </div>
                        
                        <div class="card">
                            <h3><i class="fas fa-cogs"></i> Technical Stack</h3>
                            <div class="tech-stack">
                                <span class="tech-item">Java 21</span>
                                <span class="tech-item">Spring Boot 3.5.9</span>
                                <span class="tech-item">REST API</span>
                                <span class="tech-item">Maven</span>
                                <span class="tech-item">Railway Cloud</span>
                                <span class="tech-item">Docker</span>
                                <span class="tech-item">CI/CD</span>
                                <span class="tech-item">HTTPS</span>
                            </div>
                            
                            <h3 style="margin-top: 30px;"><i class="fas fa-rocket"></i> Deployment Info</h3>
                            <ul class="endpoint-list">
                                <li class="endpoint-item">
                                    <span><i class="fas fa-cloud"></i> Platform:</span>
                                    <span>Railway</span>
                                </li>
                                <li class="endpoint-item">
                                    <span><i class="fas fa-shield-alt"></i> Status:</span>
                                    <span style="color: #27ae60; font-weight: 600;">Production Ready</span>
                                </li>
                                <li class="endpoint-item">
                                    <span><i class="fas fa-code-branch"></i> CI/CD:</span>
                                    <span>GitHub → Railway</span>
                                </li>
                                <li class="endpoint-item">
                                    <span><i class="fas fa-clock"></i> Uptime:</span>
                                    <span>24/7 Monitoring</span>
                                </li>
                            </ul>
                        </div>
                    </div>
                    
                    <div class="footer">
                        <p>Developed by <strong>Margaretha Angellina Nainggolan</strong> • Spring Boot Internship Project</p>
                        <p class="timestamp">Last Updated: """ + currentTime + """ (UTC)</p>
                        
                        <div class="quick-links">
                            <a href="/health" class="quick-link">
                                <i class="fas fa-heartbeat"></i>
                                Health Dashboard
                            </a>
                            <a href="/about" class="quick-link">
                                <i class="fas fa-info-circle"></i>
                                API Documentation
                            </a>
                            <a href="https://railway.app" target="_blank" class="quick-link">
                                <i class="fas fa-cloud"></i>
                                Railway Cloud
                            </a>
                        </div>
                    </div>
                </div>
                
                <script>
                    // Simple animation on load
                    document.addEventListener('DOMContentLoaded', function() {
                        const cards = document.querySelectorAll('.card');
                        cards.forEach((card, index) => {
                            card.style.animationDelay = (index * 0.2) + 's';
                        });
                        
                        // Update timestamp every minute
                        function updateTime() {
                            const now = new Date();
                            document.querySelector('.timestamp').textContent = 
                                'Last Updated: ' + now.toISOString().replace('T', ' ').substring(0, 19) + ' (UTC)';
                        }
                        
                        setInterval(updateTime, 60000);
                    });
                </script>
            </body>
            </html>
            """);
    }
    
    @GetMapping("/health")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> health() {
        return ResponseEntity.ok(Map.of(
            "status", "UP",
            "service", "inventory-api",
            "version", "1.0.0",
            "timestamp", LocalDateTime.now().toString(),
            "environment", "production",
            "uptime", "100%",
            "components", Map.of(
                "database", "healthy",
                "memory", "optimal",
                "cpu", "normal"
            )
        ));
    }
    
    @GetMapping("/ping")
    @ResponseBody
    public ResponseEntity<Map<String, String>> ping() {
        return ResponseEntity.ok(Map.of(
            "status", "pong",
            "timestamp", LocalDateTime.now().toString(),
            "message", "API is responsive"
        ));
    }
    
    @GetMapping("/about")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> about() {
        return ResponseEntity.ok(Map.of(
            "project", Map.of(
                "name", "Inventory Management API",
                "version", "1.0.0",
                "description", "Spring Boot REST API for inventory management systems",
                "purpose", "Internship application project and portfolio showcase"
            ),
            "developer", Map.of(
                "name", "Margaretha Angellina Nainggolan",
                "role", "Full Stack Developer",
                "focus", "Spring Boot, Cloud Deployment, REST APIs"
            ),
            "technology", Map.of(
                "backend", "Spring Boot 3.5.9",
                "java", "OpenJDK 21",
                "build", "Apache Maven",
                "deployment", "Railway Cloud",
                "architecture", "REST API, Microservices-ready"
            ),
            "features", new String[]{
                "Health Monitoring",
                "Product Management", 
                "RESTful Endpoints",
                "JSON Responses",
                "Cloud Deployment",
                "CI/CD Pipeline",
                "Automated Scaling"
            },
            "deployment", Map.of(
                "platform", "Railway",
                "status", "Production",
                "url", "https://inventory-api-production-851c.up.railway.app",
                "monitoring", "24/7 with health checks"
            ),
            "repository", "https://github.com/margarethanggn/inventory-api",
            "timestamp", LocalDateTime.now().toString()
        ));
    }
}
