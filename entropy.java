import java.math.*;
class entropy{
    float entrop(String arti,String[] var){
        float entro=0,prob=0;
        probability pb=new probability();
        for(String x:var){
            prob=pb.pro(arti,x);
            if(prob!=0)
                entro+=-1*(prob*(Math.log(prob)/(Math.log(2))));
        }       
        return entro;
    }
}
