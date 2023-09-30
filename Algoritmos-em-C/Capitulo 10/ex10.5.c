#include <stdio.h>
#include <stdlib.h>

typedef struct{

    float num;
    float den;

}Fracao;

Fracao somar( const Fracao *f1, const Fracao *f2 );

Fracao subtrair( const Fracao *f1, const Fracao *f2 );

Fracao multiplicar( const Fracao *f1, const Fracao *f2 );

Fracao dividir( const Fracao *f1, const Fracao *f2 );

void imprimirFracao( const Fracao *f );

int main(){

    Fracao f1;
    Fracao f2;

    Fracao so;



    printf("Fracao 1\n");
    printf("    Numerador: ");
    scanf("%f", &f1.num);
    printf("    Denominador: ");
    scanf("%f", &f1.den);

    printf("Fracao 2\n");
    printf("    Numerador: ");
    scanf("%f", &f2.num);
    printf("    Denominador: ");
    scanf("%f", &f2.den);

    printf("\n\n");

    so = somar(&f1, &f2);

    imprimirFracao(&f1);
    printf(" + ");
    imprimirFracao(&f2);
    printf(" = ");
    imprimirFracao(&so);
    printf("\n");

    Fracao su;
    su = subtrair(&f1, &f2);

    imprimirFracao(&f1);
    printf(" - ");
    imprimirFracao(&f2);
    printf(" = ");
    imprimirFracao(&su);
    printf("\n");

    Fracao mu;
    mu = multiplicar(&f1, &f2);

    imprimirFracao(&f1);
    printf(" * ");
    imprimirFracao(&f2);
    printf(" = ");
    imprimirFracao(&mu);
    printf("\n");

    Fracao di;
    di = dividir(&f1, &f2);

    imprimirFracao(&f1);
    printf(" / ");
    imprimirFracao(&f2);
    printf(" = ");
    imprimirFracao(&di);

    return 0;
}

Fracao somar( const Fracao *f1, const Fracao *f2 ){

    Fracao soma;

    if(f1->den==f2->den){
        soma.num = f1->num + f2->num;
        soma.den = f1->den;
    }else{
        soma.num = (f1->num*f2->den) + (f2->num*f1->den);
        soma.den = f1->den*f2->den;
    }
    return soma;
}

Fracao subtrair( const Fracao *f1, const Fracao *f2 ){

    Fracao sub;

    if(f1->den==f2->den){
        sub.num = f1->num - f2->num;
        sub.den = f1->den;
    }else{
        sub.num = (f1->num*f2->den) - (f2->num*f1->den);
        sub.den = f1->den*f2->den;
    }
    return sub;
}

Fracao multiplicar( const Fracao *f1, const Fracao *f2 ){

    Fracao mult;

    mult.num = f1->num*f2->num;
    mult.den = f1->den*f2->den;

    return mult;
}

Fracao dividir( const Fracao *f1, const Fracao *f2 ){

    Fracao div;

    div.num = f1->num*f2->den;
    div.den = f1->den*f2->num;

    return div;
}

void imprimirFracao( const Fracao *f ){

    printf("%.2f/%.2f", f->num, f->den);

}
