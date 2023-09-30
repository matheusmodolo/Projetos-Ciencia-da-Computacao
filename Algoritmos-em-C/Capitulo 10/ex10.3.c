//10.3
#include <stdio.h>
#include <stdlib.h>

typedef struct{
    int hora;
    int min;
    int seg;
}Hora;

Hora gerarHora( int quantidadeSegundos );

void imprimirHora( const Hora *hora );

int main(){

    int quantidadeSegundos;
    Hora h;

    printf("Segundos: ");
    scanf("%d", &quantidadeSegundos);

    h = gerarHora(quantidadeSegundos);

    printf("Hora correspondente: ");

    imprimirHora(&h);


    return 0;
}
Hora gerarHora( int quantidadeSegundos ){

    Hora hr;

    int resto;

    resto = quantidadeSegundos%3600;
    hr.hora = quantidadeSegundos/3600;
    hr.seg = resto%60;
    hr.min = resto/60;



    return hr;
}

void imprimirHora( const Hora *hora ){

    printf("%.2d:%.2d:%.2d", hora->hora, hora->min, hora->seg);

}
