<?php 
    function toJson($result)
    {
        $response = [];
        while($row = $result->fetch_array(MYSQLI_ASSOC)) {
            $response[] = $row;
        }
        return json_encode($response);
    }
?>