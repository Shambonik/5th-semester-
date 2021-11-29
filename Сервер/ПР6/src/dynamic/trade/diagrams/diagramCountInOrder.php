<?php
include '../login.php';
include './getFixtures.php';

require '../../../vendor/autoload.php';

use CpChart\Chart\Pie;
use CpChart\Data;
use CpChart\Image;

include './drawImage.php';

$points = [];
$labels = [];
$uniqueCount = [];

foreach ($fixtures->getObjects() as $fixture) {
	$count = floor($fixture->count_in_order/100);
	$index = array_search($count, $uniqueCount);

	if ($index !== false) {
		$points[$index]++;
	} else {
		array_push($points, 1);
		array_push($labels, $count*100 . " - " . ($count*100 + 100));
		array_push($uniqueCount, $count);
	}
}

$serie_abcissa = "serie_abcissa";
$serie_count = "serie_count";

// Create and populate data
$data = new Data();
$data->addPoints($points, $serie_count);

// Define the absissa serie
$data->addPoints($labels, $serie_abcissa);
$data->setAbscissa($serie_abcissa);

// Create the image
$image = new Image(400, 230, $data);

// Add a border to the picture
$image->drawRectangle(0, 0, 399, 229, ["R" => 0, "G" => 0, "B" => 0]);

// Write the picture title
$image->setFontProperties(["FontName" => "Silkscreen.ttf", "FontSize" => 14]);
$image->drawText(200, 13, "Count in order", ["R" => 0, "G" => 0, "B" => 0, "Align" => TEXT_ALIGN_TOPMIDDLE]);

// Set the default font properties
$image->setFontProperties(["FontName" => "Forgotte.ttf", "FontSize" => 10, "R" => 80, "G" => 80, "B" => 80]);

// Create and draw the chart
$pieChart = new Pie($image, $data);
$pieChart->draw2DPie(200, 125, ["DrawLabels" => true, "Border" => true]);

drawImage($image);
