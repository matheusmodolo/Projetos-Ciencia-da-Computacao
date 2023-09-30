#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void decompoeData(int ddia, int ano, int *mes, int *dia);
bool ehBissexto(int ano);

int main(){

    int mmes;
    int ddia;
    int ano;
    int *mes = &mmes;
    int *dia = &ddia;

    printf("Dia do ano: ");
    scanf("%d", &ddia);
    printf("Ano: ");
    scanf("%d", &ano);

    system("cls");

    printf("O dia %d do ano %d cai ", ddia, ano);

    decompoeData(ddia, ano, mes, dia);

    printf("no dia %d do mes %d.", *dia, *mes);

return 0;
}

void decompoeData (int ddia, int ano, int *mes, int *dia){

    int i;
    int j;
    int b[12] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int nb[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int aux = 0;

    for (i=1; i <= 12; i++){
        if(ehBissexto(ano)){
            for (j=1; j<= b[i-1]; j++){
                    aux += 1;
                    if (aux == ddia){
                        *dia = j;
                        *mes = i;
                        return;
                    }
            }
        }else{
            for (j=1; j<= nb[i-1]; j++){
                aux += 1;
                if (aux == ddia){
                    *dia = j;
                    *mes = i;
                    return;
                }
            }
        }
    }
}

bool ehBissexto (int ano){
    if((ano%4==0 || ano%4==0) && ano%100!=0){
        return true;
    }else{
        return false;
    }
}
