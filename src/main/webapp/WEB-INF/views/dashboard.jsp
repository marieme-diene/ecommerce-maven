<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard - E-Commerce</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .header {
            background-color: #333;
            color: white;
            padding: 1rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header h1 {
            margin: 0;
        }
        .nav-links {
            display: flex;
            gap: 1rem;
        }
        .nav-links a {
            color: white;
            text-decoration: none;
            padding: 0.5rem 1rem;
            border-radius: 4px;
            transition: background-color 0.3s;
        }
        .nav-links a:hover {
            background-color: #555;
        }
        .container {
            max-width: 1200px;
            margin: 2rem auto;
            padding: 0 1rem;
        }
        .dashboard-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 1.5rem;
            margin-top: 2rem;
        }
        .card {
            background: white;
            padding: 1.5rem;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            text-align: center;
        }
        .card h3 {
            color: #333;
            margin-bottom: 1rem;
        }
        .card a {
            display: inline-block;
            padding: 0.5rem 1rem;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s;
        }
        .card a:hover {
            background-color: #0056b3;
        }
        .welcome {
            background: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            margin-bottom: 2rem;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>E-Commerce Management System</h1>
        <div class="nav-links">
            <a href="/users">Users</a>
            <a href="/products">Products</a>
            <a href="/purchases">Purchases</a>
            <a href="/sales">Sales</a>
            <a href="/logout">Logout</a>
        </div>
    </div>
    
    <div class="container">
        <div class="welcome">
            <h2>Welcome to E-Commerce Management System</h2>
            <p>Hello, <strong>${pageContext.request.userPrincipal.name}</strong>! Choose an option below to manage your data.</p>
        </div>
        
        <div class="dashboard-grid">
            <div class="card">
                <h3>Users Management</h3>
                <p>Manage user accounts and authentication</p>
                <a href="/users">Manage Users</a>
            </div>
            
            <div class="card">
                <h3>Products Management</h3>
                <p>Manage product inventory and details</p>
                <a href="/products">Manage Products</a>
            </div>
            
            <div class="card">
                <h3>Purchases Management</h3>
                <p>Track and manage purchase orders</p>
                <a href="/purchases">Manage Purchases</a>
            </div>
            
            <div class="card">
                <h3>Sales Management</h3>
                <p>Track and manage sales transactions</p>
                <a href="/sales">Manage Sales</a>
            </div>
        </div>
    </div>
</body>
</html>
