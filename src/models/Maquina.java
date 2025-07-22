package models;

import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Maquina {

    public String nombre;
    public String ip;
    public List<Integer> codigos;
    public int subred;
    public int riesgo;

    public Maquina(String nombre, String ip, List<Integer> codigos) {
        this.nombre = nombre;
        this.ip = ip;
        this.codigos = codigos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public List<Integer> getCodigos() {
        return codigos;
    }

    public void setCodigos(List<Integer> codigos) {
        this.codigos = codigos;
    }

    public int getSubred() {
        return calcularSubred();
    }

    public void setSubred(int subred) {
        this.subred = subred;
    }

    public int getRiesgo() {
        return calcularRiesgo();
    }

    public void setRiesgo(int riesgo) {
        this.riesgo = riesgo;
    }

    private int calcularSubred(){
        
        
        String[] subr = this.ip.split("\\.");
            String sub = subr [2];
            subred = Integer.parseInt(sub);
        return subred;
    }

    private int calcularRiesgo(){
        //Character[] caracteres = new Character[this.nombre.length()];
        HashSet<Character> caracteres= new HashSet<>();
        int cont =0;
        int suma=0;

        for (int i=0; i<this.nombre.length();i++ ){
            if(caracteres.add(this.nombre.charAt(i)))
            cont++;
        }

        for (int i =0; this.codigos.get(i+1)==null ;i++){

            if (this.codigos.get(i)%5 == 0){
                suma+=this.codigos.get(i);
            }
        }
        return suma*cont;
    }


    
    
}
