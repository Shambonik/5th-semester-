<?php 
    include 'to_json.php';
    include 'get_body.php';
    include 'get_params.php';

    header("Access-Control-Allow-Origin: *");
    header("Content-Type: application/json; charset=UTF-8");

    
    $mysqli = new mysqli("db", "user", "password", "chocovoDB");

    $body = getBody();
    $params = getParams();

    switch ($_SERVER['REQUEST_METHOD']) {
        case 'GET':
            $result = $mysqli->query("SELECT * FROM users");
        
            echo toJson($result);
            break;
        case 'POST':
            $stmt = $mysqli->prepare("INSERT INTO users (name, password) VALUES (?, ?)");
            $res = $stmt->bind_param('ss', $body['name'], $body['password']);
            $stmt->execute();

            echo 1;
            break;
        case 'PUT':
            $stmt = $mysqli->prepare("UPDATE users SET name=?, password=? WHERE ID=?");
            $res = $stmt->bind_param('ssi', $body['name'], $body['password'], $body['ID']);
            $stmt->execute();

            break;
        case 'DELETE':
            $stmt = $mysqli->prepare("DELETE FROM `users` WHERE `ID`=?");
            $res = $stmt->bind_param('i', $params['ID']);
            $stmt->execute();

            echo 1;
            break;
        default:
            header("HTTP/1.1 404 Not Found");
            break;
    }
?>
