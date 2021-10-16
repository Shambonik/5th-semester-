<?php
    include 'login.php';
?>

<html lang="ru">

<head>
    <title>Управление пользователями</title>
</head>

<body>
    <h1>Управление пользователями</h1>

    <h2>Заказчики</h2>
    <form action="/trade/add_user.php" method="post">
        <p>Логин: <input type="text" name="name" /></p>
        <p>Пароль: <input type="password" name="password" /></p>
        <p><input type="submit" /></p>
    </form>

    <?php
    $mysqli = new mysqli("db", "user", "password", "chocovoDB");
    $result = $mysqli->query("SELECT * FROM users");
    echo "<ul>";
    foreach ($result as $row) {
        echo "<li>";

        echo "<a href=\"/trade/delete_user.php?ID={$row['ID']}\">";
        echo "Удалить пользователя ↓";
        echo "</a><br>";

        echo "{$row['ID']} {$row['name']}</li>";
    }
    echo "</ul>";
    ?>

</body>

</html>
