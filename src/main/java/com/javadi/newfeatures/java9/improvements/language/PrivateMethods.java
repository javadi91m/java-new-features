package com.javadi.newfeatures.java9.improvements.language;

public interface PrivateMethods {

    double getPrice();

    default double getPriceWithTax() {
        return getTaxedPriceInternal();
    }

    default double getOfferPrice(double discount) {
        return getTaxedPriceInternal() * discount;
    }

    private double getTaxedPriceInternal() {
        return getPrice() * getTax();
    }

    // private fields are not allowed, so we use a private method
    private static double getTax() {
        return 1.21;
    }

    /* Before private interface methods, shared logic could not be extracted into a
       new method (at least not without it becoming part of the public API).

    default double getPriceWithTax() {
        return getPrice() * 1.21;
    }

    default double getOfferPrice(double discount) {
        return getPrice() * 1.21 * discount;
    }
    */

}
