package com.tech4me.primeirorest.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilData {
    
    public static String converterDateParaData(Date data){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(data);
    }

    public static String converterDateParaHora(Date data){
        SimpleDateFormat formatador = new SimpleDateFormat("hh:mm:ss");
        return formatador.format(data);
    }

    public static String converterDateParaDataEHora(Date data){
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return formatador.format(data);
    }
}