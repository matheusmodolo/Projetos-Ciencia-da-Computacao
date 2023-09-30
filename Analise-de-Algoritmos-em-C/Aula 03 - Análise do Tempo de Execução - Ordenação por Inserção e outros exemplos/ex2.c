#include <stdio.h>
#include <stdlib.h>

int c = 0;
int max, min;

void maxMin1(int *a, int n);
void maxMin2(int *a, int n);
void maxMin3(int *a, int n);

int main(){

    int n;
    printf("Entre com o tamanho do Array de inteiros: ");
    scanf("%d", &n);
    int a[n];
    // *pa = a;
    int i;
    for(i=0; i<n; i++){
        printf("Digite o valor para a posicao %d do array: ", i+1);
        scanf("%d", &a[i]);
    }

    int maior;
    int menor;

    maxMin1(a,n);

    maior = max;
    menor = min;

    printf("maxMin1() - Maior elemento: %d - Menor elemento: %d (Num. de Operacoes: %d)\n", maior, menor, c);

    maxMin2(a,n);

    maior = max;
    menor = min;

    printf("maxMin2() - Maior elemento: %d - Menor elemento: %d (Num. de Operacoes: %d)\n", maior, menor, c);

    maxMin3(a,n);

    maior = max;
    menor = min;

    printf("maxMin3() - Maior elemento: %d - Menor elemento: %d (Num. de Operacoes: %d)\n", maior, menor, c);


    return 0;
}
void maxMin1(int *a, int n){
    c = 0;
    max = a[0];
    min = a[0];
    for(int i = 0; i<n; i++){
        if(a[i]>max){
            max = a[i];
        }
        if(a[i]<min){
            min = a[i];
        }
        c++;
    }

}
void maxMin2(int *a, int n){
    int i;
    c = 0;
    max = a[0];
    min = a[0];
        for(i=1; i<n; i++){
            if(a[i] > max){
                max = a[i];
            }else if(a[i] < min){
                min = a[i];
            }
            c++;
        }
}
void maxMin3(int *a, int n){
    c = 0;
    if(n%2!=0){
        a[n]=a[n-1];
        n++;
    }
    max = a[0];
    min = a[1];
    if(a[0]< a[1]){
        max = a[1];
        min = a[0];
    }
    for(int i = 2; i < n - 1; i+=2){
        if(a[i] > a[i+1]){
            if(a[i]>max){
                max = a[i];
            }
            if(a[i+1]<min){
                min = a[i+1];
            }
        }else{
            if (a[i]<min){
                min = a[i];
            }
            if(a[i+1]>max){
                max = a[i+1];
            }

        }
        c++;
    }
}
