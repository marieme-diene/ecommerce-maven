<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Users Management - E-Commerce</title>
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
        .table-container {
            background: white;
            padding: 1.5rem;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .btn {
            padding: 0.5rem 1rem;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            transition: background-color 0.3s;
        }
        .btn-primary {
            background-color: #007bff;
            color: white;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .btn-success {
            background-color: #28a745;
            color: white;
        }
        .btn-success:hover {
            background-color: #1e7e34;
        }
        .btn-danger {
            background-color: #dc3545;
            color: white;
        }
        .btn-danger:hover {
            background-color: #c82333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 1rem;
        }
        th, td {
            padding: 0.75rem;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f8f9fa;
            font-weight: bold;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .actions {
            display: flex;
            gap: 0.5rem;
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
        <div class="table-container">
            <h2>Users Management</h2>
            <a href="/users/new" class="btn btn-primary">Add New User</a>
            
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.email}</td>
                            <td>••••••••</td>
                            <td>
                                <div class="actions">
                                    <a href="/users/edit/${user.id}" class="btn btn-success">Edit</a>
                                    <a href="/users/delete/${user.id}" class="btn btn-danger" 
                                       onclick="return confirm('Are you sure you want to delete this user?')">Delete</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
