package com.util;//用来生成组织机构代码

/**
 * @author dongxiaohong
 * */

public class CreateSoc {


    public static void main(String[] args) {
        String str="0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F,G,H,J,K,L,M,N,P,Q,R,T,U,W,X,Y";
        String[] doc = str.split(",");
        String random1 = "";
        String random2 = "";
        String random3 = "130000"; //具体可参考GB/T2260 可选择赋值
        String random4 = gra(); //调用组织机构代码生成函数
        String wss="1,3,9,27,19,26,16,17,20,29,25,13,8,24,10,30,28";
        String[] ws=wss.split(",");
        int index = (int) (Math.random() * doc.length);
        random1 = doc[index];
        if("1".equals(random1)||"5".equals(random1)||"9".equals(random1)){
            String[] doc2 ={"1","2","3","9"};
            index = (int) (Math.random() * doc2.length);
            random2 = doc2[index];

        }else{
            random2 = "1";
        }
        String codes=random1+random2+random3+random4;
        int sum=0;
        for(int i=0;i<17;i++){
            sum+=str.indexOf(codes.charAt(i))*Integer.parseInt(ws[i]);

        }
        int mod=31-((sum/2)%31);
        if(mod==31){
            mod=0;
        }
        if(mod>9){
            CreateSoc s=new CreateSoc();
            main(args);
        }
        codes=codes+""+mod+"";
        if(mod<10){
            System.out.println(codes);

        }

    }
    //自动生成组织机构代码
    static String gra(){
        String str="3,7,9,10,5,8,4,2";
        String[] ww = str.split(",");
        String[] ww2=new String[8];
        String c9="";
        String org="";

        int dd=0;
        int cc;
        int d9=0;
        for(int i=0;i<8;i++){
            cc= (int) (Math.random()*10) ;

            dd=dd+cc*Integer.parseInt(ww[i]);
            ww2[i]=String.valueOf(cc);
        }
        d9=11-dd%11;
        if(d9==10){
            c9="X";
        }else{
            c9=String.valueOf(d9);
        }
        for(int j=0;j<8;j++){
            org+=ww2[j];
        }
        org+=c9;

        return org;
    }

}
