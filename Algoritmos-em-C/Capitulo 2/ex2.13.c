#include <stdio.h>
#include <stdlib.h>

int main(){

    float n1;
    float n2;
    float nOpt;
    float media;

    printf("Nota Av. 1: ");
    scanf("%f", &n1);

    printf("Nota Av. 2: ");
    scanf("%f", &n2);

    printf("Nota Optativa: ");
    scanf("%f", &nOpt);

    if (nOpt < 0){
        media = (n1 + n2)/2;

    }else if(nOpt > n1){
        media = (nOpt + n2)/2;

    }else if(nOpt > n2){
        media = (nOpt + n1)/2;

    }else if(nOpt < n1 && nOpt < n2){
        media + (n1 + n2)/2;

    }

       if (media >= 6){
            printf("Media: %.2f", media);
            printf("\nAprovado!");
        }else if (media < 6 && media >= 4){
            printf("Media: %.2f", media);
            printf("\nExame.");
        }else if (media < 4){
            printf("Media: %.2f", media);
            printf("\nReprovado...");
        }

return 0;
}
