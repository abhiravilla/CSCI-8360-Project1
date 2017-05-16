import java.io.*;
import java.io.File;
import java.math.*;
class cprobability{
    float pro(String arti,String var, String var2){
        float pro=0;
        try{
            File dataset=new File("/home/aravilla/8360-Proj1/","Data.txt");
            String line="";
            String[] words;
            int occurance1=0,occurance=0,occurance2=0,numberoflines=0,i=0;
            LineNumberReader lr=new LineNumberReader(new FileReader(dataset));                
            while((line=lr.readLine())!=null){
                words=line.split(" ");
                if(words[0].startsWith(arti,0)){
                    numberoflines++;
                    if(words[0].endsWith(" "+var))
                        occurance1=1;
                    if(words[0].endsWith(" "+var2))
                        occurance2=1;           
                    for(String x:words){
                        if(x.equals(var))
                            occurance1=1;  
                        if(x.equals(var2))
                            occurance2=1; 
                        if(occurance1==1&&occurance2==1){
                            occurance++;
                            i++;
                            break;
                        }  
                    }
                occurance1=occurance2=0;    
                }
            }
            pro=occurance/(float)numberoflines;
            //System.out.println("Word: "+var+" Word: "+var2+" Occurence: "+occurance+" Number of lines: "+numberoflines+" Probability: "+pro);
        }
        catch(IOException e){
            System.out.println(e);
        }
        return pro;
    }
}
