package extend;

import org.junit.Test;

public class Manacher {
    @Test
    public void test(){
        String s = "ababb";
        manacher(s);
    }
    public void manacher (String str){

        char [] cStr = str.toCharArray();
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("#");
        for (int i = 0; i < cStr.length; i++) {
            sBuffer.append(cStr[i]);
            sBuffer.append("#");
        }
        int id =0;
        int max = 0;
        int p[]= new int[sBuffer.length()];
        for (int i = 1; i < sBuffer.length(); i++) {

            if (i<max) {
                p[i] = Math.min(p[2*id-i], max-i);
            }else {
                p[i]= 1;
            }
            while (i-p[i]>=0&&i+p[i]<sBuffer.length()&&sBuffer.charAt(i-p[i])==sBuffer.charAt(i+p[i])) {
                p[i]++;
            }
            if (i+p[i]>max) {
                max = i+p[i];
                id = i;
            }
        }
        int maxl = 0 ;
        int maxid =0 ;
        for(int i =0 ;i<p.length;i++){
            if(maxl<p[i]){
                maxl=p[i];
                maxid = i;
            }

        }
        //半径包括id本身。id到第一个元素，id-r+1
        int r = maxl-1;
        int start = maxid-r+1;
        int end = maxid+maxl-1;
        StringBuffer out = new StringBuffer();
        for (int i = start; i < end; i++) {
            if (sBuffer.charAt(i)!='#') {
                out.append(sBuffer.charAt(i));
            }
        }
        System.out.println("最大回文子串长度："+ (maxl-1)+"\n内容为："+out.toString());
    }

}
