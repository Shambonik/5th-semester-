<html lang="ru">

<head>
    <title>drawer</title>
</head>

<body>
    <?php
    $code = htmlspecialchars($_GET["num"]);

    $type_figure = $code >> 40;


    $color = ($code >> 16) & 0xffffff;


    $width = ($code >> 8 & 0xff) * 2.5;
    $height = ($code & 0xff) * 2.5;

    require __DIR__ . '/first/draw.php';
    draw($width, $height, $type_figure, $color);


    echo '<br><br>type_figure ' . $type_figure;
    echo ' color ' . $color;
    echo ' width ' . $width;
    echo ' height ' . $height;
    ?>
</body>

</html>
