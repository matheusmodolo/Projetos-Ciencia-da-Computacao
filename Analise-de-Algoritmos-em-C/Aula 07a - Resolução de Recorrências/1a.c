#include <stdio.h>
#include <stdlib.h>

int fatorialRecursivo (int n);

int main(){


    printf("Forneca um numero: ");
    int n;
    scanf("%d", &n);

    printf("%d! = %d", n, fatorialRecursivo(n));

	return 0;
}

int fatorialRecursivo (int n) {
    int f;
    if(n<=1){
        return 1;
    }else{
    f = n * (fatorialRecursivo(n-1));
    return f;
    }
}
