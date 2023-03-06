
package com.brahm.retrofit;


import com.google.gson.annotations.SerializedName;

public class Meal {

    @SerializedName("idIngredient")
    private String mIdIngredient;
    @SerializedName("strDescription")
    private String mStrDescription;
    @SerializedName("strIngredient")
    private String mStrIngredient;

    public Meal(String mIdIngredient, String mStrDescription, String mStrIngredient) {
        this.mIdIngredient = mIdIngredient;
        this.mStrDescription = mStrDescription;
        this.mStrIngredient = mStrIngredient;

    }

    public String getIdIngredient() {
        return mIdIngredient;
    }

    public void setIdIngredient(String idIngredient) {
        mIdIngredient = idIngredient;
    }

    public String getStrDescription() {
        return mStrDescription;
    }

    public void setStrDescription(String strDescription) {
        mStrDescription = strDescription;
    }

    public String getStrIngredient() {
        return mStrIngredient;
    }

    public void setStrIngredient(String strIngredient) {
        mStrIngredient = strIngredient;
    }


}
