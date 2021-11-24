<?php
    include 'login.php';
    include 'constants.php';

    $dictionary = $DICTIONARY[$_SESSION['language']];
?>

<html lang="<?php echo $_SESSION['language'] ?>">

<head>
    <title><?php echo $dictionary->ADMIN_PANEL ?></title>
    <?php 
        if ($_SESSION['theme'] == THEME::$DARK) {
            echo '<link rel="stylesheet" href="http://localhost/dark-theme.css">';
        }
        else{
            echo '<link rel="stylesheet" href="http://localhost/light-theme.css">';
        }
    ?>
</head>

<body>
    <h1><?php echo $dictionary->ADMIN_PANEL ?></h1>

    <div>
        <?php
            echo $_SESSION['name'] ?: $dictionary->NAMELESS;
        ?>
    </div>

    <h2><?php echo $dictionary->SETTING ?></h2>
    <form action="/trade/setting.php" method="post">
        <div>
            <?php echo $dictionary->THEME ?>: <br>
            <label>
                <input type="radio" name="theme" 
                    <?php 
                        if ($_SESSION['theme'] == THEME::$LIGHT) {
                            echo "checked";
                        }
                    ?>
                    value="light"
                >
                <?php echo $dictionary->LIGHT ?>
            </label>
            <label>
                <input type="radio" name="theme" 
                    <?php 
                        if ($_SESSION['theme'] == THEME::$DARK) {
                            echo "checked";
                        }
                    ?>
                    value="dark"
                >
                <?php echo $dictionary->DARK ?>
            </label>
        </div>

        <div>
            <?php echo $dictionary->LANGUAGE ?>: <br>
            <label>
                <input type="radio" name="language"
                    <?php 
                        if ($_SESSION['language'] == LANGUAGE::$RU) {
                            echo "checked";
                        }
                    ?>
                    value="ru"
                >
                Русский
            </label>
            <label>
                <input type="radio" name="language"
                    <?php 
                        if ($_SESSION['language'] == LANGUAGE::$EN) {
                            echo "checked";
                        }
                    ?>
                    value="en"
                >
                English
            </label>
        </div>

        <div>
            <label>
                <?php echo $dictionary->NAME ?>:
                <input type="text" name="name">
            </label>
        </div>

        <button type="submit"><?php echo $dictionary->UPDATE ?></button>
    </form>

    <h2>PDF</h2>
    <form enctype="multipart/form-data" action="/trade/save_file.php" method="POST">
        <input type="hidden" name="MAX_FILE_SIZE" value="30000000000" />
        <div>
            <?php echo $dictionary->SEND_THIS_FILE ?>: 
            <label for="uploadbtn" class="uploadButton">
            <?php echo $dictionary->UPLOAD_FILE ?>
            </label>
            <div class="list-pdf"></div>
            <input 
                style="opacity: 0; z-index: -1;" 
                type="file" name="userfile" id="uploadbtn" 
                onchange='document.querySelector(".uploadButton + div").innerHTML = Array.from(this.files).map(f => f.name).join("<br />")' 
            />
        </div>
        <input type="submit" value="<?php echo $dictionary->SEND_FILE ?>" />
    </form>

    <h2><?php echo $dictionary->UPLOADING_FILES ?></h2>

    <?php
        $filenames = $redisFiles->keys('*');
        echo "<ul>";
        foreach ($filenames as $filename) {
            echo "<li><a href=\"/trade/download_file.php?name={$filename}\" target=\"_blank\">{$filename}</a></li>";
        }
        echo "</ul>";
    ?>
    
    <h2><?php echo $dictionary->ADMINISTRATORS ?></h2>
    <form action="/trade/add_user.php" method="post">
        <p><?php echo $dictionary->LOGIN ?>: <input type="text" name="name" /></p>
        <p><?php echo $dictionary->PASSWORD ?>: <input type="password" name="password" /></p>
        <p><button type="submit"><?php echo $dictionary->SEND ?></button></p>
    </form>

    <?php

    $mysqli = new mysqli("db", "user", "password", "chocovoDB");
    $result = $mysqli->query("SELECT * FROM users");
    echo "<ul>";
    foreach ($result as $row) {
        echo "<li>";

        echo "<a href=\"/trade/delete_user.php?ID={$row['ID']}\">";
        echo "X";
        echo "</a>";

        echo "{$row['ID']} {$row['name']}</li>";
    }
    echo "</ul>";
    ?>

    <h2><?php echo $dictionary->ORDERS ?></h2>
    <form action="/trade/add_order.php" method="post">
        <p><?php echo $dictionary->ORDER_TITLE ?>: <input type="text" name="title" /></p>
        <p><?php echo $dictionary->ORDER_COUNT ?>: <input type="number" name="count"></input></p>
        <p><?php echo $dictionary->ORDER_ADDRESS ?>: <input type="text" name="address" /></p>
        <p><input type="submit"/></p>
    </form>

    <?php
    $mysqli = new mysqli("db", "user", "password", "chocovoDB");
    $result = $mysqli->query("SELECT * FROM orders");
    echo "<ul>";
    foreach ($result as $row) {
        echo "<li>";
        if($row['status'] != "Отменен") {

            echo "<a href=\"/trade/cancel_order.php?ID={$row['ID']}\">";
            echo $dictionary->CANCEL_ORDER;
            echo "</a><br>";
        }


        echo "{$row['ID']} {$row['title']} {$row['count']}<div>{$row['address']}</div>";

        if($row['status'] != "Отменен") {
            echo $dictionary->ORDER_PROCESSING;
        }
        else{
            echo $dictionary->ORDER_CANCELED;
        }
        echo "</li>";
    }
    echo "</ul>";
    ?>

</body>

</html>
