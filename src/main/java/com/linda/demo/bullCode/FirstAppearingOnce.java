package com.linda.demo.bullCode;


public class FirstAppearingOnce {

//    HashMap<Character, Integer> map=new HashMap();
//    ArrayList<Character> list=new ArrayList<Character>();
//    //Insert one char from stringstream
//    public void Insert(char ch)
//    {
//        if(map.containsKey(ch)){
//            map.put(ch,map.get(ch)+1);
//        }else{
//            map.put(ch,1);
//        }
//
//        list.add(ch);
//    }
//
//    //return the first appearence once char in current stringstream
//    public char FirstAppearingOnce()
//    {   char c='#';
//        for(char key : list){
//            if(map.get(key)==1){
//                c=key;
//                break;
//            }
//        }
//
//        return c;
//    }

    public static char FirstAppearingOnce(String str)

    {
        for (int i = 0; i < str.length(); i++) {
            int j = 0;
            for (; j < str.length(); j++) {
                if (i != j && str.charAt(i) == str.charAt(j)) {
                    break;
                }
            }

            if (j == str.length()) {
                return str.charAt(i);
            }
            continue;
        }
        return '#';
    }

    public static void main(String[] args) {
        System.out.println(FirstAppearingOnce("abcab"));
        System.out.println(FirstAppearingOnce("abcabc"));
    }
}
