//10.2
#include <stdio.h>
#include <stdlib.h>

typedef struct{

        int Dia;
        int Mes;
        int Ano;

}Data;

int compararData( const Data *d1, const Data *d2 );

void imprimirData( const Data *data );

int main(){

    Data d2;
    Data d1;

    printf("Data 1\n    dia: ");
    scanf ("%d", &d1.Dia);
    printf("    mes: ");
    scanf("%d", &d1.Mes);
    printf("    ano: ");
    scanf("%d", &d1.Ano);

    printf("Data 2\n    dia: ");
    scanf ("%d", &d2.Dia);
    printf("    mes: ");
    scanf("%d", &d2.Mes);
    printf("    ano: ");
    scanf("%d", &d2.Ano);

    int resultado = compararData(&d1, &d2);

    if (resultado < 0) {
        imprimirData(&d1);
        printf(" <= ");
        imprimirData(&d2);
    } else if (resultado > 0) {
        imprimirData(&d2);
        printf(" <= ");
        imprimirData(&d1);
    } else {
        imprimirData(&d1);
        printf(" <= ");
        imprimirData(&d2);
    }

    return 0;
}

int compararData( const Data *d1, const Data *d2 ){

    if(d1->Ano < d2->Ano){
        return -1;
    }else if(d1->Ano > d2->Ano){
        return 1;
    }else{
        if(d1->Mes < d2->Mes){
            return -1;
        }else if(d1->Mes > d2->Mes){
            return 1;
        }else{
            if(d1->Dia < d2->Dia){
                return -1;
            }else if(d1->Dia > d2->Dia){
                return 1;
            } else {
                return 0;
            }
        }
    }
}

void imprimirData( const Data *data ){

    printf("%02d/%02d/%04d", data->Dia, data->Mes, data->Ano);

}
