#include <stdio.h>
#include <stdlib.h>
int main() {
    
    FILE *fptr;
    fptr = fopen("test.txt","r");
    if (fptr == NULL){
       printf("Error! opening file");
       exit(1);
   }
    char string[21];
    fgets(string, 21, fptr);
    printf("Ben parent ilk 21 karakter:%s\n", string);
    int b = fork();
    
    if(b==0) {
        char string[21];
        fgets(string, 21, fptr);
        printf("Ben çocuk karakterler: %s\n", string);
        
    } else {
        char string[21];
        fgets(string, 21, fptr);
        printf("Ben parent sonra ki 21 karakter: %s\n", string);
    }
    
    return 0;
}