#include <stdio.h>
#include <stdlib.h>

int ehPar(int n);
int ehDivisivel(int dividendo, int divisor);

int main(){

    int i;
    int n1[5];
    int n2[5];

    for(i=0; i<5; i++){
        printf("n1[%d]: ", i);
        scanf("%d", &n1[i]);

        printf("n2[%d]: ", i);
        scanf("%d", &n2[i]);
    }
    for(i=0;i<5;i++){
        ehPar(n1[i]);
        ehDivisivel(n1[i], n2[i]);
    }

return 0;
}

int ehPar(int n1){

    printf("%d eh ", n1);

    if (n1%2==0){
        printf("par ");
    }else if(n1%2==1){
        printf("impar ");
    }
}
int ehDivisivel(int n1, int n2){

    printf("e %d ", n1);
    if(n1%n2==0){
        printf("eh divisivel ");
    }else{
        printf("nao eh divisivel ");
    }
    printf("por %d\n", n2);
}
