<?php
include '../login.php';
include './getFixtures.php';

require '../../../vendor/autoload.php';

use CpChart\Data;
use CpChart\Image;

include './drawImage.php';

$data = new Data();

$serie_dark = "dark";
$serie_milk = "milk";
$serie_days = "days";

$day = 0;

foreach ($fixtures->getObjects() as $fixture) {
    $data->addPoints($fixture->dark_chocolate_profit, $serie_dark); 
    $data->addPoints($fixture->milk_chocolate_profit, $serie_milk);
    $data->addPoints($day, $serie_days);

    $day++;
}

$data->setAbscissa($serie_days);
$data->setAbscissaName("Days");

//SERIE_SHAPE_FILLEDTRIANGLE - triangle
//SERIE_SHAPE_FILLEDSQUARE - square
$data->setSerieShape($serie_milk, SERIE_SHAPE_FILLEDTRIANGLE);
$data->setSerieShape($serie_dark, SERIE_SHAPE_FILLEDSQUARE);

$data->setSerieOnAxis($serie_milk, 0);
$data->setSerieOnAxis($serie_dark, 1);

$data->setAxisName(0, "Milk Profit");
$data->setAxisName(1, "Dark Profit");

$data->setAxisPosition(1, AXIS_POSITION_RIGHT);

/* Create the Image object */
$image = new Image(900, 300, $data);

/* Turn off Antialiasing */
$image->Antialias = false;

/* Add a border to the picture */
$image->drawRectangle(0, 0, 899, 299, ["R" => 0, "G" => 0, "B" => 0]);

/* Write the chart title */
$image->setFontProperties(["FontName" => "Forgotte.ttf", "FontSize" => 11]);
$image->drawText(200, 35, "Milk and dark chocolate profit", ["FontSize" => 20, "Align" => TEXT_ALIGN_BOTTOMMIDDLE]);

/* Set the default font */
$image->setFontProperties(["FontName" => "pf_arma_five.ttf", "FontSize" => 6]);

/* Define the chart area */
$image->setGraphArea(60, 40, 850, 250);

/* Draw the scale */
$scaleSettings = [
    "XMargin" => 10,
    "YMargin" => 10,
    "Floating" => true,
    "GridR" => 200,
    "GridG" => 200,
    "GridB" => 200,
    "DrawSubTicks" => true,
    "CycleBackground" => true
];
$image->drawScale($scaleSettings);

/* Turn on Antialiasing */
$image->Antialias = true;
$image->setShadow(true, ["X" => 1, "Y" => 1, "R" => 0, "G" => 0, "B" => 0, "Alpha" => 10]);

/* Draw the line chart */
$image->drawPlotChart();
$image->drawLineChart();

/* Write the chart legend */
$image->drawLegend(680, 20, ["Style" => LEGEND_NOBORDER, "Mode" => LEGEND_HORIZONTAL]);

drawImage($image);
