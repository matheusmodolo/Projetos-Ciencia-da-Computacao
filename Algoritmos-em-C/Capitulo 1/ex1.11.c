#include <stdio.h>
#include <stdlib.h>

int main() {

    int A;
    int D;
    int d;

    printf("Valor da diagonal maior: ");
    scanf("%d", &D);

    printf("Valor da diagonal menor: ");
    scanf("%d", &d);

    A = D * d / 2;

    printf("Area = %d", A);

return 0;

}
