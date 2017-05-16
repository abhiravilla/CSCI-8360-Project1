import java.io.*;
import java.io.File;
import java.math.*;
class probability{
    float pro(String arti,String var){
        float pro=0;
        try{
            File dataset=new File("/home/aravilla/8360-Proj1/","Data.txt");
            String line="";
            String[] words;
            int occurance=0,numberoflines=0;
                LineNumberReader lr=new LineNumberReader(new FileReader(dataset));                
                while((line=lr.readLine())!=null){
                    words=line.split(" ");
                    //System.out.println(words[0]+"\n");
                    if(words[0].startsWith(arti+" ",0)){
                       // System.out.println(words[0]+"\n");
                        numberoflines++;
                        if(words[0].endsWith(" "+var)){
                            occurance++;
                            continue;
                         }
                        else{
                            for(String x:words){
                                if(x.equals(var)){
                                        occurance++;
                                        break; 
                                }   
                             }
                        }
                    }
                }
                    pro=occurance/(float)numberoflines;
                    //System.out.println("Word: "+var+" Occurence: "+occurance+" Number of lines: "+numberoflines+" Probability: "+pro);
        }
            catch(IOException e){
                System.out.println(e);
            }
            return pro;
        }
}
