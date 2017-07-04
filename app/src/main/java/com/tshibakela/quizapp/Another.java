package com.tshibakela.quizapp;

/**
 * Created by Tshibakela on 2017/07/03.
 */

public class Another {

    public String Problem []={

            "The process of ---------- involves the introduction of a gene into a cell where it exchanges \n places with its counterpart in the host cell’",
            "The first drug produced using recombinant DNA technology is used to treat",
            "Genetic engineering manipulates gene products at the level of the",
            "Gene targeting is done on a(n)",
            "The first drug produced using recombinant DNA technology was",
            "tA DNA library is",

    };

    public String PickSolo [][]={

            {"a.\t Transgenic technology", "b.\t Gene targeting ","c.\t Knockout technology","d.\t Recombinant DNA technology"},
            {"a.\t Hemophilia ", "b.\t Dwarfism ","c.\t Heart attack ","d.\t Diabetes "},
            {"a.\t protein ", "b.\t amino acid  ","c.\t DNA  ","d.\t Enzyme "},
            {"a.\t Sperm cell  ", "b.\t Egg cell  ","c.\t Fertilized ovum  ","d.\t Early embryonic cell "},
            {"a.\t Insulin  ", "b.\t Penicillin ","c.\t tPA  ","d.\t Streptokinase"},
            {"a.\t A general collection of all genes sequenced thus far", "b.\t All DNA fragments identified with a probe ","c.\t A DNA fragment inserted into a vector","d.\t A collection of DNA fragments that make up the entire genome of a particular organism"},

    };


    public String FinalSolo []={
            "b.\t Gene targeting",
            "d.\t Diabetes ",
            "c.\t DNA  ",
            "c.\t Fertilized ovum  ",
            "a.\t Insulin  ",
            "d.\t A collection of DNA fragments that make up the entire genome of a particular organism",
    };

    public String[] getFinalSolo() {
        return FinalSolo;
    }

    //              using getter and setters
//                         &**&** FOR PROBLEM ***&*&

    public String getProblem(int a) {
        String question=Problem[a];
        return question;
    }
//                          END FOR PROBLEM




//                          FOR PICKSOLO (possible solutions)

    public String getPickSolo1(int a) {
        String mySolo=PickSolo[a][0];
        return mySolo;

    }

    public String getPickSolo2(int a) {
        String mySolo=PickSolo[a][1];
        return mySolo;
    }


    public String getPickSolo3(int a) {
        String mySolo=PickSolo[a][2];
        return mySolo;
    }

    public String getPickSolo4(int a) {
        String mySolo=PickSolo[a][3];
        return mySolo;
    }

    public String getFinal(int a) {
        String answer=FinalSolo[a];
        return answer;
    }

}
