
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script>
      // var xmlHttpRequest = new XMLHttpRequest();
      // xmlHttpRequest.onreadystatechange()
    </script>
  </head>
  <body>
    <form action="buy" method="get">
      <table>
        <tr>
          <td>商品</td>
          <td></td>
        </tr>
        <tr>
          <td>商品号</td>
          <td><input type="text" name="gid"></td>
        </tr>
        <tr>
          <td>数量</td>
          <td><input type="text" name="amount"></td>
        </tr>
        <tr>
          <td>
            <input type="submit" value="购买">
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>
