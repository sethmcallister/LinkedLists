struct node *head = NULL;
struct node *current = NULL;
int place = 0;

struct node
{
    struct node *next;
    int val;
};

struct node* create_list(int val)
{
    struct node *ptr = (struct node*)malloc(sizeof(struct node));

    if(ptr == NULL)
    {
        return NULL;
    }

    ptr->val = val;
    ptr->next = NULL;

    head = current = ptr;

    return ptr;
}

struct node* add(int val)
{
    if(head == NULL)
    {
        return NULL;
    }

    struct node *ptr = (struct node*)malloc(sizeof(struct node))

    if(ptr == NULL)
    {
        return NULL;
    }

    ptr->val = val;
    ptr->next = NULL;

    current->next = ptr;
    current = ptr;
}

struct boolean contains(int val, struct node **prev)
{
    struct node *ptr = head;
    struct *tmp = NULL;
    bool found = false;

    while(ptr != NULL)
    {
        if(ptr->next == val)
        {
            found = true;
            break;
        }
        else
        {
            tmp = ptr;
            ptr = ptr->next;
        }
    }

    return
}

int delete(int val)
{
    struct node *prev = NULL;
    struct node *del = NULL;

    del = contains(val, &prev);
    if(del == false)
    {
        return -1;
    }
    else
    {
        if(prev != NULL)
        {
                prev->next = del->next;
        }
        
        if(del == current)
        {
            current = prev;
        }
        else if(del == head)
        {
            head = del->next;
        }
    }

    free(del);
    del = NULL;
    return 0;
}