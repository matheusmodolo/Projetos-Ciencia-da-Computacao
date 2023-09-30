#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int lePositivo();
int saoAmigos(int n1, int n2);

int main(){

    int i;
    int n1[5];
    int n2[5];
    bool amigos;

    for (i=0; i<5; i++){
        printf("n1[%d]: ", i);
        scanf("%d", &n1[i]);
        printf("n2[%d]: ", i);
        scanf("%d", &n2[i]);
    }
    for (i=0; i<5; i++){
        amigos = saoAmigos(n1[i], n2[i]);
        printf("%d e %d ", n1[i], n2[i]);
        if(!amigos){
            printf("nao ");
        }
        printf("sao amigos\n");

    }



return 0;
}

int lePositivo(){
    int n;
        scanf("%d", &n);
	    while(n<0){
        printf("Entre com um valor positivo: ");
        scanf("%d", &n);
        }
return n;
}

int saoAmigos(int n1, int n2){
    int i;
    int soma1 = 0;
    int soma2 = 0;

    for(i=1; i < n1; i++){
            if (n1 % i == 0){
                soma1 += i;
            }
    }

    for(i=1; i < n2; i++){
            if (n2 % i == 0){
                soma2 += i;
            }
    }
    if(soma1==n2 && soma2==n1){
        return true;
    }else{
        return false;
    }
}
