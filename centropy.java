class centropy{
    float centro(String arti,String[] var){
        float data=0,x,y,z;
        int i=var.length;
        cprobability ce=new cprobability();
        probability pb=new probability();
        for(int j=1;j<i;j++){
            x=pb.pro(arti,var[0]);
            y=ce.pro(arti,var[0],var[j]);
            if((y!=0)&&(x!=0)){
                z=y/x;
                data+=(y*(Math.log(z)/Math.log(2)));
            }
        }
        return data;
    }
}
