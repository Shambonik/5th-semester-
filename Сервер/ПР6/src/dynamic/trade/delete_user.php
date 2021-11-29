<?php
    include 'login.php';
    
    $mysqli = new mysqli("db", "user", "password", "chocovoDB");
    $stmt = $mysqli->prepare("DELETE FROM `users` WHERE `ID`=?");
    $res = $stmt->bind_param('i', $_GET['ID']);
    $stmt->execute();
    
    header('Location: /php/trade/index.php');
?>