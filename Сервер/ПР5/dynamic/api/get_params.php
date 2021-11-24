<?php
    function getParams()
    {
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

        return $delete_args;
    }
?>