#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void imprimeDuplaClassificada (int n1, int n2, bool emOrdemCrescente);
bool emOrdemCrescente(int i);

int main(){

    int n1[5], n2[5];
    int i;

    for(i=0; i<5; i++){
        printf("n1[%d]: ", i);
        scanf("%d", &n1[i]);

        printf("n2[%d]: ", i);
        scanf("%d", &n2[i]);
    }

    for(i=0; i<5; i++){
        printf("%d e %d: ", n1[i], n2[i]);
        imprimeDuplaClassificada (n1[i], n2[i], emOrdemCrescente(i));
    }



return 0;
}
bool emOrdemCrescente(int i){
    if(i%2==0){
        return true;
    }else{
        return false;
    }
}
void imprimeDuplaClassificada (int n1, int n2, bool emOrdemCrescente){
    if (emOrdemCrescente){
        if(n1 <= n2){
            printf("%d <= %d\n", n1, n2);
        }else{
            printf("%d <= %d\n", n2, n1);
        }
    }else{
        if(n1 >= n2){
            printf("%d >= %d\n", n1, n2);
        }else{
            printf("%d >= %d\n", n2, n1);
        }
    }

}
