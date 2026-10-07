<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Результат</title>
</head>
<body>
<style>
    div {
        width: 50%;
        height: auto;
        margin: 20px auto;
        padding: 20px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    }

    a {
        display: inline-block;
        padding: 12px 28px;
        font-size: 16px;
        font-weight: 600;
        color: #ffffff;
        background: #dabfbf;
        border-radius: 5px;
        text-decoration: none;
        box-shadow: 0 4px 15px rgb(67 73 97 / 0.4);
        margin: 0 auto;
    }

    a:hover {
        opacity: 0.8;
    }

    .main {
        display: flex;
        flex-direction: column;
    }

    .overflow {
        overflow-y: auto;
        width: 50%;
        height: 400px;
        margin: 20px auto;
        padding: 20px;
        border: 1px solid #ccc;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin: 0 auto;
    }

    td, th {
        border: 1px solid rgb(238, 238, 238);
        padding: 10px;
        text-align: center;
    }

</style>

<jsp:useBean id="fc" class="ua.edu.nuos.web_lab_3.model.FunctionCalculator" scope="request"/>
<div class="main">
    <div>
        <h2>Мінімум:</h2>
        <c:out value="Номер: ${fc.minIndexY}"/>
        <c:out value="x = ${fc.points[fc.minIndexY].x()}"/>
        <c:out value="y = ${fc.points[fc.minIndexY].y()}"/>
    </div>

    <div>
        <h2>Максимум:</h2>
        <c:out value="Номер: ${fc.maxIndexY}"/>
        <c:out value="x = ${fc.points[fc.maxIndexY].x()}"/>
        <c:out value="y = ${fc.points[fc.maxIndexY].y()}"/>
    </div>


    <a href="${pageContext.request.contextPath}/index.html">
        Ввести нові значення
    </a>
</div>

<section class="overflow">
    <table>
        <thead>
        <tr>
            <th>№</th>
            <th>x</th>
            <th>y</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${fc.points}" var="p" varStatus="st">
            <tr>
                <td>${st.index}</td>
                <td><fmt:formatNumber  value="${p.x()}" type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
                <td><fmt:formatNumber value="${p.y()}" type="number" minFractionDigits="4" maxFractionDigits="4"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

</body>
</html>