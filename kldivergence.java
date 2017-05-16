class kldivergence{
    float kl(String arti,String[] val){
        float data1,data2,result=0;
        probability pb=new probability();
        data1=pb.pro(arti,val[0]);
        data2=pb.pro(arti,val[1]);
//        System.out.println("Data1: "+data1+" Data2: "+data2);
        if(data1!=0&&data2!=0)
            result=data1*(float)(Math.log(data1/data2)/Math.log(2));
        return result;
    }   
}
