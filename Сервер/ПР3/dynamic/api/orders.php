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
            $result = $mysqli->query("SELECT * FROM orders");
        
            echo toJson($result);
            break;
        case 'POST':
            $stmt = $mysqli->prepare("INSERT INTO orders (title, count, address, status) VALUES (?, ?, ?, 'В обработке')");
            $res = $stmt->bind_param('sss', $body['title'], $body['count'], $body['address']);
            $stmt->execute();

            echo 1;
            break;
        case 'PUT':
            $stmt = $mysqli->prepare("UPDATE orders SET title=?, count=?, address=?, status=? WHERE ID=?");
            $res = $stmt->bind_param('ssssi', $body['title'], $body['count'], $body['address'], $body['status'], $body['ID']);
            $stmt->execute();

            break;
        case 'DELETE':
            $stmt = $mysqli->prepare("DELETE FROM `orders` WHERE `ID`=?");
            $res = $stmt->bind_param('i', $params['ID']);
            $stmt->execute();

            echo 1;
            break;
        default:
            header("HTTP/1.1 404 Not Found");
            break;
    }
?>
