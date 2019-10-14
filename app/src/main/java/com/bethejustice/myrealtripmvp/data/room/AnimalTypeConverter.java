package com.bethejustice.myrealtripmvp.data.room;

import androidx.room.TypeConverter;

import com.bethejustice.myrealtripmvp.AnimalType;

class AnimalTypeConverter {

    @TypeConverter
    static AnimalType stringToAnimalType(String type) {
        return AnimalType.fromString(type);
    }

    @TypeConverter
    static String typeToString(AnimalType animalType) {
        return animalType.getTypeString();
    }
}
