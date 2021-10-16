<?php

    if (!isset($_SERVER['PHP_AUTH_USER'])) {
        header('WWW-Authenticate: Basic realm="My Realm"');
        header('HTTP/1.0 401 Unauthorized');
        echo 'Авторизация отменена';
        exit;
    }

    $mysqli = new mysqli("db", "user", "password", "chocovoDB");
    $stmt = $mysqli->prepare("SELECT `password` FROM users WHERE `name`=?");
    $res = $stmt->bind_param('s', $_SERVER['PHP_AUTH_USER']);
    $stmt->execute();
    $result = $stmt->get_result();
    $user = $result->fetch_array(MYSQLI_ASSOC);

    if ($_SERVER['PHP_AUTH_PW'] !== $user['password']) {
        header('WWW-Authenticate: Basic realm="My Realm"');
        header('HTTP/1.0 401 Unauthorized');
        exit;
    }
?>
