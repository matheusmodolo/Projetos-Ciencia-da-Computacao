#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int c = 1;

bool ehprimo(int n);

int main(){

    srand(time(NULL));//o valor não será o mesmo em cada execução do programa
    int n = rand()%100;
    printf("Numero inteiro gerado automaticamente (1-100): %d", n);
    printf("\nO numero %d ", n);

    bool primo;
    primo = ehprimo(n);

    if(primo){
        printf("eh Primo");
    }else{
        printf("NAO eh Primo");
    }
    printf(" (Num operacoes = %d)", c);

    return 0;
}

bool ehprimo(int n){

    for (int i = 1; i<n; i++){
        if(n%i == 0){
            c++;
        }
        if(c>2){
            return false;
        }
    }
        if(c==2){
            return true;
        }
}
