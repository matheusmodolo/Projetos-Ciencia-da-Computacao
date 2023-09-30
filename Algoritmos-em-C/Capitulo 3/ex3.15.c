#include <stdio.h>
#include <stdlib.h>

int main(){

    int n;
    int i;
    int fat = 1;

    printf("Entre com um numero: ");
    scanf("%d", &n);

    if (n < 0){
        printf("Nao ha fatorial de numero negativo.");
    }else{
        for(i = n; i >= 1; i--){
            fat*=i;
        }
         printf("%d! = %d", n, fat);
    }

return 0;
}
