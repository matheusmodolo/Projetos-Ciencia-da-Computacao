#include <stdio.h>
#include <stdlib.h>

void trocar( int *pn1, int *pn2 );

int main(){

    int n1;
    int n2;
    int *pn1 = &n1;
    int *pn2 = &n2;

    printf("n1: ");
    scanf("%d", &n1);

    printf("n2: ");
    scanf("%d", &n2);

    printf("Antes:\n");
    printf("    n1: %d\n", *pn1);
    printf("    n2: %d\n", *pn2);

    trocar (pn1, pn2);

    printf("Depois:\n");
    printf("    n1: %d\n", *pn1);
    printf("    n2: %d\n", *pn2);

return 0;
}

void trocar( int *pn1, int *pn2 ){

    int aux = *pn1;
    *pn1 = *pn2;
    *pn2 = aux;

}
