#include <stdio.h>
#include <stdlib.h>

int main() {

    float peso = 0;
    float soma = 0;
    float pesoMaior = 0;
    float media = 0;
    int pessoa = 1;
    int contador = 0;

    while(peso >= 0){
        printf("Entre com o peso da pessoa %02d: ", pessoa);
        scanf("%f", &peso);

        if (peso < 0 && pessoa==1){
            media = 0;
            pesoMaior = 0;
        }

        if(peso > 60){
            soma = soma + peso;
            contador++;
            media = soma / contador;
        }

        if (peso > pesoMaior){
            pesoMaior = peso;
        }
        pessoa++;
    }


    printf("Media dos pesos acima de 60kg: %.2f\n", media);

    printf("A pessoa mais pesada possui %.2fkg", pesoMaior);



return 0;

}
