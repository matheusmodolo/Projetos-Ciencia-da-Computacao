#include <stdio.h>
#include <stdlib.h>

int fibonacciIterativo(int n);

int main(){

    printf("Digite a quantidade de termos: ");
    int n;
    scanf("%d", &n);
    for(int i = 0; i < n; i++){
        printf("%d ", fibonacciIterativo(i));
    }

	return 0;
}

int fibonacciIterativo(int n){
    int a = 0, b = 1, c;
    for(int i = 0; i<n; i++){
        c = b + a;
        a = b;
        b = c;
    }
    return b;
}
