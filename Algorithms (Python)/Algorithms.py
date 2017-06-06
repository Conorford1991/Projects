'''
Author: Conor Ford
Algorithms class
'''

#Modules
from AES import Aes
from Blowfish import Bf
from DES import Des
from TDES import Tdes
from RSA import Rsa
from FileReader import FileReader
import time
import psutil

class Algorithms:

# (self ) makes methods entirely the same as functions
 def AES_call(self,DataSizeSelect):
    # File reader call
    plaintext_bytes = FileReader().FileRead(DataSizeSelect)

    Encryptstart = time.time()
    # Encrypt call
    ciphertext_bytes, iv, key = Aes().Encrypt(plaintext_bytes)
    Encryptend = time.time()

    Decryptstart = time.time()
    # Decrypt call
    Aes().Decrypt(ciphertext_bytes, iv, key)
    Decryptend = time.time()

    # Encrypt Time
    encrypttime = Encryptend - Encryptstart

    # Decrypt time
    decrypttime = Decryptend - Decryptstart

    # cpu and memory cal
    memory = psutil.virtual_memory()
    cpu = psutil.cpu_percent(interval=1)

    # Print
    Algorithms().display(encrypttime,decrypttime,cpu,memory,'AES')



 def Blowfish_call(self,DataSizeSelect):
    # File reader call
    plaintext_bytes = FileReader().FileRead(DataSizeSelect)

    Encryptstart = time.time()
    # Encrypt call
    ciphertext_bytes, iv, key = Bf().Encrypt(plaintext_bytes)
    Encryptend = time.time()

    Decryptstart = time.time()
    # Decrypt call
    Bf().Decrypt(ciphertext_bytes, iv, key)
    Decryptend = time.time()

    # Encrypt Time
    encrypttime = Encryptend - Encryptstart

    # Decrypt time
    decrypttime = Decryptend - Decryptstart

    # cpu and memory cal
    memory = psutil.virtual_memory()
    cpu = psutil.cpu_percent(interval=1)

    # Print
    Algorithms().display(encrypttime, decrypttime, cpu, memory, 'Blowfish')

 def DES_call(self,DataSizeSelect):
    # File reader call
    plaintext_bytes = FileReader().FileRead(DataSizeSelect)

    Encryptstart = time.time()
    # Encrypt call
    ciphertext_bytes, iv, key = Des().Encrypt(plaintext_bytes)
    Encryptend = time.time()

    Decryptstart = time.time()
    # Decrypt call
    Des().Decrypt(ciphertext_bytes, iv, key)
    Decryptend = time.time()

    # Encrypt Time
    encrypttime = Encryptend - Encryptstart

    # Decrypt time
    decrypttime = Decryptend - Decryptstart

    # cpu and memory cal
    memory = psutil.virtual_memory()
    cpu = psutil.cpu_percent(interval=1)

    # Print
    Algorithms().display(encrypttime, decrypttime, cpu, memory, 'DES')


 def TDES_call(self,DataSizeSelect):
    # File reader call
    plaintext_bytes = FileReader().FileRead(DataSizeSelect)

    Encryptstart = time.time()
    # Encrypt call
    ciphertext_bytes, iv, key = Tdes().Encrypt(plaintext_bytes)
    Encryptend = time.time()

    Decryptstart = time.time()
    # Decrypt call
    Tdes().Decrypt(ciphertext_bytes, iv, key)
    Decryptend = time.time()

    # Encrypt Time
    encrypttime = Encryptend - Encryptstart

    # Decrypt time
    decrypttime = Decryptend - Decryptstart

    # cpu and memory cal
    memory = psutil.virtual_memory()
    cpu = psutil.cpu_percent(interval=1)

    # Print
    Algorithms().display(encrypttime, decrypttime, cpu, memory, 'TDES')


 def RSA_call(self):
    # File reader call
    plaintext_bytes = FileReader().KeyRead()

    Encryptstart = time.time()
    # Encrypt call
    ciphertext_bytes, iv, key = Rsa().Encrypt(plaintext_bytes)
    Encryptend = time.time()

    Decryptstart = time.time()
    # Decrypt call
    Rsa().Decrypt(ciphertext_bytes, iv, key)
    Decryptend = time.time()

    # Encrypt Time
    encrypttime = Encryptend - Encryptstart

    # Decrypt time
    decrypttime = Decryptend - Decryptstart

    # cpu and memory cal
    memory = psutil.virtual_memory()
    cpu = psutil.cpu_percent(interval=1)

    # Print
    Algorithms().display(encrypttime, decrypttime, cpu, memory, 'RSA')

 def UserInput(self):

    ExecutionSelect = input("Start or End execution")

    while(ExecutionSelect != "End"):

        AlgorithmSelect = input("Select Algorithm: AES, Blowfish, TDES, DES, RSA, All (all algorithms)")

        DataSizeSelect = input("Select Data size (MB): Testing (1KB), 20, 40, 60, 80, 100")

        if (DataSizeSelect == "Testing"):
            DataSizeSelect = "C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\Testing.txt"

        elif (DataSizeSelect == "20"):
            DataSizeSelect = "C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\Test 20.txt"

        elif (DataSizeSelect == "40"):
            DataSizeSelect = "C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\Test 40.txt"

        elif (DataSizeSelect == "60"):
            DataSizeSelect = "C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\Test 60.txt"

        elif (DataSizeSelect == "80"):
            DataSizeSelect = "C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\Test 80.txt"

        elif (DataSizeSelect == "100"):
            DataSizeSelect = "C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\Test 100.txt"

        else:
            print("Invalid data input, try again")
            self.UserInput()

        if (AlgorithmSelect == "AES"):
            self.AES_call(DataSizeSelect)
            self.UserInput()

        elif (AlgorithmSelect == "Blowfish"):
            self.Blowfish_call(DataSizeSelect)
            self.UserInput()

        elif (AlgorithmSelect == "TDES"):
            self.TDES_call(DataSizeSelect)
            self.UserInput()

        elif (AlgorithmSelect == "DES"):
            self.DES_call(DataSizeSelect)
            self.UserInput()

        elif (AlgorithmSelect == "RSA"):
            self.RSA_call()
            self.UserInput()

        elif (AlgorithmSelect == "All"):
            self.AES_call(DataSizeSelect)
            self.Blowfish_call(DataSizeSelect)
            self.TDES_call(DataSizeSelect)
            self.DES_call(DataSizeSelect)
            self.RSA_call()
            self.UserInput()

        else:
            print("Invalid algorithm input, try again")
            self.UserInput()

        break

 def display(self,encrypttime,decrypttime,cpu,memory,algotype):
     print(algotype," Memory usage: ", memory)
     print(algotype," CPU usage: ", cpu)
     print(algotype," Encryption time: ", encrypttime)
     print(algotype," Decryption time: ", decrypttime)
     print("------------------------------------------------")

# The __name__ identifier is bound to the name of any module as it's being imported.
# However, when a file is being executed then __name__ is set to "__main__" (the literal string: __main__).
# This is used to separate the portion of code which should be executed from the portions of code which define functionality.

if __name__ == '__main__':
 Algorithms().UserInput()
