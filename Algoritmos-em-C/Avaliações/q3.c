#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void contar (const char *str, int *quantVogais, int *quantConsoantes, int *quantOutros);

int main(){

    char str[41];
    int vogais = 0;
    int consoantes = 0;
    int outros = 0;
    int *pvogais = &vogais;
    int *pconsoantes = &consoantes;
    int *poutros = &outros;

    printf("String: ");
    gets(str);

    printf("\"%s\" contem:\n", str);

    contar (str, pvogais, pconsoantes, poutros);

    printf("%d vogal(is),\n%d consoante(s) e\noutros %d caracteres.", vogais, consoantes, outros);

    return 0;
}

void contar (const char *str, int *quantVogais, int *quantConsoantes, int *quantOutros){

    int i;

    for (i = 0; i<strlen(str); i++){
        if(str[i]=='A'||str[i]=='a'||str[i]=='E'||str[i]=='e'||str[i]=='I'||str[i]=='i'||str[i]=='O'||str[i]=='o'||str[i]=='U'||str[i]=='u'){
            *quantVogais+=1;
        }else if(str[i]=='B'||str[i]=='b'||str[i]=='C'||str[i]=='c'||str[i]=='D'||str[i]=='d'||str[i]=='F'||str[i]=='f'||str[i]=='G'||str[i]=='g'||str[i]=='H'||str[i]=='h'
           ||str[i]=='J'||str[i]=='j'||str[i]=='K'||str[i]=='k'||str[i]=='L'||str[i]=='l'||str[i]=='M'||str[i]=='m'||str[i]=='N'||str[i]=='n'||str[i]=='P'
           ||str[i]=='p'||str[i]=='Q'||str[i]=='q'||str[i]=='R'||str[i]=='r'||str[i]=='S'||str[i]=='s'||str[i]=='T'||str[i]=='t'||str[i]=='V'||str[i]=='v'||str[i]=='W'||str[i]=='w'
           ||str[i]=='X'||str[i]=='x'||str[i]=='Y'||str[i]=='y'||str[i]=='Z'||str[i]=='z'){
            *quantConsoantes+=1;
        }else{
            *quantOutros+=1;
        }
    }
}
