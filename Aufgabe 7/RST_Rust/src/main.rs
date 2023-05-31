#![allow(non_snake_case)]

use std::fs::File;
use std::io::{self, BufRead};

fn heapify_down(heap: &mut [i32], index: usize) {
    let left_child_index = 2 * index + 1;
    let right_child_index = 2 * index + 2;
    let mut smallest = index;

    if left_child_index < heap.len() && heap[left_child_index] < heap[smallest] {
        smallest = left_child_index;
    }

    if right_child_index < heap.len() && heap[right_child_index] < heap[smallest] {
        smallest = right_child_index;
    }

    if smallest != index {
        heap.swap(index, smallest);
        heapify_down(heap, smallest);
    }
}

fn heapify_up(heap: &mut Vec<i32>, index: usize) {
    if index == 0 {
        return;
    }

    let parent_index = (index - 1) / 2;

    if heap[parent_index] > heap[index] {
        heap.swap(parent_index, index);
        heapify_up(heap, parent_index);
    }
}

fn insert_into_heap(heap: &mut Vec<i32>, value: i32) {
    heap.push(value);
    let index = heap.len() - 1;
    heapify_up(heap, index);
}

fn heap_sort(heap: &Vec<i32>) -> Vec<i32> {
    let mut sorted_array = heap.clone();

    for i in (1..sorted_array.len()).rev() {
        sorted_array.swap(0, i);
        heapify_down(&mut sorted_array[..i], 0);
    }

    sorted_array
}

fn sort_heap(heap: &mut Vec<i32>) {
    let heap_size = heap.len();

    for i in (1..heap_size).rev() {
        heap.swap(0, i);
        heapify_down(&mut heap[..i], 0);
    }
}

fn read_file(filename: &str) -> Result<Vec<i32>, io::Error> {
    let file = File::open(filename)?;
    let reader = io::BufReader::new(file);
    let mut numbers = Vec::new();

    for line in reader.lines() {
        if let Ok(number) = line {
            if let Ok(parsed_number) = number.trim().parse::<i32>() {
                numbers.push(parsed_number);
            }
        }
    }

    Ok(numbers)
}

fn main() {
    let mut heap = Vec::new();
    let mut numbers_loaded = false;

    loop {
        println!("Bitte wählen Sie eine Option:");
        println!("e : Einfügen eines Elements in den Heap");
        println!("l : Löschen des kleinsten Elements aus dem Heap");
        println!("s : Sortiertes Ausgeben des Heaps (HeapSort durchführen)");
        println!("s2 : Sortieren des Heaps (HeapSort durchführen)");
        println!("a : Ausgeben des Arrays");
        println!("n : Einlesen einer Datei");

        let choice = read_line();

        match choice.as_str() {
            "e" => {
                println!("Bitte geben Sie das einzufügende Element ein:");
                if let Ok(value) = read_line().parse::<i32>() {
                    insert_into_heap(&mut heap, value);
                } else {
                    println!("Ungültige Eingabe!");
                }
            }
            "l" => {
                if let Some(min) = heap.pop() {
                    println!("Das kleinste Element im Heap ist: {}", min);
                } else {
                    println!("Der Heap ist leer!");
                }
            }
            "s" => {
                let sorted_array = heap_sort(&heap);
                println!("Sortiertes Array: {:?}", sorted_array);
            }
            "s2" => {
                sort_heap(&mut heap);
                println!("Heap sortiert!");
                println!("Array: {:?}", heap);
            }
            "a" => {
                println!("Array: {:?}", heap);
            }
            "n" => {
                println!("Bitte geben Sie den Dateinamen ein:");
                let filename = read_line();

                if let Ok(numbers) = read_file(&filename) {
                    heap = numbers;
                    numbers_loaded = true;
                    println!("Datei erfolgreich eingelesen!");
                } else {
                    println!("Fehler beim Einlesen der Datei!");
                }
            }
            _ => {
                println!("Ungültige Option!");
            }
        }

        if numbers_loaded {
            println!("Heap: {:?}", heap);
        }
    }
}

fn read_line() -> String {
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Fehler beim Lesen der Eingabe");
    input.trim().to_string()
}
