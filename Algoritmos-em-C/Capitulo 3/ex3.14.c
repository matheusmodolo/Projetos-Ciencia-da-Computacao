#include <stdio.h>
#include <stdlib.h>

int main(){

    int n1;
    int n2;
    int i;
    int nMaior;
    int nMenor;
    int somatorio = 0;

    printf("N1: ");
    scanf("%d", &n1);

    printf("N2: ");
    scanf("%d", &n2);

    if (n1 >= n2){
        nMaior = n1;
        nMenor = n2;
    }else{
        nMaior = n2;
        nMenor = n1;
    }

    for(i = nMenor; i <= nMaior; i++){
        somatorio += i;
    }

    printf("Somatorio entre %d e %d: %d", nMenor, nMaior, somatorio);


    return 0;
}
