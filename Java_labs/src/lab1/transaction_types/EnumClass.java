package lab1.transaction_types;

//Enum class is a set of values that do not change
//Enums
//        An enum is a special "class" that represents a group of constants
//        (unchangeable variables, like final variables).

//       To create an enum, use the enum keyword (instead of class or interface),
//       and separate the constants with a comma.
//       Note that they should be in uppercase letters:
//Enum = enumerated (ordered listings of items in a collection)
//groupings of constants that behave similarly to objects


public enum EnumClass {
    MONEY_TRANSFER ("Money Transfer"),
    BILLS_PAYMENT ("Bills Payment"),
    BUY_LOAD ("Buy Load"),
    ADD_ACCOUNT_CREDITS ("Add Account Credits"),
    ADD_GAME_CREDITS ("Add Game Credits"),
    CREDITS ("Credits");

    final String title;

    EnumClass(String title){

        this.title = title;
    }
}
