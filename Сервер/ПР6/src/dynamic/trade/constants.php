<?php
    class LANGUAGE {
        public static $RU = "ru";
        public static $EN = "en";
    }

    class THEME {
        public static $LIGHT = "light";
        public static $DARK = "dark";
    }

    abstract class ABS_DICTIONARY {
        public $ADMIN_PANEL;

        public $SETTING;
        public $THEME;
        public $LIGHT;
        public $DARK;
        public $LANGUAGE;
        public $NAME;
        public $UPDATE;

        public $ADMINISTRATORS;
        public $LOGIN;
        public $PASSWORD;

        public $SEND;

        public $ORDERS;
        public $ORDER_TITLE;
        public $ORDER_COUNT;
        public $ORDER_ADDRESS;
        public $ORDER_CANCELED;
        public $ORDER_PROCESSING;
        public $CANCEL_ORDER;
        
        public $NAMELESS;

        public $SEND_THIS_FILE;
        public $UPLOAD_FILE;
        public $SEND_FILE;
        public $UPLOADING_FILES;
        public $DOWNLOAD_FILE;
    }

    class RUS_DICTIONARY extends ABS_DICTIONARY {
        public $ADMIN_PANEL = "Панель администратора";

        public $SETTING = "Настройки";
        public $THEME = "Тема";
        public $LIGHT = "Светлая";
        public $DARK = "Тёмная";
        public $LANGUAGE = "Язык";
        public $NAME = "Имя";
        public $UPDATE = "Изменить";

        public $ADMINISTRATORS = "Администраторы";
        public $LOGIN = "Логин";
        public $PASSWORD = "Пароль";

        public $SEND = "Отправить";

        public $ORDERS = "Заказы";
        public $ORDER_TITLE = "Название";
        public $ORDER_COUNT = "Количество";
        public $ORDER_ADDRESS = "Адрес";
        public $ORDER_CANCELED = "Отменен";
        public $ORDER_PROCESSING = "В обработке";
        public $CANCEL_ORDER = "Отменить ↓";

        public $NAMELESS = "Безымянный";

        public $SEND_THIS_FILE = "Отправить этот файл";
        public $UPLOAD_FILE = "Загрузить файл";
        public $SEND_FILE = "Отправить файл";
        public $UPLOADING_FILES = "Загруженные файлы";
        public $DOWNLOAD_FILE = "Скачать";
    }

    class ENG_DICTIONARY extends ABS_DICTIONARY {
        public $ADMIN_PANEL = "ADMIN PANEL";

        public $SETTING = "Setting";
        public $THEME = "Theme";
        public $LIGHT = "Light";
        public $DARK = "Dark";
        public $LANGUAGE = "Language";
        public $NAME = "Name";
        public $UPDATE = "Update";

        public $ADMINISTRATORS = "Administrators";
        public $LOGIN = "Login";
        public $PASSWORD = "Password";

        public $SEND = "Send";

        public $ORDERS = "Orders";
        public $ORDER_TITLE = "Title";
        public $ORDER_COUNT = "Count";
        public $ORDER_ADDRESS = "Address";
        public $ORDER_CANCELED = "Canceled";
        public $ORDER_PROCESSING = "Processing";
        public $CANCEL_ORDER = "Cancel ↓";
        
        public $NAMELESS = "Nameless";
        public $SEND_THIS_FILE = "Send this file";
        public $UPLOAD_FILE = "Upload file";
        public $SEND_FILE = "Send file";
        public $UPLOADING_FILES = "Uploaded files";
        public $DOWNLOAD_FILE = "Download";
    }

    $DICTIONARY = [
        "ru" => new RUS_DICTIONARY,
        "en" => new ENG_DICTIONARY,
    ];
?>
