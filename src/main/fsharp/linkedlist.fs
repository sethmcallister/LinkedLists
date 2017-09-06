[<AllowNullLiteral>]
type Node(value, next) =
    member this.value = value;
    member this.next : Node ref = next;

let head : ref<Node> = ref null

let rec sum (n : Node) =
    if n = null then
        0.0
    else
        n.value + sum !1.next

module LinkedList =
    type Node = { value: float; next : LinkedList}
    and LinkedList = Node option ref

    let empty : LinkedList = ref None
    let single x = { value = x; next = ref None }

    let rec append x l =
        let node = singleton x
        match !l with
        |    None ->
            l := Some node
        | Some node ->
            append x node.next

    let rec sum (l : LinkedList) =
        match !l with
        | None -> 0.0
        | Some item -> item.value + sum item.next
