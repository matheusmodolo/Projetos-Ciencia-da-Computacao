#include <stdio.h>
#include <stdlib.h>

float maiorNumero(float n1, float n2);

int main(){

    int i;
    float n1[5];
    float n2[5];

    for(i = 0; i<5; i++){

        do{
            printf("n1[%d]: ", i);
            scanf("%f", &n1[i]);

            if(n1[i]<=0){
                printf("Entre com um valor positivo!\n");
            }
        }while(n1[i]<=0);

        do{
            printf("n2[%d]: ", i);
            scanf("%f", &n2[i]);

            if(n2[i]<=0){
                printf("Entre com um valor positivo!\n");
            }
        }while(n2[i]<=0);
    }

    for (i=0; i<5; i++){
            if(maiorNumero(n1[i], n2[i]) == -1){
                printf("%.2f, %.2f: Eles sao iguais\n", n1[i], n2[i]);
            }else{
                printf("%.2f, %.2f: O maior valor e %.2f\n", n1[i], n2[i], maiorNumero(n1[i], n2[i]));
            }
    }
    return 0;
}


float maiorNumero(float n1, float n2){

    if(n1 > n2){
        return n1;
    }else if(n2 > n1){
        return n2;
    }else{
        return -1;
    }
}
