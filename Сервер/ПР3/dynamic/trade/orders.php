<?php
    include 'login.php';
?>

<html lang="ru">

<head>
    <title>Управление заказами</title>
</head>

<body>
    <h1>Управление заказами</h1>

    <h2>Заказы</h2>
    <form action="/trade/add_order.php" method="post">
        <p>Название товара: <input type="text" name="title" /></p>
        <p>Количество: <input type="number" name="count"></input></p>
        <p>Адрес доставки: <input type="text" name="address" /></p>
        <p><input type="submit"/></p>
    </form>

    <?php
    $mysqli = new mysqli("db", "user", "password", "chocovoDB");
    $result = $mysqli->query("SELECT * FROM orders");
    echo "<ul>";
    foreach ($result as $row) {
        echo "<li>";
        if($row['status'] != "Отменен") {

            echo "<a href=\"/trade/cancel_order.php?ID={$row['ID']}\">";
            echo "Отменить заказ ↓";
            echo "</a><br>";
        }


        echo "{$row['ID']} {$row['title']} {$row['count']}<div>{$row['address']}</div><div>{$row['status']}</li>";
    }
    echo "</ul>";
    ?>

</body>

</html>
