#include <stdio.h>
#include <stdlib.h>

int main(){

    srand(time(NULL));

    printf("Entre com o tamanho do Array de Inteiros: ");
    int n;
    scanf("%d", &n);
    int a[n];
    int coleta[n];
    int i;
    int c = 0;

    printf("Array Gerado = ");

    for (i=0; i<n; i++){
        a[i] = rand()%100;
        printf(" %d", a[i]);
    }
    int p;
    printf("\nEntre com o valor inteiro a ser procurado: ");
    scanf("%d", &p);

    for(i=0; i<n; i++){
        if(a[i]==p){
            coleta[c++]=i;
        }
    }

    if(c==0){
        printf("O valor %d nao foi encontrado!", p);
    }else{
        printf("O valor %d foi encontrado", p);
        if(c==1){
            printf("na posicao %d", coleta[0]);
        }else{
            printf("nas posicoes ");
            for(i=0; i<c; i++){
                if (i==0){
                    printf("%d", coleta[i]);
                }else if(i==c-1){
                    printf(" e %d", coleta[i]);
                }else{
                    printf(", %d", coleta[i]);
                }
            }
        }
        printf(" do array");
    }

    return 0;
}
