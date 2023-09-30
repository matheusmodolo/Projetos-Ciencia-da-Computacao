#include <stdio.h>
#include <stdlib.h>

int calculaDigito (int n);

int main(){
    int n;

    printf("Numero: ");
    scanf("%d", &n);

    printf("Digito verificador de %d: %d", n, calculaDigito(n));


return 0;
}

int calculaDigito (int n){

    int n1, n2, n3, n4;
    int resto1, resto2;
    int i;
    int peso;
    int restodivisao;
    int digito;

    n1 = n/1000;
    resto1 = n%1000;
    n2 = resto1/100;
    resto2 = resto1/10;
    n3 = resto2%10;
    n4 = resto1%10;

    peso = 2*n4 + 3*n3 + 4*n2 + 5*n1;
    restodivisao = peso%11;

    digito = 11 - restodivisao;

    if(digito == 10 || digito == 11){
        return 0;
    }
    else{
        return digito;
    }
return digito;
}

/*
int luis(int n){
int soma=0;
int aux;
int cont=2;
int resto;

while(n>0){
    aux =n%10;
    n/=10;
    soma += (aux*cont);
    cont++;

}
resto = soma%11;
int digito = 11-resto;


}*/
