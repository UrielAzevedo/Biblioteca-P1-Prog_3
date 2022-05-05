package com.example.exerciciomvcclube.DAO;

import com.example.exerciciomvcclube.Model.Socio;

import java.util.ArrayList;
import java.util.List;

public class SocioDAO {

    static List socios = new ArrayList<Socio>();

    public void adicionarSocio (Socio novoSocio) {
        socios.add(novoSocio);
    }

    public void removerSocio (Socio socioRemovido){
        socios.remove(socioRemovido);
    }

    public List listaSocios (){
        return socios;
    }
}
