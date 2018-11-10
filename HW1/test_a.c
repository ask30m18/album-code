#include <stdio.h>
#include <stdlib.h>
int main() {
   char a[] = {'a','s','f','d','\0'};
   char *b = malloc(strlen(a));
   strcpy(b,a);
   printf("%s",b);
}