#include <stdio.h>
#include <stdlib.h>

 double produtoInterno( const double *a1, const double *a2, double *pi, int n );

int main(){

    double a1[5];
    double a2[5];
    double pi[5];
    double *pa1 = a1;
    double *pa2 = a2;
    double *ppi = pi;
    int i;

    for (i=0; i<5; i++){
        printf("a1[%d]: ", i);
        scanf("%lf", &a1[i]);
    }
    for (i=0; i<5; i++){
        printf("a2[%d]: ", i);
        scanf("%lf", &a2[i]);
    }
    produtoInterno(pa1, pa2, ppi, 5);

    for (i=0; i<5; i++){
        printf("%.2lf x %.2lf = %.2lf\n", a1[i], a2[i], pi[i]);
    }


return 0;
}

 double produtoInterno( const double *a1, const double *a2, double *pi, int n ){

    int i;

    for (i=0; i<n; i++){
        pi[i] = a1[i] * a2[i];

    }
    return 0;

 }
