#include <stdio.h>
#include <stdlib.h>

int main(){

    int i;
    int n;


    printf("Forneca um numero maior ou igual a zero: ");
    scanf("%d", &n);


    if (n < 0){
        printf("Valor incorreto (negativo)");

    }else{
        for(i = 0; i <= n; i++ ){
            printf("%d ", i);
        }
    }


return 0;
}
