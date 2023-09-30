#include <stdio.h>
#include <stdlib.h>

int main(){

    char opcao;
    float T;
    float resultado;

    printf("Escolha uma operacao de acordo com o menu: ");
    printf("\nC) Celsius -> Fahrenheit;");
    printf("\nF) Fahrenheit -> Celsius.");
    printf("\nOpcao: ");
    scanf(" %c", &opcao);

    switch(opcao)
    {
    case 'F':
    case 'f':
        printf("Entre com a temperatura em Fahrenheit: ");
        scanf("%f", &T);

        resultado = (T - 32)/1.8;

        printf("%.2f graus Fahrenheit correspondem a %.2f graus Celsius", T, resultado);
    break;

    case 'C':
    case 'c':
        printf("Entre com a temperatura em Celsius: ");
        scanf("%f", &T);

        resultado = 1.8*T + 32;

        printf("%.2f graus Celsius correspondem a %.2f graus Fahrenheit", T, resultado);

    break;

    default:
        printf("Opcao invalida!");
    }

return 0;
}
