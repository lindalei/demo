package com.linda.demo.bullCode;

public class FrogLeap {
    public int JumpFloorII(int target) {
        if(target==1){
            return 1;
        }
        else if( target==2){
            return 2;
        }
        else{
            return 2*JumpFloorII(target-1);
        }
    }
}
