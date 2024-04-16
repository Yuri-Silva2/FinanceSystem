package org.fsystem.financesystem.model;

public enum Color {

    BERRY_RED("#B8255F"), RED("#DB4035"),
    ORANGE("#FF9933"), YELLOW("#FAD000"),
    OLIVE_GREEN("#AFB83B"), LIME_GREEN("#7ECC49"),
    GREEN("#299438"), MINT_GREEN("#6ACCBC"),
    TEAL("#158FAD"), SKYE_BLUE("#14AAF5"),
    LIGHT_BLUE("#96C3EB"), BLUE("#4073FF"),
    GRAPE("#884DFF"), VIOLET("#AF38EB"),
    LAVENDER("#EB96EB"), MAGENTA("#E05194"),
    SALMON("#FF8D85"), CHARCOAL("#808080"),
    GREY("#B8B8B8"), TAUPE("#CCAC93"),
    GREEN_YELLOW("#ADFF2F"), KHAKI("#F0E68C"),
    ORANGE_RED("#FF4500"), BLACK("#000000"),
    DARK_RED("#8B0000"), SNOW("#FFFAFA"),
    DIM_GRAY("#696969"), DARk_GREEN("#006400"),
    GOLD("#FFD700"), DARK_CYAN("#008B8B"),
    MIDNIGHT_BLUE("#191970"), DARK_GRAY("#242424");

    private final String hexCode;

    Color(String hexCode) {
        this.hexCode = hexCode;
    }

    public String getHexCode() {
        return hexCode;
    }
}
