package io.github.Lossttt.athenavox;

public class Voter {


    public Voter() {
    }

    public Voter(String string, String string2, boolean b, boolean c) {
    }

    public boolean eligibleToVote(int age, boolean isNative, boolean hasNationality)
    {
       if ((age >= 18) && (isNative || hasNationality))
       {
           return true;
       }
       return false;
    }

    public boolean magStemmen(int leeftijd, boolean isNederlands, boolean heeftStemkaart, boolean isGeregistreerd){
        boolean magStemmen;

        int voorwaarden = 0;

        if (leeftijd >= 18 && leeftijd < 95){
            voorwaarden++;
        }
        if (isNederlands){
            voorwaarden++;
        }
        if (heeftStemkaart){
            voorwaarden++;
        }
        if (isGeregistreerd){
            voorwaarden++;
        }
        magStemmen = voorwaarden >= 3;

        return magStemmen;
    }

    public boolean geslaagdVerkiezingen(int aantalFout, int ongeldigeStemmen, int stemFraude, boolean correctGeteld) {
        boolean geslaagd;
        int fouten = aantalFout + ongeldigeStemmen + stemFraude;

        if (!correctGeteld) {
            fouten += 1;
        }

        if (fouten <= 5 && correctGeteld) {
            geslaagd = true;
        } else {
            geslaagd = false;
        }

        return geslaagd;
    }

    public String getAgeGroup(int age) {
        if (age >= 18 && age <= 40) {
            return "Adult";
        } else if (age > 40 && age <= 65) {
            return "Middle-aged";
        } else if (age > 65) {
            return "Elderly";
        }
        return null;
    }
}
