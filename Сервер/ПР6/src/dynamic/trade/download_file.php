<?php
	include 'login.php';

	$query = $_SERVER['QUERY_STRING'];

    $delete_args = [];

    if ( !empty( $query ) )
    {
        foreach( explode('&', $query ) as $param )
        {
            list($k, $v) = explode('=', $param);
            $k = urldecode($k);
            $v = urldecode($v);
            $delete_args[$k] = $v ;
        }
    }

    $file_name = $delete_args['name'];
    $file_content = $redisFiles->get($file_name);
    $file_address = "/var/www/files/{$file_name}";
    file_put_contents($file_address, $file_content);
    header("Location: /files/{$file_name}");
?>