<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Test</title>
</head>
<body>
<style>
    form {
        margin: auto;
        padding: 20px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        gap: 20px;
        width: 400px;
        height: 500px;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        border-radius: 15px;
    }

    label {
        font-family: Arial, Helvetica, sans-serif;
        font-size: large;
        font-weight: bold;
        margin-right: 150px;
    }

    input {
        border: 1px solid gray;
        padding: 10px;

    }

    button {
        font-family: Arial, Helvetica, sans-serif;
        font-size: large;
        padding: 10px 50px;
        cursor: pointer;
    }

</style>

<form action="function-servlet" method="post">
    <label for="a">a:</label>
    <input id="a" value="1.5" type="number" name="a" step="any" required/>

    <label for="start">Start:</label>
    <input id="start" value="0.8" type="number" name="start" step="any" required/>

    <label for="end">End:</label>
    <input id="end" value="2.0" type="number" name="end" step="any"  required/>

    <label for="step">Step:</label>
    <input id="step" value="0.005" type="number" name="step" step="any"  required/>

    <button type="submit">Get Result</button>
</form>

</body>
</html>