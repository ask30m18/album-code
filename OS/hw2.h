#include <stdio.h>
#include <stddef.h>

typedef struct __node_t {
    int size;
    int is;//0 not free, 2 free
    struct __node_t *next;
} node_t;

node_t *head;

int InitMyMalloc(int YiginBoyutu);
void *myMAlloc(int boyut);
void DumpFreeList();
int MyFree(void *ptr);