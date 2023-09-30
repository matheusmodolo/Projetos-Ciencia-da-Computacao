#include <stdio.h>
#include <stdlib.h>

int somatorio(int n);

int main(){

    int n[5];
    int i;

    for (i=0; i<5; i++){
        printf("n%d: ", i+1);
        scanf("%d", &n[i]);
    }

    for (i=0; i<5; i++){
        printf("somatorio(%d) = %d\n", n[i], somatorio(n[i]));
    }

    return 0;
}

int somatorio(int n){

    int somatorio = 0;
    int i;

    for (i=0; i<n; i++){
        somatorio+=i+1;
    }

    return somatorio;
}
