package com.bethejustice.myrealtripmvp.data.room;

import androidx.room.TypeConverter;

import com.bethejustice.myrealtripmvp.AnimalType;

class AnimalTypeConverter {

    @TypeConverter
    public static AnimalType stringToAnimalType(String type) {
        return AnimalType.fromString(type);
    }

    @TypeConverter
    public static String typeToString(AnimalType animalType) {
        return animalType.getTypeString();
    }
}
