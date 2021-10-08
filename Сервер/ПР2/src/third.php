<html lang="ru">

<head>
    <title>Command</title>
</head>

<body>
    <?php
    $output = null;

    $command = htmlspecialchars($_GET["command"]);
    exec($command, $output);

    require __DIR__ . '/third/printResult.php';
    printResult($output, $command);
    ?>
</body>

</html>

