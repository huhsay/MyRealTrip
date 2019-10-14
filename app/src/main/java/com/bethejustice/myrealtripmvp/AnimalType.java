package com.bethejustice.myrealtripmvp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public enum AnimalType {

    DOG("강아지", "멍멍"), CAT("고양이", "야옹"), PARROT("앵무새","짹짹"), LIZARD("도마뱀", null);

    @NonNull
    private String type;
    @Nullable
    private String sound;

    AnimalType(@NonNull String type, @Nullable String sound) {
        this.type = type;
        this.sound = sound;
    }

    @Nullable
    public static AnimalType fromString(@NonNull String type) {
        switch (type) {
            case "강아지":
                return DOG;
            case "고양이":
                return CAT;
            case "앵무새":
                return PARROT;
            case "도마뱀":
                return LIZARD;
            default:
                return null;
        }
    }

    @NonNull
    public String getTypeString() {
        return type;
    }

    @Nullable
    public String getSound() {
        return sound;
    }

}
