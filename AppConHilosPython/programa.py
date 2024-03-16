import threading
import os

def task1():
    print("Tarea 1 asignada al thread: {}".format(threading.current_thread().name))
    print("ID del hilo correindo la tarea 1: {}".format(threading.current_thread().ident))

def task2():
    print("Tarea 2 asignada al thread: {}".format(threading.current_thread().name))
    print("ID del hilo correindo la tarea 2: {}".format(threading.current_thread().ident))

if __name__ == "__main__":
    print("ID del proceso corriendo el programa main: {}".format(os.getpid()))
    print("ID del identificador del hilo corriendo el programa main: {}".format(threading.current_thread().ident))
    print("Nombre del Main thread: {}".format(threading.current_thread().name))
    t1 = threading.Thread(target=task1, name="Hilo 1")
    t2 = threading.Thread(target=task2, name="Hilo 2")
    t1.start()
    t2.start()
    print("Programa terminado!")
