<?php
include '../login.php';

require '../../../vendor/autoload.php';
use Nelmio\Alice\Loader\NativeLoader;

// данные для ящичка интернет-вещей
class Dump {
    public $dark_chocolate_profit;
    public $milk_chocolate_profit;
    public $milk_rating_from_users;
    public $dark_rating_from_users;
    public $count_in_order;
}


$loader = new Nelmio\Alice\Loader\NativeLoader();
$fixtures = $loader->loadFile('./fixtures.yml');

?>