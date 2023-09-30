//10.1
#include <stdio.h>
#include <stdlib.h>

typedef struct{

    int dia;
    int mes;
    int ano;

}Data;

int diaDoAno( const Data *data );

int main(){

    Data date;

    printf("dia: ");
    scanf("%d", &date.dia);
    printf("mes: ");
    scanf("%d", &date.mes);
    printf("ano: ");
    scanf("%d", &date.ano);

    printf("O dia do ano da data %.2d/%.2d/%.4d eh %d.", date.dia, date.mes, date.ano, diaDoAno(&date));

    return 0;
}

int diaDoAno( const Data *data ){

    int diasDoAno[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    if(data->ano%4==0 || data->ano%400==0 && data->ano%100!=0){
        diasDoAno[1]=29;
    }

    int i;
    int aux = 0;

    for (i=0; i < 12; i++){
        if(i+1 != data->mes){
            aux += diasDoAno[i];
        }
        if(i+1 == data->mes){
            aux += data->dia;
            return aux;
        }
    }
}
