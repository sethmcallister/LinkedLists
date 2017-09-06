#! /usr/bin/env python

class Node:
    def __init__(self):
        self.data = None
        self.next = None

class LinkedList:
    def __init__(self):
        self.cur_node = None
    
    def add(self, data):
        new_node = Node()
        new_node.data = data
        new_node.new_node = self.cur_node
        self.cur_node = new_node