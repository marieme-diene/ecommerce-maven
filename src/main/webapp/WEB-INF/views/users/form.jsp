<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Form - E-Commerce</title>
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
            max-width: 600px;
            margin: 2rem auto;
            padding: 0 1rem;
        }
        .form-container {
            background: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .form-group {
            margin-bottom: 1rem;
        }
        .form-group label {
            display: block;
            margin-bottom: 0.5rem;
            color: #555;
            font-weight: bold;
        }
        .form-group input {
            width: 100%;
            padding: 0.75rem;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 1rem;
        }
        .form-group input:focus {
            outline: none;
            border-color: #007bff;
            box-shadow: 0 0 0 2px rgba(0,123,255,0.25);
        }
        .btn {
            padding: 0.75rem 1.5rem;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            transition: background-color 0.3s;
            font-size: 1rem;
        }
        .btn-primary {
            background-color: #007bff;
            color: white;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .btn-secondary {
            background-color: #6c757d;
            color: white;
        }
        .btn-secondary:hover {
            background-color: #545b62;
        }
        .form-actions {
            display: flex;
            gap: 1rem;
            margin-top: 1.5rem;
        }
        h2 {
            color: #333;
            margin-bottom: 1.5rem;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>E-Commerce Management System</h1>
        <div class="nav-links">
            <a href="/dashboard">Dashboard</a>
            <a href="/users">Users</a>
            <a href="/products">Products</a>
            <a href="/purchases">Purchases</a>
            <a href="/sales">Sales</a>
            <a href="/logout">Logout</a>
        </div>
    </div>
    
    <div class="container">
        <div class="form-container">
            <h2><c:if test="${user.id == null}">Add New User</c:if><c:if test="${user.id != null}">Edit User</c:if></h2>
            
            <form method="post" action="/users">
                <input type="hidden" name="id" value="${user.id}">
                
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" value="${user.email}" required>
                </div>
                
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" value="${user.password}" required>
                </div>
                
                <div class="form-actions">
                    <button type="submit" class="btn btn-primary">
                        <c:if test="${user.id == null}">Create User</c:if>
                        <c:if test="${user.id != null}">Update User</c:if>
                    </button>
                    <a href="/users" class="btn btn-secondary">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
