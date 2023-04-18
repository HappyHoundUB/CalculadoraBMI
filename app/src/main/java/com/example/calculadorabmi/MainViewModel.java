package com.example.calculadorabmi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String> bmi;

    public MainViewModel() {
        bmi = new MutableLiveData<String>();
    }

    public LiveData<String> getBMI(){
        return bmi;
    }

    public void calcularBMI(String pesStr, String alcadaStr){
        float pes = Float.valueOf(pesStr);
        float alcada = Float.valueOf(alcadaStr);
        float bmi = CalculadoraBMI_UseCase.calcularBMI(pes, alcada);

        this.bmi.setValue(String.valueOf(bmi)); //fes dispoible el valor
    }
}
