/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lependu.utilities;

/**
 *
 * @author eleve
 */
public class Bonhomme {
    private String[][]corps={{" ","_"," "},{"/"," ","\\"},{"*",".","*"},{"\\","_","/"},{" ","|"," "},{"/"," ","\\"},{" ","|"," "},{"/"," ","\\"}};
    private String[][]corpsDead={{" ","|"," "},{" ","_"," "},{"/"," ","\\"},{"-",".","-"},{"\\","_","/"},{"|"," ","|"},{" ","|"," "},{"|"," ","|"}};
   
 
    public void afficheBonhomme(int compteur){
       if(compteur==corps.length){
           afficheDead(corpsDead);
       }else{
            for(int i=0;i<compteur;i++){
               affiche(corps[i]);
           }
       }

    }
    
    public int getTaille(){
        return corps.length;
    }
 
    private void affiche(String[] membre){
        String af="";
        for(String col : membre){
            af+=col;
        }
        System.out.println(af);
    }
    private void afficheDead(String[][] corps){
        String af="";
        for(String[] row : corps){
            for(String col : row){
                af+=col;
            }
            af+="\n";
        }
        
        System.out.println(af);
    }
    
}
