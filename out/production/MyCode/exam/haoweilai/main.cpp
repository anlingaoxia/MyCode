struct node {
    int value;
    struct node *next;
    struct node *prev;
};

struct node* links_merge(struct node *links[], int n) {
    node* start = find(links, n);
    node* nextNode = start;
    while (nextNode != NULL) {
        nextNode -> next = find(links, n);
        nextNode = nextNode -> next;
    }
    return start;
}

struct node* find(struct node *links[], int n) {
    node* t = NULL;
    int p = -1;
    for (int i = 0; i < n; i++) {
        if (links[i] == NULL) {
            continue;
        } else if (links[i] != NULL && t == NULL) {
            t = links[i];
            p = i;
        } else if ((links[i] -> value) > (t -> value)) {
            t = links[i];
            p = i;
        }
    }
    if (p >= 0) {
        links[p] = t -> next;
    }
    return t;
}






