#include<stdio.h>
#include <sys/mman.h>
#include <math.h>
#include "hw2.h"

int InitMyMalloc(int YiginBoyutu) {
    int size = getpagesize();
    int real = (int)pow(2, ceil(log(YiginBoyutu)/log(2)));
    
    head = mmap(NULL, real, PROT_READ|PROT_WRITE,MAP_ANON|MAP_PRIVATE, -1, 0); 
    head->size = real - (int)sizeof(node_t);
    head->is = 2;
    head->next = NULL;

    if (head == NULL) return -1; else return 0;
}

void *myMAlloc(int boyut) {
    int real = (int)pow(2, ceil(log(boyut)/log(2)));
    node_t *temp = head;
    while(temp->next!=NULL && (temp->size < real || temp->is != 2)){ 
		temp = temp->next;
	}
	
    void *solution; 
    
    if((temp->size) > real) {
        node_t *newNode = (void*)((void*)temp + sizeof(node_t) + real);
        newNode->size = temp->size -real -sizeof(node_t);
        newNode->is=2;
        newNode->next = temp->next;
        
        temp->size = real;
        temp->is = 0;
        temp->next = newNode;
        
        solution = (void*)(++temp);
		return solution; 
    }
    else if((temp->size) == real){
		temp -> is = 0;
		temp = (void*)(++temp);
		return temp;
	}
	else{ 
		temp = NULL; 
		printf("No sufficient memory to allocate\n");
		return temp;
	}
    
}

int MyFree(void *ptr) {
    if(ptr == NULL) return 1;
	node_t *free = ptr; 
	--free;
	free -> is = 2;

    node_t *merge = head; 
	while((merge -> next)!=NULL){
		if(merge -> is !=2 || merge -> next -> is != 2){
			merge  = merge  -> next;
		}else{ 
			merge -> size += (merge -> next -> size) + (int)sizeof(node_t);
			merge -> next = merge -> next -> next;
		}
	}
    return 0;
}

void DumpFreeList() {
    node_t *temp = head;
    while(temp != NULL) {
        if(temp->is == 0) 
            printf("I am not free! My size is %d and my address is %p\n",temp->size,temp);
        else
            printf("I am free! My size is %d and my address is %p\n",temp->size,temp);
        temp = temp->next;
    }
}

int main() {
    InitMyMalloc(3000);
    node_t *temp = myMAlloc(40);
    node_t *temp2 = myMAlloc(40);
    node_t *temp3 = myMAlloc(403);
    MyFree(temp2);
    node_t *temp4 = myMAlloc(5);
    DumpFreeList();
    return 0;
}