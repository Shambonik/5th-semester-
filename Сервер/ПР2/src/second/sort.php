<?php
function shellSort($array)
{   
    $n = count($array);
    for ($step = $n / 2; $step > 0; $step /= 2){
        for ($i = $step; $i < $n; $i++) {
            for ($j = $i - $step; $j >= 0 && $array[$j] > $array[$j + $step]; $j -= $step) {
                $t = $array[$j];
                $array[$j] = $array[$j+$step];
                $array[$j+$step] = $t;
            }
        }
    }

    return $array;

}
