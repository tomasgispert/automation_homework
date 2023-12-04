package com.solvd.enums;

public enum RPE {
    RPE_SUB_6("Warmup",5,"Warmup weight"),
    RPE_6("Very Light",6,"You could do 4 more reps"),
    RPE_6_5("Light",6.5,"You could do 3-4 more reps"),
    RPE_7("Moderate-Light",7,"You could do 3 more reps"),
    RPE_7_5("Moderate",7.5,"You could do 2-3 more reps"),
    RPE_8("Moderate-Hard",8,"You could do 2 more reps"),
    RPE_8_5("Hard",8.5,"You could do 1-2 more reps"),
    RPE_9("Very Hard",9,"You could do 1 more rep"),
    RPE_9_5("Extremely Hard",9.5,"You could do 0-1 more reps"),
    RPE_10("Maximal Effort",10,"No reps left in the tank");

    private final String category;
    private final double value;
    private final String description;

    RPE(String category, double value, String description) {
        this.category = category;
        this.value = value;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public double getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public RPE getNextRPE(){
        int nextOrdinal = this.ordinal()+1;
        if(nextOrdinal < RPE.values().length){
            return RPE.values()[nextOrdinal];
        }else{
            return null;
        }
    }

    public RPE getPreviousRPE(){
        int prevOrdinal = this.ordinal()-1;
        if(prevOrdinal >= 0){
            return RPE.values()[prevOrdinal];
        }else{
            return null;
        }
    }
}
