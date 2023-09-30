#include <stdio.h>
#include <stdlib.h>

void decompoeCentavos (int totalCentavos, int *umR, int *cinquentaC, int *vinteCincoC, int *dezC, int *cincoC, int *umC);

int main(){

    int totalCentavos;
    int umR;
    int cinquentaC;
    int vinteCincoC;
    int dezC;
    int cincoC;
    int umC;
    int *pumR = &umR;
    int *pcinquenta = &cinquentaC;
    int *pvintecinco = &vinteCincoC;
    int *pdez = &dezC;
    int *pcinco = &cincoC;
    int *pumC = &umC;


    printf("Centavos: ");
    scanf("%d", &totalCentavos);

    decompoeCentavos (totalCentavos, pumR, pcinquenta, pvintecinco, pdez, pcinco, pumC);

    printf("%d moeda(s) de R$1,00\n", umR);
    printf("%d moeda(s) de R$0,50\n", cinquentaC);
    printf("%d moeda(s) de R$0,25\n", vinteCincoC);
    printf("%d moeda(s) de R$0,10\n", dezC);
    printf("%d moeda(s) de R$0,05\n", cincoC);
    printf("%d moeda(s) de R$0,01\n", umC);

    return 0;
}

void decompoeCentavos (int totalCentavos, int *umR, int *cinquentaC, int *vinteCincoC, int *dezC, int *cincoC, int *umC){

    int resto1;
    int resto2;
    int resto3;
    int resto4;
    int resto5;

    *umR = totalCentavos/100;
    resto1 = totalCentavos%100;
    *cinquentaC = resto1/50;
    resto2 = resto1%50;
    *vinteCincoC = resto2/25;
    resto3 = resto2%25;
    *dezC = resto3/10;
    resto4 = resto3%10;
    *cincoC = resto4/5;
    *umC = resto4;

}
