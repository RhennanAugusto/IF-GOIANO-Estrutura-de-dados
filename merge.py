import time

def merge_sort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2
        left_half = arr[:mid]
        right_half = arr[mid:]

        merge_sort(left_half)
        merge_sort(right_half)

        i, j, k = 0, 0, 0

        while i < len(left_half) and j < len(right_half):
            if left_half[i] < right_half[j]:
                arr[k] = left_half[i]
                i += 1
            else:
                arr[k] = right_half[j]
                j += 1
            k += 1

        while i < len(left_half):
            arr[k] = left_half[i]
            i += 1
            k += 1

        while j < len(right_half):
            arr[k] = right_half[j]
            j += 1
            k += 1

def print_sorted_data(data):
    print("Dados ordenados:", data)

if __name__ == "__main__":
    
    file_path = r"c:\Users\rhenn\Downloads\dados100_mil.txt"
    with open(file_path, "r") as file:
        data = [(line.strip()) for line in file]

   
    start_time = time.time()

   
    merge_sort(data)

  
    print_sorted_data(data)

    end_time = time.time()

   
    print(f"Tempo total do programa: {end_time - start_time:.6f} segundos")