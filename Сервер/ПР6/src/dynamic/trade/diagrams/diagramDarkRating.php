<?php
include '../login.php';
include './getFixtures.php';
include './drawRatingDiagram.php';

$points = [0, 0, 0, 0, 0]; // 0 - <=$norm; 1 - >$norm

foreach ($fixtures->getObjects() as $fixture) {
    $points[$fixture->dark_rating_from_users - 1]++;
}

drawRatingDiagram($points, "Dark", "Dark rating", 0, max($points) + 1);
