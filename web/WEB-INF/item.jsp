<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME nVentory</title>
    </head>
    <body>
        <h1>Items for ${email}</h1>
        
         <p>
            <a href="login">Log out</a>
        </p>
        
        <p>
            <c:if test="${message eq 'create'}">Item created</c:if>
            <c:if test="${message eq 'update'}">Item updated</c:if>
            <c:if test="${message eq 'delete'}">Item deleted</c:if>
            <c:if test="${message eq 'error'}">Sorry, something went wrong.</c:if>
            </p>
            <ul>
            <c:forEach items="${items}" var="item">
                <li><a href="items?action=view&amp;itemId=${item.item_id}">${item.itemName} (${item.owner.firstName})</a><br></li>
            </c:forEach>
        </ul>
        <c:if test="${selectedItem eq null}">
            <h2>Create a New Item</h2>
            <form action="notes" method="post">
                Name of Item: <input type="text" name="itemName" value=""><br>
                Price:<br>
                <input type="number" name="price" value=""><br>
                <input type="hidden" name="action" value="create">
                <input type="submit" value="Create">
            </form>
        </c:if>
        <c:if test="${selectedItem ne null}">
            <h2>Edit Item</h2>
            <form action="items" method="post">
                Item Name: <input type="text" name="itemName" value="${selectedItem.itemName}"><br>
                Price:<br>
                <input type="text" name="price" value="${selectedItem.price}"><br>
                <input type="hidden" name="itemId" value="${selectedItem.itemId}">
                <input type="hidden" name="action" value="update">
                <input type="submit" value="Save">
            </form>

            <form action="items" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="itemId" value="${selectedItem.itemId}">
                <input type="submit" value="Delete">
            </form>
            <a href="notes">cancel edit</a>
        </c:if>
        
        
    </body>
</html>
