/*quase :(      acho que vale alguma coisa hein hehehe*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void decodificar (const char *codificada, char*decodificada);

int main(){

    char codificada [41];
    char decodificada[41];

    printf("Codificada: ");
    gets(codificada);

    decodificar(codificada, decodificada);

    printf("String decodificada: %s", decodificada);

    return 0;
}

void decodificar (const char *codificada, char*decodificada){

    int i;

    for (i=0; i<strlen(codificada); i++){

        if(codificada[i]=='\0'){
            break;
        }else{
            if(codificada[i]=='0'){
                decodificada[i]='0';
            }else if(codificada[i]=='1'){
                decodificada[i]='1';
            }else if(codificada[i]=='A'||codificada[i]=='B'||codificada[i]=='C'){
                decodificada[i]='2';
            }else if(codificada[i]=='D'||codificada[i]=='E'||codificada[i]=='F'){
                decodificada[i]='3';
            }else if(codificada[i]=='G'||codificada[i]=='H'||codificada[i]=='I'){
                decodificada[i]='4';
            }else if(codificada[i]=='J'||codificada[i]=='K'||codificada[i]=='L'){
                decodificada[i]='5';
            }else if(codificada[i]=='M'||codificada[i]=='N'||codificada[i]=='O'){
                decodificada[i]='6';
            }else if(codificada[i]=='P'||codificada[i]=='Q'||codificada[i]=='R'||codificada[i]=='S'){
                decodificada[i]='7';
            }else if(codificada[i]=='T'||codificada[i]=='U'||codificada[i]=='V'){
                decodificada[i]='8';
            }else if(codificada[i]=='W'||codificada[i]=='X'||codificada[i]=='Y'||codificada[i]=='Z'){
                decodificada[i]='9';
            }
        }
    }
}
