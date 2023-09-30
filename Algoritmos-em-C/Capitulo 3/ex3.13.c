#include <stdio.h>
#include <stdlib.h>

int main (){

    int i;
    int n1;
    int n2;
    int nMenor;
    int nMaior;
    int m2 = 0;
    int m3 = 0;
    int m4 = 0;

    printf("N1: ");
    scanf("%d", &n1);

    printf("N2: ");
    scanf("%d", &n2);

    if(n1 <= n2){
        nMaior = n2;
        nMenor = n1;
    }else{

        nMaior = n1;
        nMenor = n2;
    }

    for (i = nMenor; i <= nMaior; i++){
        if (i%2==0){
            m2++;
        }

        if(i%3==0){
            m3++;
        }

        if(i%4==0){
            m4++;
        }
    }

    printf("Multiplos de 2: %d\n", m2);

    printf("Multiplos de 3: %d\n", m3);

    printf("Multiplos de 4: %d", m4);


return 0;
}
