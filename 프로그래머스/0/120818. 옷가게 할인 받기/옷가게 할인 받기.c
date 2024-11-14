#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int price) {
        
    if(price >= 100000 && price < 300000){
        return price * 0.95;
    }else if(price >= 300000 && price <500000){
        return price * 0.90;
    }else if(price >= 500000){
        return price * 0.8;
    }else{
        return price;
    }
    
}