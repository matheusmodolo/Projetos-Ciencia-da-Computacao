#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>


bool numeroCorreto (int n);
int obtemDigito (int n);
int obtemNumero (int n);
int calculaDigito (int n);


int main(){

    int n;
    printf("Numero: ");
    scanf("%d", &n);

    system("cls");

    printf("Numero completo: %d\n", n);
    printf("Numero: %d\n", obtemNumero(n));
    printf("Digito: %d\n", obtemDigito(n));
    printf("Digito calculado: %d\n", calculaDigito(n));

    if(numeroCorreto(n)){
        printf("O numero fornecido esta correto!");
    }else{
        printf("O numero fornecido esta incorreto!");
    }


return 0;
}

bool numeroCorreto(int n){

    if(obtemDigito(n)==calculaDigito(n)){
        return true;
    }else{
        return false;
    }
}


int obtemDigito (int n){

    int resto;

   resto = n%10;

return resto;
}
int obtemNumero (int n){

    int numero;

    numero = n/10;

return numero;
}

int calculaDigito (int n){

   int k = 10000;
    int i;
    int resto;
    int sub;
    int soma = 0;
    int j = 5;
    int array[4];
    int vezes[4];

    for (i=0; i<4; i++){
        array[i] = n/k;
        n = n%k;
        k=k/10;
        vezes[i] = array [i] * j;
        j=j-1;
        soma = soma + vezes[i];
    }
    resto = soma % 11;
    sub = 11 - resto;
    if (sub == 10 || sub == 11){
        return 0;
    }else{
        return sub;
    }

}
