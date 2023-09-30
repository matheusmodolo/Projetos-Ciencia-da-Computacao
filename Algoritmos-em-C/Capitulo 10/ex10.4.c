//10.4
#include <stdio.h>
#include <stdlib.h>

typedef struct{

    float real;
    float imag;

}Complexo;

Complexo somar( const Complexo *c1, const Complexo *c2 );

void imprimirComplexo( const Complexo *c );

int main(){

    Complexo c1;
    Complexo c2;
    Complexo aux;

    printf("Complexo 1\n    Parte real: ");
    scanf("%f", &c1.real);
    printf("    Parte imaginaria: ");
    scanf("%f", &c1.imag);
    printf("Complexo 2\n    Parte real: ");
    scanf("%f", &c2.real);
    printf("    Parte imaginaria: ");
    scanf("%f", &c2.imag);

    aux = somar(&c1, &c2);

    imprimirComplexo(&c1);
    printf(" + ");
    imprimirComplexo(&c2);
    printf(" = ");
    imprimirComplexo(&aux);

    return 0;
}
Complexo somar( const Complexo *c1, const Complexo *c2 ){

    Complexo soma;

    soma.real = c1->real + c2->real;
    soma.imag = c1->imag+c2->imag;

    return soma;
}

void imprimirComplexo( const Complexo *c ){

    printf("(%.2f + %.2fi)", c->real, c->imag);
}
