<?php
    include 'login.php';

    $redis_data = json_decode($redis->get($_SERVER['PHP_AUTH_USER']));
    $saved_name = $_POST['name'] === "" ? $redis_data->name : $_POST['name'];
    $data_redis = json_encode([
        "language" => $_POST['language'],
        "theme" => $_POST['theme'],
        'name' => $saved_name
     ]);

    $redis->set($_SERVER['PHP_AUTH_USER'], $data_redis);
    
    
    $_SESSION['language'] = $_POST['language'];
    $_SESSION['theme'] = $_POST['theme'];
    $_SESSION['name'] = $saved_name; 

    header('Location: /trade/index.php');
?>
