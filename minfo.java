class minfo{
    float minfor(String arti,String[] value){
        entropy en=new entropy();
        centropy ce=new centropy();
        float v1,v2;
        String[] temp={value[0]};
        v1=en.entrop(arti,temp);
        v2=ce.centro(arti,value);
       // System.out.println(v1+"\n");
       // System.out.println(v2+"\n");
        v1-=v2;
        return v1;
    }
}
