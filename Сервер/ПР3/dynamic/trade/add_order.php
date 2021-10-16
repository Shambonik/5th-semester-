<?php
    include 'login.php';

    $mysqli = new mysqli("db", "user", "password", "chocovoDB");
    $stmt = $mysqli->prepare("INSERT INTO orders (title, count, address, status) VALUES (?, ?, ?, 'В обработке')");
    $res = $stmt->bind_param('sss', $_POST['title'], $_POST['count'], $_POST['address']);
    $stmt->execute();

    header('Location: /trade/orders.php');
?>
