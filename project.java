import java.io.File;
import java.io.*;
import java.util.Arrays;
class project{
         String[] article={"alt.atheism","comp.graphics","comp.os.ms-windows.misc","comp.sys.ibm.pc.hardware","comp.sys.mac.hardware","comp.windows.x","misc.forsale","comp.windows.x","rec.autos","rec.motorcycles","rec.sport.baseball","rec.sport.hockey","sci.crypt","sci.electronics","sci.med","sci.space","soc.religion.christian","talk.politics.guns","talk.politics.mideast","talk.religion.misc"};
              public static void main(String args[]){
                  kldivergence kd=new kldivergence();
                  entropy en=new entropy();
                  centropy ce=new centropy();
                  minfo mi=new minfo();
                  project pj=new project();
                  String[] name={};
                  int len=0;
                  String[] words= {" "};
                  float data=0;
                  try{
                      File input=new File("/home/aravilla/8360-Proj1/","input.txt");
                      LineNumberReader lr=new LineNumberReader(new FileReader(input));
                      String line="",arti="";
                      while((line=lr.readLine())!=null){ 
                          words=line.split(" ");
                          len=words.length;
                          System.out.println(len);
                          if(words[0]==null){
                              System.out.println("Please check the input.txt file");
                              return;
                          }
                          if(len==1){
                              System.out.println("Please check the input.txt file");
                              return;
                          }
                          name=Arrays.copyOfRange(words,2,len);
                          if(!words[1].endsWith(",")){
                              System.out.println("input.txt is missing a literal at article name\n");
                              return;
                          }
                          else{
                              len=words[1].length();
                              arti=words[1].substring(0,len-1);
                          }
                          if(words[0].equals("1,")){ 
                              if(!words[1].equals("all,")){
                                  if(Arrays.asList(pj.article).contains(arti)){
                                      data=en.entrop(arti,name);
                                      System.out.println("Entropy in Airticle "+arti+" "+data);
                                  }
                                  else
                                      System.out.println("Article not found\n");
                              }
                              else{      
                                  pj.all(name,1);
                              }
                          }
                          else if(words[0].equals("2,")){
                              if(!words[1].equals("all,")){
                                   if(Arrays.asList(pj.article).contains(arti)){
                                         data=ce.centro(arti,name);
                                         System.out.println("Conditional Entropy in Airticle "+arti+" "+data);
                                   }
                                   else
                                       System.out.println("Article not found");
                              }
                              else{
                                  pj.all(name,2);
                              }
                          }
                          else if(words[0].equals("3,")){
                              if(!words[1].equals("all,")){
                                   if(Arrays.asList(pj.article).contains(arti)){
                                        data=mi.minfor(arti,name);
                                        System.out.println("Mutual Information in Airticle "+arti+" "+data);
                                    }
                                   else
                                       System.out.println("Article not found");
                             }
                              else{
                                  pj.all(name,3);
                              }
                          }
                          else if(words[0].equals("4,")){
                              pj.all(name,4);
                          }
                          else{
                              System.out.println("Invalid Input. Check input.txt file\n");
                          }
                      }
                     if(len==0)
                         System.out.println("The file is empty");
                  }
                  catch(IOException e){
                      System.out.println(e);
                  }
              } 
              void all(String[] name,int command){
                  float data=0;
                  kldivergence kd=new kldivergence();
                  entropy en=new entropy();
                  centropy ce=new centropy();
                  minfo mi=new minfo();
                  switch(command){
                      case 1:  System.out.println("Entropy Values\n");
                               for(String x:article){        
                                  data=en.entrop(x,name);
                                  System.out.println("Entropy in Airticle "+x+" "+data);
                               }  
                               break;
                      case 2:  System.out.println("Conditional Probability Values\n");
                               for(String x:article){
                                   data=ce.centro(x,name);
                                   System.out.println("Condtional Entropy in Article "+x+" "+data);
                               }
                               break;
                      case 3:  System.out.println("Mutual Information Values\n");
                               for(String x:article){
                                   data=mi.minfor(x,name);
                                   System.out.println("Mutual Information in Airtcle "+x+" "+data);
                               }
                               break;
                      case 4: for(String x:article){
                                  data+=kd.kl(x,name);
                              }
                              System.out.println("KL Divergence is "+data);
                              break;
                  }
              }
}                               
