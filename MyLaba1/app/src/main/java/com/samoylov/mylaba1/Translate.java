package com.samoylov.mylaba1;

public class Translate {
    private int pos;
    private String i1[]={"","один","два","три","четыри","пять","шесть","семь","восемь","девять"};
    private String i19[]={"десять","одинадцать","двенадцать","тринадцать","четырнадцать","пятнадцать","шестнадцать","семнадцать","восемнадцать","девятнадцать"};
    private String i10[]={"дцать","десят","сто","сот"," тысячи","тысяч","","","",""};
    private String i100[]={"две","двести","одна тысяча","сорок","","","","","миллион"};
    private String string="";



    public Translate(int pos){

        this.pos=pos;
    }

    void padld(String string,int pos){
        this.string=string;
        this.pos=pos;
        string=i1[pos]+i10[pos]+i1[pos]+i10[pos]+i1[pos]+"k";
        if (pos<9){
            string=i1[pos];
        }else if(pos<19) {
            string=i19[pos-9]+" "+pos;
        }else  if(pos<99){
            if((pos+1/10+1)==4){}

            string=i1[((pos+1)/10)-1]+i10[0];
            if((pos+1)%10>0){
                string=string+" "+i1[(pos+1)%10-1]+""+pos;
            }
        }else if(pos<50){

        }
//        if(pos)
        this.string=string;
    }

    public String getTranslate(){
        padld(string,pos);
        return string;
    }
}
