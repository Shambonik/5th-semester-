<?php
function draw($width, $height, $type_figure, $color)
{   
    $result = '<svg width="' . $width . '" height="' . $height . '" version="1.1" xmlns="http://www.w3.org/2000/svg">';

    $hex_color = calcColor($color);

    $is_correct_figure = true;

    switch ($type_figure) {
        case 3:
            $result = $result . ' <polygon points="' . 0 . ',' . $height . ' ' . $width / 2 . ',' . 0 . ' ' . $width . ',' . $height . '" fill="#' . $hex_color . '"/>';
            break;
        case 2:
            $result = $result . '<ellipse cx="50%" cy="50%" rx="50%" ry="50%" fill="' . "#" . $hex_color . '"/>';
            break;
        case 1:
            $result = $result . '<rect x="0" y="0" width="100%" height="100%" fill="' . "#" . $hex_color . '"/>';
            break;
        case 0:
            $result = $result . '<circle cx="50%" cy="50%" r="' . min($height, $width) / 2 . '" fill="#' . $hex_color . '"/>';
            break;
        default:
            $is_correct_figure = false;
            break;
    }
    $result = $result . '</svg>';

    if ($is_correct_figure) {
        echo $result;
    } else {
        echo 'Фигуры с номером: ' . $type_figure . ' не существует';
    }
}

function calcColor($color)
{
    $hex = dechex($color);
    return str_repeat("0", 6 - strlen($hex)) . $hex;
}
