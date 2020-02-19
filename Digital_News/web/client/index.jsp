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
    </head>

    <body>
        <div class="preheader"></div>
        <div class="header"><b>My Digital News</b></div>
        <div class="menu"><a href="home">News</a></div>
        <div class="main">
            <div class="left-main">
                <a href="#" class="title">${currentNew.title}</a> 
                <div class="eyes">
                    <img src="images/${currentNew.image}">

                </div>
                <div class="text">${currentNew.description}
                </div>
                <hr/>
                <div class="author">
                    <img src="images/comment.gif">
                    <img src="images/timeicon.gif">
                    <div class="content-author">By ${currentNew.author} | ${currentNew.getDate()}</div>
                </div>
            </div>
            <div class="right-main">
                <div class="option">Digital News</div>
                <div class="text">
                    ${listTop5.get(0).description}
                </div>
                <div class="option">Search</div>
                <form action="search" method="get">
                    <div class="search">
                        <input type="text" id="search" placeholder="input text here... " name="inputSearch"><input class="btn-go" type="submit" value="Go">
                    </div>
                </form>
                <div class="option">Last Articles</div>
                <div class="link">
                    <c:forEach items="${listTop5}" var="n">
                        <a href="home?id=${n.id}" class="text">${n.title}</a> 
                    </c:forEach>

                </div>
            </div>

        </div>
        <div class="footer">

        </div>
    </body>
</html>
