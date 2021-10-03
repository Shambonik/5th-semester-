<?php
function printResult($output, $command) {
    echo "Команда " . $command . "<br>";
    foreach ($output as $line_output) {
        echo $line_output . "<br>";
    }
}
?>
