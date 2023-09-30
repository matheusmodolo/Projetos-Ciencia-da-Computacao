#include <stdio.h>
#include <stdlib.h>

int main(){

    float peso;
    float alt;
    float IMC;

    printf("Entre com seu peso em quilogramas: ");
    scanf ("%f", &peso);

    printf("Entre com sua altura em metros: ");
    scanf ("%f", &alt);

    IMC = peso/(alt*alt);

    printf("IMC: %.2f", IMC);

    if(IMC < 17){
        printf("\nVoce esta muito abaixo do peso ideal!");
    }else if (17 <= IMC && IMC < 18.5 ){
        printf("\nVoce esta abaixo do peso ideal!");
    }else if(18.5 <= IMC && IMC < 25){
        printf("\nParabens! Voce esta em seu peso normal!");
    }else if(25 <= IMC && IMC < 30){
        printf("\nAtencao, voce esta acima de seu peso (sobrepeso)!");
    }else if(30 <= IMC && IMC < 35){
        printf("\nCuidado! Obesidade grau I!");
    }else if(35 <= IMC && IMC < 40){
        printf("\nCuidado! Obesidade grau II!");
    }else if(IMC >= 40){
        printf("\nMuito cuidado!!! Obesidade grau III!");
    }


return 0;
}
