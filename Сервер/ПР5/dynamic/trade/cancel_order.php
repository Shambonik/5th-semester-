<?php
    include 'login.php';
    
    $mysqli = new mysqli("db", "user", "password", "chocovoDB");
    $stmt = $mysqli->prepare("UPDATE orders SET status = 'Отменен' WHERE `ID`=?");
    $res = $stmt->bind_param('i', $_GET['ID']);
    $stmt->execute();
    
    header('Location: /trade/index.php');
?>