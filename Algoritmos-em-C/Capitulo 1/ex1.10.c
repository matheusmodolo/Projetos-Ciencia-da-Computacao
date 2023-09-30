#include <stdio.h>
#include <stdlib.h>

int main(){

    int A;
    int B;
    int b;
    int h;

    printf("Valor da base maior: ");
    scanf("%d", &B);

    printf("Valor da base menor: ");
    scanf("%d", &b);

    printf("Valor da altura: ");
    scanf("%d", &h);

    A=(B+b)*h/2;

    printf("\nArea = %d", A);



return 0;
}
