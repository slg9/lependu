/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lependu;

import com.lependu.utilities.Bonhomme;
import java.util.Scanner;

/**
 *
 * @author eleve
 */
public class LePendu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //System.out.println("Entrez le mot à trouver (sans minuscule) : ");
        //Scanner scan = new Scanner(System.in);
        
        //scan.close();
        int compteur=0;
        
        System.out.println("Entrez le mot à deviner! (en minuscule) : ");
        String reponse=in.nextLine();
        char[] Affiche =initCharTable(reponse); 
        String Message ="";
        System.out.println(Message);
        Bonhomme b = new Bonhomme();
        
        while(true){
            
            drawSeparator(Affiche);
            afficherReponse(Affiche);
            DrawBonhomme(b,compteur);
            if(checkWin(Affiche, reponse) || compteur == b.getTaille()){
                if(compteur==b.getTaille()){
                    System.out.println("GAME OVER!!");
                }else{
                    System.out.println("BRAVO! Vous avez gagné!!!");
                }
                break;
                
            }else{
                
                System.out.printf("\n%s --> A votre tour !(il vous reste %d essais) : \n",Message,(b.getTaille()-compteur));
                
                char lettre = checkLetter(in, reponse);
                //System.out.println(in.nextLine());
                
                if(lettre!=0){
                    if(lettre==1){
                        compteur++;
                    Message="OUPS!!";
                    }else{
                        Affiche=createReponse(reponse, lettre, Affiche);
                        Message="BRAVO!!";
                    }
                }else{
                    Message="Vous devez entrer une lettre en minuscule!";
                }
                
            }
            
            
            
       

        }
        //System.out.println(reponse);


    }

    public static void drawSeparator(char[] chaine){
        String sep ="";
        for(int i=0;i<100;i++){
            sep+="\n";
        }
        System.out.println(sep);
    }
    public static char[] initCharTable(String mot){
        char[] chaine = new char[mot.length()];
        int i=0;
        for(char c : chaine){
            chaine[i]='_';
            i++;
        }
        return chaine;
    }
    public static char checkLetter(Scanner in,String reponse){
        

        char retour=0;
        String entre = in.nextLine();
        
        if(entre.length()==1){
            int l = entre.charAt(0);
            if(l>96 && l<123){
                if(reponse.contains(entre)){
                    retour=entre.charAt(0);
                }else{
                    retour=1;
                }
                
                
            }else{
                System.out.println("Veuillez entrez une lettre en minuscule!");
                
            }
        }else{
            System.out.println("Veuillez entrez un seul charactere!");
            
        }
        return retour;
        
    }
    
    public static char[] createReponse(String reponse,char lettre,char[] Affiche){
        for(int i=0;i<reponse.length();i++){
            if(reponse.charAt(i)==lettre){
                Affiche[i]=lettre;                
            }
            if(Affiche[i]==' '){
                Affiche[i]='_';
            }
        }
        return Affiche;
        
    }
    
    public static void afficherReponse(char[] chaine){
        String result="";
        for(char c : chaine){
            
             result+=c;
             result+=" ";
        }
        System.out.println(result);
        
    
    }
    
    public static boolean checkWin(char[]reponse, String solution){
        boolean retour=false;
        String result="";
        for(char c : reponse){
            result+=c;
        }
        if(result.equals(solution)){
            
            retour=true;
        }
        return retour;
        
    }
    
    public static void DrawBonhomme(Bonhomme b,int compteur){
        
        b.afficheBonhomme(compteur);
    
        
    }
    
 
    
}
