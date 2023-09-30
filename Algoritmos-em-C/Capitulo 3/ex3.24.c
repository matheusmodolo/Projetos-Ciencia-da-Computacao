#include <stdio.h>
#include <stdlib.h>

int main(){

    int idade = 0;
    int nPessoa = 1;
    int menores21 = 0;
    int maiores50 = 0;

    while( idade >= 0 ){

        printf("Idade da pessoa %02d: ", nPessoa++);
        scanf("%d", &idade);

        if(idade < 21 && idade >= 0){
            menores21++;
        }
        if (idade > 50){
            maiores50++;
        }

    }

    printf("Total de pessoas menores de 21 anos: %d\n", menores21);

    printf("Total de pessoas com mais de 50 anos: %d", maiores50);


return 0;
}
