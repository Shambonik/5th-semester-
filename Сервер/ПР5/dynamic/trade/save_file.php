<?php 
    include 'login.php';
    

    if (substr($_FILES['userfile']['name'], -4) == ".pdf"){
        $file_data_redis = json_encode($file_data);
        $redisFiles->set($_FILES['userfile']['name'], file_get_contents($_FILES['userfile']['tmp_name']));
        header('Location: /trade/index.php');
    }
    else {
        echo '<pre>';
        echo 'Расширение файла должно быть .pdf<br>';
        echo 'The file extension must be .pdf';
        echo '</pre>';
    }
?>
