<html lang="ru">

<head>
    <title>Shell sort</title>
</head>

<body>
    <?php
    $arrayString = htmlspecialchars($_GET["arr"]);

    $array = array_map(null, explode(',', $arrayString));

    require __DIR__ . '/second/sort.php';
    print_r(shellSort($array));
    ?>
</body>

</html>
