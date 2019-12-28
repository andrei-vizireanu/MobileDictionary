package com.example.andrei.dictionar;

/**
 * Created by Andrei on 11/15/2017.
 */

public class AdapterItems {

    public int ID;
    public String Cuvant;
    public String Traducere;
    //for news details
    public AdapterItems(int ID,String Cuvant,String Traducere)
    {
        this.Cuvant = Cuvant;
        this.Traducere = Traducere;
        this.ID = ID;
    }
    public AdapterItems(){

    }

}
