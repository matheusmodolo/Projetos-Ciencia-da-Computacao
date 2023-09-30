#include <stdio.h>
#include <stdlib.h>

int fibonacciRecursivo(int n);

int main(){

    printf("Digite a quantidade de termos: ");
    int n;
    scanf("%d", &n);
    for(int i = 0; i < n; i++){
        printf("%d ", fibonacciRecursivo(i+1));
    }

	return 0;
}

int fibonacciRecursivo(int n){
    if (n == 1 || n == 2){
        return 1;
    }else{
        return fibonacciRecursivo(n-1) + fibonacciRecursivo(n-2);
    }
}
