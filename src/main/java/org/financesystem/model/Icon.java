package org.financesystem.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.financesystem.Main;

import java.util.Objects;

public enum Icon {
    ADD, AIRPLANE, APPAREL, ARROW, ARROW_CIRCLE_DOWN, ARROW_CIRCLE_UP, BABY, BANK, BEACH, BED, BIKE, BITCOIN, BOOK,
    CAKE, CALCULATE, CAMERA, CAR, CASH, CHAT, CHURCH, CLOSE, CLOUD, COFFEE, CREDIT_CARD, CRIB, DENTIST, DESKTOP,
    DIRECTIONS_BUS, DOCTOR, ECG_HEART, EXPAND_MORE, FAMILY, FINANCE, FLAG, FOREST, GAMES, GAS_STATION, GYM, HANDBAG,
    HEART, HOUSE, KEY, LIGHTBULB, LIGHTING, LIST_ALT, MAIL, MEDICAL, MENU, MENU_BOOK, MIC, MONITORING, MORE_HORIZ,
    MOVIE, MUSIC, NOTE, PAID, PAINT, PARK, PENCIL, PET, PHONE, PRESENT, PRINTER, PROFILE, REFRIGERATOR, RUN, SCHOOL,
    SHOPPING_BASKET, SHOPPING_CART, SMILE, SOCCER, TEXT, THUMB_UP, TRENDING_DOWN, TRENDING_UP, TRIPS, VERIFIED,
    VISIBILITY, WORK, WORLD;

    public static ImageView create(Icon icon) {
        String url = Objects.requireNonNull(Main.class.getClassLoader()
                .getResource("icons/" + icon.name().toLowerCase() + ".png")).toExternalForm();

        Image image = new Image(url);
        return new ImageView(image);
    }
}
