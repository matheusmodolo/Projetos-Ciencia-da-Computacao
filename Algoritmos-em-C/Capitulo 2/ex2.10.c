#include <stdio.h>
#include <stdlib.h>

int main () {

    float a;
    float b;
    float c;
    float moduloAB;
    float moduloAC;
    float moduloBC;

    printf("a: ");
    scanf("%f", &a);

    printf("b: ");
    scanf("%f", &b);

    printf("c: ");
    scanf("%f", &c);

    moduloAB = a - b;

    if( moduloAB < 0) {
        moduloAB = -moduloAB;

    }
    moduloAC = a - c;

    if( moduloAC < 0) {
        moduloAC = -moduloAC;

    }
    moduloBC = b - c;

    if( moduloBC < 0) {
        moduloBC = -moduloBC;

    }

    if( moduloAB < c && c < a + b &&
        moduloAC < b && b < a + c &&
        moduloBC < a && a < b + c){
        if ( a==b && b==c){
            printf("Triangulo EQUILATERO");

        }else if (a!=b && b!=c && a!=c){
            printf("Triangulo ESCALENO");

        }else{
            printf("Triangulo ISOSCELES");
        }

    }else{
        printf("As medidas fornecidas dos lados nao representam um triangulo valido!");
    }



return 0;
}
