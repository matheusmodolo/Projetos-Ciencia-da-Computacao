#include<stdio.h>
#include<stdlib.h>

int main(){

    int array1[5];
    int array2[5];
    int cont = 0;
    int i;
    int j;
    int g;

    printf("Forneca os valores do primeiro array:\n");
    for(i=0; i<5; i++){
        printf("array1[%d]: ", i);
        scanf("%d", &array1[i]);
    }

    printf("\nForneca os valores do segundo array:\n");
    for(i = 0; i<5; i++){
        printf("array2[%d]: ",i);
        scanf("%d", &array2[i]);
    }

    for(i = 0; i<5; i++){
            for(g = i-1; g>=0; g--){
                if(array1[i]==array1[g] && g>=0){
                    i+=1;
                }
            }
        for(j=0; j<5; j++){
            if(array1[i]==array2[j]){
                    cont++;
                    j=5;
            }
        }
    }

    if(cont==0){
        printf("Nao ha interseccao entre os elementos dos dois arrays fornecidos!");
    }

    int array3[cont];
    int aux = 0;
    for(i =0; i<5; i++){
        for(g = i-1; g>=0; g--){
            if(array1[i]==array1[g] && g>=0){
                i+=1;
            }
        }
        for(j=0; j<5; j++){
            if(array1[i]==array2[j]){
                array3[aux]=array1[i];
                aux++;
                j=5;
            }
        }
    }

    size_t tarray3 = sizeof(array3)/sizeof(array3[0]);

    for(int i=0; i<tarray3; i++){
        printf("arrayInterseccao[%d] = %d\n", i, array3[i]);
    }

    return 0;
}
