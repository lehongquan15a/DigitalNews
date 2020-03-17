<%-- 
    Document   : index.jsp
    Created on : Jan 7, 2020, 9:36:23 PM
    Author     : ThinkPro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Digital News</title>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <style>
            .page ul{
                justify-content: center;
                display: flex;  
            }
            ul li{
                border-radius: 10px;
                list-style: none;
                border: 1px solid green;
                margin-right: 0.25rem;
            }
            .active{
                color: red;
                border-color: red;
            }
        </style>
        <script src="client/submitForm.js" type="text/javascript"></script>

    </head>

    <body>
        <div class="preheader"></div>
        <div class="header"><b>My Digital News</b></div>
        <div class="menu"><a href="home">News</a></div>
        <div class="main">
            <div class="left-main">
                <c:if test="${listNews.size()==0}">Not Found!</c:if>
                <c:forEach items="${listNews}" var="n">
                    <a href="home?id=${n.id}" class="title">${n.title}</a> 
                    <div class="eyes">
                        <img src="images/${n.image}">
                    </div>
                </c:forEach>
                <c:if test="${listCount.size()>1}">
                <div class="page">
                    <ul>
                        <c:forEach items="${listCount}" var="i">
                            <li <c:if test="${page == i}">class="active"</c:if>><a onclick="submitForm('search', ['page', 'inputSearch'], ['${i}', '${text}'])">${i}</a></li>
                            </c:forEach>
                    </ul>
                </div>
                </c:if>
            </div>
            <div class="right-main">
                <div class="option">Digital News</div>
                <div class="text">
                    ${listTop5.get(0).description}
                </div>
                <div class="option">Search</div>
                <form action="search" method="POST">
                    <div class="search">
                        <input type="text" id="search" placeholder="input text here... " name="inputSearch"><input class="btn-go" type="submit" value="Go">
                    </div>
                </form>
                <div class="option">Last Articles</div>
                <div class="link">
                    <c:forEach items="${listTop5}" var="n">
                        <a onclick="submitForm('home', ['id'], [${n.id}])" class="text">${n.title}</a> 
                    </c:forEach>

                </div>
            </div>

        </div>
        <div class="footer">

        </div>

        <form id="frm" method="POST">
        </form>

    </body>
</html>
