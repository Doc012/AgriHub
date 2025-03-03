package com.backend.AgriLearn.enums;

public enum ProvinceEnum {
    EASTERN_CAPE, FREE_STATE, GAUTENG, KWAZULU_NATAL, LIMPOPO,
    MPUMALANGA, NORTH_WEST, NORTHERN_CAPE, WESTERN_CAPE;


    // Format method to transform "EASTERN_CAPE" → "Eastern Cape"
    public String getFormattedName() {
        String formatted = this.name().toLowerCase().replace("_", " "); // Convert "EASTERN_CAPE" → "eastern cape"

        // Capitalize first letter of each word
        String[] words = formatted.split(" ");
        StringBuilder capitalized = new StringBuilder();

        for (String word : words) {
            capitalized.append(Character.toUpperCase(word.charAt(0))) // Uppercase first letter
                    .append(word.substring(1)) // Keep the rest lowercase
                    .append(" "); // Add space
        }

        return capitalized.toString().trim(); // Remove trailing space
    }

}

